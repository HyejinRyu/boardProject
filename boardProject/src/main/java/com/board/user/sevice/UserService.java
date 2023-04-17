package com.board.user.sevice;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.board.user.dao.UserDao;
import com.board.user.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public int findId(String userId) {
		// TODO Auto-generated method stub
		return userDao.findId(userId);
	}

	public List<UserVo> joinUser(UserVo newUser) {
		// TODO Auto-generated method stub
		return userDao.joinUser(newUser);
	}

	public List<UserVo> userList(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.userList(userVo);
	}

	public UserVo userDetail(String ss) {
		// TODO Auto-generated method stub
		return userDao.userDetail(ss);
	}

	public int userDelete(List<String> usrList) {
		int cnt = 0;
		for(int i =0; i < usrList.size(); i++) {
			cnt += userDao.userDelete(usrList.get(i));
		}
		return cnt;
	}

	public void deleteUser(String ss) {
		// TODO Auto-generated method stub
	
		userDao.usrCreate(ss);
	}



	public UserVo getMemberById(String userId) {
		// TODO Auto-generated method stub
		return  userDao.searchId(userId);
	}
	

	}


