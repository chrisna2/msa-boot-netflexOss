package com.multiDb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.multiDb.service.MultiDbService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	MultiDbService mdService;
	
	@RequestMapping("/taskList")
	public void showTaskList(Model model) {
		model.addAttribute("list", mdService.getTaskList());
	}
	
	@RequestMapping("/taskList3")
	public void showTaskList3(Model model) {
		model.addAttribute("list", mdService.getTaskList3());
	}
	
	@GetMapping("/taskIUD")
	public void setTaskIUD(Model model, HttpServletRequest req) {
		int idx = Integer.parseInt(req.getParameter("idx"));
		log.info("★TASK_INFO : "+mdService.getTaskInfo(idx).toString());
		model.addAttribute("vo", mdService.getTaskInfo(idx));
	}
	
	@PostMapping("/taskIUD")
	public String runTask(@RequestParam Map<String,Object> map,RedirectAttributes rttr) {
		//화면에 TASK_ID 입력이 필요함
		log.info("★TASK_INFO : "+map);
		
		String result = "";
		
		//result = mdService.runTask(map);
		
		List<Map<String,Object>> testMap = new ArrayList<Map<String,Object>>();	
		
		testMap.add(map);
		
		result = mdService.runTask(testMap,":",",",";");
		
		rttr.addFlashAttribute("result",result);
		
		return "redirect:/board/taskList3";
	}
	
	

}
