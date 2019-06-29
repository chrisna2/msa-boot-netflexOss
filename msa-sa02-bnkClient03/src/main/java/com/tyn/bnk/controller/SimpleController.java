package com.tyn.bnk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@RequestMapping(value = "/threeClientApi", method = RequestMethod.GET)
	ResponseEntity<Map<String,String>> testSample(){
		
		ResponseEntity<Map<String,String>> response = null;
		Map<String,String> resMap = new HashMap<String, String>();
		
		resMap.put("type","Third Eureka Client!");
		resMap.put("msg","Spring cloud is So Hard T_T");
		
		response =new ResponseEntity<Map<String,String>>(resMap, HttpStatus.OK);
		
		return response;
	}
	
	
}
