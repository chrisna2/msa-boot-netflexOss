package com.multiDb.postgres.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.multiDb.domain.TaskVo;
import com.multiDb.domain.TestTableVo;

public interface BdsTestMapper {
	
	@Select("select now()")
	public String getTime();
	
	//인터페이스에 지정한 메서드명이 곧 맵퍼의 실행될 쿼리 문
	public String getTimeMapper();
	
	//DB에 저장된 데이터를 확인
	public List<TestTableVo> getTestTableList(); 
	
	//DB에 저장된 데이터를 확인
	public List<TestTableVo> getSrchList(TestTableVo vo); 
	
	//T 테이블 조회
	public List<TestTableVo> getTaskList();
	
	//Task 단건 정보 조회
	public TestTableVo getTaskInfo(int idx);
	
	//T3 테이블 조회
	public List<TestTableVo> getTaskList3();
	
	//TASK 정보 조회 
	public List<TaskVo> findByTaskId(String task_id);
	
	//TASK 정보 입력
	public int insTaskSetInfo(Map<String, Object> map);
	
}