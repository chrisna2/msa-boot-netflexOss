package com.multiDb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.multiDb.service.impl.AuthProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan(basePackages = {"com.multiDb.*"})
public class BdsMultiSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AuthProvider authProvider;
	
	@Autowired
	AuthFailureHandler authFailureHandler;
	
	@Autowired
	AuthSuccessHandler authSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 로그인 설정
		http.authorizeRequests()
			//ROLE_USER, ROLE_ADMIN으로 권한 분리 URL정의
			.antMatchers("/","/error**").permitAll()
			.antMatchers("/member/**").access("ROLE_MEMBER") 
			.antMatchers("/admin/**").access("ROLE_NEWBEE")
			.antMatchers("/newbee/**").access("ROLE_ADMIN")
		.and()
			//로그인 관련 설정
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.failureHandler(authFailureHandler)
			.successHandler(authSuccessHandler)
			.usernameParameter("m_id")
			.passwordParameter("m_pw")
		.and()
			//로그아웃 관련 설정
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
		.and()
			.csrf()
		.and()
			.authenticationProvider(authProvider);
	}
}
