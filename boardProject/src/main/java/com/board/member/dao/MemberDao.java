package com.board.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.user.vo.UserVo;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public UserVo getUserById(String userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("userMapper.findId", userId);
	}

	public UserVo getUserById(Long id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("userMapper.findId", id);
	}





	}

