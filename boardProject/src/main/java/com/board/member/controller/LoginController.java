package com.board.member.controller;

import java.io.Console;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.member.service.MemberService;
import com.board.user.vo.UserVo;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class LoginController {

	@Autowired
	MemberService memberService;
	
	
	
	@GetMapping("/main")
	public String main(Model model) {
		 Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		
		 UserVo userVo = memberService.getUserId(id);
//	        userVo.setPassword(null); // password는 보이지 않도록 null로 설정
//	        ((Object) model).addAttribute("user", userVo);
		 return "/member/main";
		
	}

	

	@GetMapping("/login")
	
	public String login(Model model ) {
		
	
		return "login";
	}

	@GetMapping("/loginProc")
	public String loginAction(@RequestParam("userName") String userName,
							  @RequestParam("password") String password, Model model,
							  HttpServletRequest req, HttpServletResponse resp) {
		//TODO : spring boot log 적용
		log.info("wefwefwef");
		log.debug("wefwefwef");
		log.trace("wefwefwef");
		log.error("wefwefwef");
		System.out.println("=="+userName);
	
		return "/login";
		 
	}
	 @GetMapping("/logout")
	    public String logout() {
	        return "logout";
	    }

}

