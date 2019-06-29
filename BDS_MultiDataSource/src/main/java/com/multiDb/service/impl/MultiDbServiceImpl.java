package com.multiDb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiDb.domain.BookVo;
import com.multiDb.domain.EmpVo;
import com.multiDb.domain.TaskVo;
import com.multiDb.domain.TestTableVo;
import com.multiDb.domain.harang.MemberDTO;
import com.multiDb.maria.repository.BookMapper;
import com.multiDb.oracle.repository.EmpMapper;
import com.multiDb.postgres.repository.BdsTestMapper;
import com.multiDb.service.MultiDbService;

import lombok.extern.java.Log;

@Log
@Service
public class MultiDbServiceImpl implements MultiDbService{

	//Oracle
	@Autowired
	EmpMapper empMapper;
	
	//mariaDb
	@Autowired
	BookMapper BookMapper;
	
	//postgreSql
	@Autowired
	BdsTestMapper bdsTestMapper;
	
	@Override
	public List<BookVo> bookInfo() {
		return BookMapper.bookInfo();
	}

	@Override
	public List<EmpVo> empInfo() {
		return empMapper.empInfo();
	}

	@Override
	public List<TestTableVo> getTestTableList() {
		return bdsTestMapper.getTestTableList();
	}

	@Override
	public List<TestTableVo> getTaskList() {
		return bdsTestMapper.getTaskList();
	}

	@Override
	public List<TestTableVo> getTaskList3() {
		return bdsTestMapper.getTaskList3();
	}

	@Override
	public TestTableVo getTaskInfo(int idx) {
		return bdsTestMapper.getTaskInfo(idx);
	}

	@Override
	public String runTask(Map<String,Object> map) {
		
		String taskInfoString = "";
		
		List<TaskVo> resultList =  bdsTestMapper.findByTaskId(map.get("task_id").toString());
		
		Map<String, Object> insMap = new HashMap<String, Object>();
		
		//맵자동 변환
		for(TaskVo i: resultList) {
			// EX] 키/밸류 값 설정은 '=', 각 컬럼 별 구분자는 ','로 설정함
			taskInfoString += i.getTo_col()+"="+map.get(i.getFrom_col()).toString()+",";
			insMap.put(i.getTo_col(),map.get(i.getFrom_col()));
		}
		//실행 출력 문자
		//각 테스크의 구분 자는 ";"로 설정
		taskInfoString = taskInfoString.substring(0,taskInfoString.length()-1)+";";
		
		// <수정사항> 실제 업무 방식과는 다르겠지만 시뮬레이션 상 으로 입력을 통해 실행 결과 확인
		bdsTestMapper.insTaskSetInfo(insMap);
		
		return taskInfoString;
	}

	@Override
	public String runTask(List<Map<String, Object>> listMap, String valSep, String colSep, String taskSep) {
		
		String result = "";
		
		Map<String, Object> insMap = new HashMap<String, Object>();
		
		for(Map<String,Object> task : listMap) {
			//초기화
			insMap.clear();
			List<TaskVo> resultList =  bdsTestMapper.findByTaskId(task.get("task_id").toString());
			//전송문 작성
			for(TaskVo i: resultList) {
				result += i.getTo_col()+valSep+task.get(i.getFrom_col()).toString()+colSep;
				insMap.put(i.getTo_col(),task.get(i.getFrom_col()));
			}
			result = result.substring(0,result.length()-1)+taskSep+System.getProperty("line.separator");
			// <수정사항> 실제 업무 방식과는 다르겠지만 시뮬레이션 상 으로 입력을 통해 실행 결과 확인
			bdsTestMapper.insTaskSetInfo(insMap);
		}
		return 	result;
	}

	@Override
	public String runTask(Map<String, Object> map, String valSep, String colSep, String taskSep) {
		
		String result = "";
		
		Map<String, Object> insMap = new HashMap<String, Object>();
		
		List<TaskVo> resultList =  bdsTestMapper.findByTaskId(map.get("task_id").toString());
		//전송문 작성
		for(TaskVo i: resultList) {
			result += i.getTo_col()+valSep+map.get(i.getFrom_col()).toString()+colSep;
			insMap.put(i.getTo_col(),map.get(i.getFrom_col()));
		}
		result = result.substring(0,result.length()-1)+taskSep+System.getProperty("line.separator");
		// <수정사항> 실제 업무 방식과는 다르겠지만 시뮬레이션 상 으로 입력을 통해 실행 결과 확인
		bdsTestMapper.insTaskSetInfo(insMap);
		
		return 	result;
	}

	@Override
	public MemberDTO findUserInfo(String id) {
		return BookMapper.findUserInfo(id);
	}

	@Override
	public String findUserAuth(String id) {
		return BookMapper.findUserAuth(id);
	}

}
