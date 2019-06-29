package com.multiDb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.multiDb.domain.MyAuthInfo;
import com.multiDb.domain.harang.MemberDTO;
import com.multiDb.service.MultiDbService;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider{

	@Autowired
	MultiDbService MultiDbService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String id = authentication.getName();
		//이거 내가 원하는 값이 아닐 수 있다.
		String password = authentication.getCredentials().toString();
		
		MemberDTO mdto = MultiDbService.findUserInfo(id);
		
		// email에 맞는 user가 없거나 비밀번호가 맞지 않은 경우
		if(null==mdto || !mdto.getM_pw().equals(password)) {
			return null;
		}
		
		//GrantedAuthority
		//SimpleGrantedAuthority
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		
		String auth = MultiDbService.findUserAuth(id);
		
		if(auth.equals("ROLE_ADMIN")) {
			grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		else if(auth.equals("ROLE_NEWBEE")) {
			grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_NEWBEE"));
		}
		else {
			grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
			
		}
		
        // 로그인 성공시 로그인 사용자 정보 반환
        return new MyAuthInfo(id, password, grantedAuthorityList, mdto);

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	

}