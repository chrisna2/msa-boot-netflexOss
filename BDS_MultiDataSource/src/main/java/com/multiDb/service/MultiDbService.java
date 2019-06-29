package com.multiDb.service;

import java.util.List;
import java.util.Map;

import com.multiDb.domain.BookVo;
import com.multiDb.domain.EmpVo;
import com.multiDb.domain.TestTableVo;
import com.multiDb.domain.harang.MemberDTO;

public interface MultiDbService {
	
	public List<BookVo> bookInfo();
	public List<EmpVo> empInfo();
	public List<TestTableVo> getTestTableList();
	public List<TestTableVo> getTaskList();
	
	public TestTableVo getTaskInfo(int idx);
	
	public List<TestTableVo> getTaskList3();
	
	/**
	 * TASK를 단건으로 돌릴 경우 실행합니다. 
	 * 키/밸류 값 설정은 '=', 각 컬럼 별 구분자는 ','로 설정함
	 * 
	 * @param map task_id에 해당하는 정보
	 * @param valSep 키와 밸류 사이를 이어주는 구분자
	 * @param colSep 각 컬럼들을 구분하는 구분자
	 * @param taskSep 각 타스크를 구분 하는 구분자
	 * @return 타스크가 실행되는 송신 전문을 구현 합니다.
	 * 
	 * @author Na Hyun kee
	 */
	public String runTask(Map<String,Object> map);
	
	/**
	 * TASK를 목록을 돌릴 경우 실행합니다. 
	 * 각각의 구분자를 설정할수 있습니다.
	 * 
	 * @param listMap task_id 별로 묶인 정보 목록 
	 * @param valSep 키와 밸류 사이를 이어주는 구분자
	 * @param colSep 각 컬럼들을 구분하는 구분자
	 * @param taskSep 각 타스크를 구분 하는 구분자
	 * @return 타스크가 실행되는 송신 전문을 구현 합니다.
	 * 
	 * @author Na Hyun kee
	 */
	public String runTask(List<Map<String,Object>> listMap, String valSep, String colSep, String taskSep);
	
	/**
	 * TASK를 단건으로 돌릴 경우 실행합니다. 
	 * 각각의 구분자를 설정할수 있습니다.
	 * 
	 * @param map taskID에 해당하는 정보
	 * @param valSep 키와 밸류 사이를 이어주는 구분자
	 * @param colSep 각 컬럼들을 구분하는 구분자
	 * @param taskSep 각 타스크를 구분 하는 구분자
	 * @return 타스크가 실행되는 송신 전문을 구현 합니다.
	 * 
	 * @author Na Hyun kee
	 */
	public String runTask(Map<String,Object> map, String valSep, String colSep, String taskSep);
	
	public MemberDTO findUserInfo(String id);
	public String findUserAuth(String id);
	
	
}
