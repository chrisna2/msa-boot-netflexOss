package com.tyn.bnk.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tyn.bnk.service.SimpleService;

@CrossOrigin(origins ="*")
@RestController
public class SampleClientController {
	
	@Autowired
	SimpleService service;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@FunctionalInterface
	interface Convert<F,T>{
		T convert(F from);
	}
	
	private Convert<ServiceInstance, String> converter = (from) -> {
		
		return from.getHost() + ":" + from.getPort() +"/harang";
	};
	
	@Bean
	public RestTemplate restTemplate() {
	        return new RestTemplate();
	}
	
	@Value("${eureka.instance.instance-id}")
	String instance_id;
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(commandKey = "harang", fallbackMethod = "justSelectFallback")
	@RequestMapping(value = "/testData", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String,Object>>> justSelect()
	{
		try {
			return new ResponseEntity<List<Map<String,Object>>>
				(service.justSelect().orElseThrow(() -> new NullPointerException()), HttpStatus.OK);
		}
		catch(NullPointerException e) {
			return new ResponseEntity<List<Map<String,Object>>>(HttpStatus.NOT_FOUND);
		}
	}
    public ResponseEntity<List<Map<String,Object>>>  justSelectFallback()
    {
        try{

        	final String serviceName="harang";
        	
            List<String> Instances
                = this.discoveryClient.getInstances(serviceName)
                									.stream()
                									.filter((service) -> 
                                                    		!instance_id.equals(service.getServiceId()))
                									.map((service) -> converter.convert(service))
                									.collect(Collectors.toList());

            ResponseEntity <List<Map<String,Object>>> rest =
				    restTemplate.exchange(URI.create(Instances.get(0)), HttpMethod.GET,null, new ParameterizedTypeReference<List<Map<String,Object>>>() {});
            
            return new ResponseEntity<List<Map<String,Object>>>(rest.getBody(), HttpStatus.OK);

        }catch(Exception e)
        {
			e.printStackTrace();
        }
        
        return null;
    }

	
    @HystrixCommand(commandKey="harang", fallbackMethod = "getHostNameFallback")
    @RequestMapping(value = "/service/host", method = RequestMethod.GET)
    public String getHostName()
    {
        try{        
        	
           return System.getenv("HOSTNAME");

        }
        catch(Exception e)
        {
            return "Cannot find host ";
        }
    }
    public String getHostNameFallback()
    {

        return "Default Host";
    }
    
    @HystrixCommand(commandKey="harang", fallbackMethod = "getServiceInfoFallback")
    @RequestMapping(value = "/service/info/{applicationName}", method = RequestMethod.GET)
    public String serviceInstance(@PathVariable String applicationName) {
        
        try{

            Optional<List<ServiceInstance>> maybeServiceInstance = Optional.of(this.discoveryClient.getInstances(applicationName));

            Function<String,String> makeResult = result -> result;

            ServiceInstance service = maybeServiceInstance.get().get(0);

            return makeResult.apply("ServiceID: " + service.getServiceId()+
                                    ", Host: " + service.getHost()+
                                    ", Port: " + Integer.toString(service.getPort()));

        }catch(Exception e)
        {
            return "Cannot Found Instance " + applicationName;
        }
    }
    public String getServiceInfoFallback(@PathVariable String applicationName)
    {
        return "Default Value";
    }
	
}
