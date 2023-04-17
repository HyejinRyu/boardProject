package com.board.user.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import com.board.user.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public int findId(String userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("userMapper.findId", userId);
	}
	public List<UserVo> joinUser(UserVo newUser) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("userMapper.joinUser", newUser);
	}
	public List<UserVo> userList(UserVo userVo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("userMapper.userList", userVo);
	}
	public UserVo userDetail(String ss) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("userMapper.userDetail", ss);
	}
	public int userDelete(String usrList) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("userMapper.userDelete", usrList);
	}
	public void usrCreate(String ss) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.selectList("userMapper.deleteUser", ss);
	}
	public UserVo searchId(String userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("userMapper.searchId", userId);
	}



}
