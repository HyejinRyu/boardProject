package com.board.user.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.bo.vo.BoardVo;
import com.board.user.sevice.UserService;
import com.board.user.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController<ModelAndeView> {

	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/user")
	public String user() {
		return "user/User";
	}
	
	@GetMapping("/userList")
	public String userList(UserVo userVo, Model model) {
	
		List<UserVo> user = userService.userList(userVo);

		model.addAttribute("user", user);
		return "user/UserList";
	}	
	
	@PostMapping("/idChkAction")
	public ModelAndView idChkAction(@RequestBody String id) {
		ModelAndView model = new ModelAndView();
		

		String userId = id;
//		@RequestBody Map<String,String> param
//		int idCheck = userService.findId(param.get("id"));
		int idCheck = userService.findId(userId);

		model.addObject("idCheck", idCheck);
		model.setViewName("jsonView");

	return model;
	}

	@PostMapping("/joinUser")
	public ModelAndView joinUser(@RequestBody Map<String ,Object> params) {

		ModelAndView model = new ModelAndView();

		String id = (String) params.get("id");
		String user_name = (String) params.get("name");
		String orPwd = (String) params.get("pwd");

		UserVo newUser = new UserVo();
		newUser.setId(id);
		newUser.setUser_name(user_name);
		newUser.setPwd(encoder.encode(orPwd));

		userService.joinUser(newUser);
		model.addObject(newUser);
		model.setViewName("jsonView");
		return model;
	}
	
	@GetMapping("/userDetail")
	public String userDetail(@RequestParam Map<String ,Object> param, Model model) {

		String ss = (String) param.get("id");
		UserVo user = userService.userDetail(ss);
		model.addAttribute("item", user);

		return "user/UserEdit";
	}

	@PostMapping("/userDelete")
	public ModelAndView userDelete(@RequestBody Map<String, Object> param) {

		ModelAndView model = new ModelAndView("jsonView");

		List<String> usrList = (List<String>) param.get("userArray");

		for (int i = 0; i < usrList.size(); i++) {
			// 특정 값 포함 여부를 확인하기 위한 if 조건문
			if (usrList.get(i).toString().contains("둘")) {
				break; // 반복문 탈출
			}
			String ss = usrList.get(i).toString();

			userService.deleteUser(ss);
		}
		int cnt = 0;
		if (usrList.size() > 0) {

			cnt = userService.userDelete(usrList);
		}
		model.addObject("cnt", cnt);
		return model;
	}
}
