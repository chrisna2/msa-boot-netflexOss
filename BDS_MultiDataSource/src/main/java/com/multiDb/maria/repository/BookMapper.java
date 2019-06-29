package com.multiDb.maria.repository;

import java.util.List;

import com.multiDb.domain.BookVo;
import com.multiDb.domain.harang.MemberDTO;

public interface BookMapper {
	
	public List<BookVo> bookInfo();
	
	public MemberDTO findUserInfo(String m_id);
	public String findUserAuth(String m_id);
}
