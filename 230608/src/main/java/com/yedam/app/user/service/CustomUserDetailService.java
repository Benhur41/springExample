package com.yedam.app.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.user.mapper.UserMapper;


public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO	userVo = userMapper.getUser(username);
		
		// 해당 사용자 존재유무 확인
		if(userVo == null) {
			throw new UsernameNotFoundException("no user");
		}
		
		// 비밀번호 확인
		
		
		// 권한 지정
//		List<GrantedAuthority> auth = new ArrayList<>();
//		auth.add(new SimpleGrantedAuthority(userVo.getRole()));
		
		return userVo;
	}

}
