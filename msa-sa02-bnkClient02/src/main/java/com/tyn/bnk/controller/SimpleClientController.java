package com.tyn.bnk.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tyn.bnk.service.SimpleService;

@CrossOrigin(origins ="*")
@RestController
public class SimpleClientController {
	
	@Autowired
	SimpleService service;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${eureka.instance.instance-id}")
	String instance_id;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@FunctionalInterface
	interface Convert<F,T>{
		T convert(F from);
	}
	private Convert<ServiceInstance, String> converter = (from) -> {
		
		return from.getHost() + ":" + from.getPort() +"/harang";
	};
	
	
	@HystrixCommand(commandKey = "concept", fallbackMethod = "testFallback")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Map<String,String>> test(){
		
		ResponseEntity<Map<String,String>> response = null;
		Map<String,String> resMap = new HashMap<String, String>();
		
		resMap.put("type","Second Eureka Client!");
		resMap.put("msg","Spring cloud is Hard :-<");
		
		response =new ResponseEntity<Map<String,String>>(resMap, HttpStatus.OK);
		
		return response;
	}
	public ResponseEntity<Map<String,String>> testFallback(){
        try{

        	final String serviceName="concept";
        	
            List<String> Instances
                = this.discoveryClient.getInstances(serviceName)
                									.stream()
                									.filter((service) -> 
                                                    		!instance_id.equals(service.getServiceId()))
                									.map((service) -> converter.convert(service))
                									.collect(Collectors.toList());

            ResponseEntity <Map<String,String>> rest =
				    restTemplate.exchange(URI.create(Instances.get(0)), HttpMethod.GET,null, new ParameterizedTypeReference<Map<String,String>>() {});
            
            return new ResponseEntity<Map<String,String>>(rest.getBody(), HttpStatus.OK);

        }catch(Exception e)
        {
			e.printStackTrace();
        }
        
        return null;
	}
	
	@HystrixCommand(commandKey = "concept", fallbackMethod = "testDataFallback")
	@RequestMapping(value = "/dataCheck", method = RequestMethod.GET)
	ResponseEntity<List<Map<String,String>>> testData(){
		
		ResponseEntity<List<Map<String,String>>> response = null;
		List<Map<String,String>> resMap = new ArrayList<Map<String,String>>();
		
		resMap = service.justSelect();
		
		response =new ResponseEntity<List<Map<String,String>>>(resMap, HttpStatus.OK);
		
		return response;
	}
	public ResponseEntity<List<Map<String,String>>> testDataFallback(){
        try{

        	final String serviceName="concept";
        	
            List<String> Instances
                = this.discoveryClient.getInstances(serviceName)
                									.stream()
                									.filter((service) -> 
                                                    		!instance_id.equals(service.getServiceId()))
                									.map((service) -> converter.convert(service))
                									.collect(Collectors.toList());

            ResponseEntity <List<Map<String,String>>> rest =
				    restTemplate.exchange(URI.create(Instances.get(0)), HttpMethod.GET,null, new ParameterizedTypeReference<List<Map<String,String>>>() {});
            
            return new ResponseEntity<List<Map<String,String>>>(rest.getBody(), HttpStatus.OK);

        }catch(Exception e)
        {
			e.printStackTrace();
        }
        
        return null;
	}
	
	
}
