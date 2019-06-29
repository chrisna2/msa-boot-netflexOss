package com.multiDb.domain;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.multiDb.domain.harang.MemberDTO;

public class MyAuthInfo extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = 1L;
	
	private MemberDTO mDto;
	
	public MyAuthInfo(String id, String password, List<GrantedAuthority> grantedAuthorityList, MemberDTO mDto) {
		super(id, password, grantedAuthorityList);
		this.mDto = mDto;
	}
	
	public MemberDTO getmDto() {
		return mDto;
	}

	public void setmDto(MemberDTO mDto) {
		this.mDto = mDto;
	}

}
