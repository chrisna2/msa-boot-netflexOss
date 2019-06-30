package com.multiDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiDb.domain.BookVo;
import com.multiDb.domain.EmpVo;
import com.multiDb.domain.TestTableVo;
import com.multiDb.service.MultiDbService;

@RestController
public class MultiDbController {
	
	@Autowired
	MultiDbService multiDbService;
    
    @RequestMapping("/bookInfo")
    public List<BookVo> bookInfo() throws Exception{
    	return multiDbService.bookInfo();
    }
    
    @RequestMapping("/empInfo")
    public List<EmpVo> empInfo() throws Exception{
    	return multiDbService.empInfo();
    }
    
    @RequestMapping("/BdsTestInfo")
    public List<TestTableVo> BdsTestInfo() throws Exception{
    	return multiDbService.getTestTableList();
    }
    
    
}
