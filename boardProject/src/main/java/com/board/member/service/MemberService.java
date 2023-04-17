package com.board.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.member.dao.MemberDao;
import com.board.user.vo.UserVo;

@Service
public class MemberService {

	
	@Autowired
	MemberDao memberDao;
	

    @Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		 return new BCryptPasswordEncoder();
	}
	public UserVo getUserById(String userId) {
		// TODO Auto-generated method stub
		 return memberDao.getUserById(userId);
	}

	public UserVo getUserId(Long id) {
		// TODO Auto-generated method stub
		 return memberDao.getUserById(id);
	}
	
	}


