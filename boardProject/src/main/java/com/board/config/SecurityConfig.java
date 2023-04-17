package com.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {
	// 유저가 입력한 정보와 DB정보가 일치하는지 확인

	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable().cors().disable()
	                .authorizeHttpRequests(request -> request
	                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
	                        .requestMatchers("/user/user*","/member/logout","/user/joinUser","/css/**", "/js/**", "/img/**").permitAll()
	                        .anyRequest().authenticated() // 어떠한 요청이라도 인증필요 
	                )
	                //from 방식 로그인 사용 
	                .formLogin(login -> login
	                        .loginPage("/member/login")	// [A] 커스텀 로그인 페이지 지정
	                        .loginProcessingUrl("/member/loginProc")	// [B] submit 받을 url
	                        .usernameParameter("username")	// [C] submit할 아이디
	                        .passwordParameter("password")	// [D] submit할 비밀번호
	                        .defaultSuccessUrl("/member/main", true) //로그인 성공시 메인화면으로 
//	                        .successHandler(loginSuccessHandler()) // 로그인 성공을 다룰 핸들러
//	                        .failureHandler(loginFailHandler()) // 로그인 실패를 다룰 핸들러
	                        .permitAll() //메인화면 이동이 막히면 안되서 허용 
	                )
//	                .logout();  // 로그아웃은 기본설정으로 (/logout으로 인증해제) logout(withDefaults()); withDefaults 안되는지 확인 
	                .logout()
                    .logoutSuccessUrl("/member/login") // 로그아웃 성공시 이동할 URL
        			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")); // 이 URI 호출시 로그아웃

	        
	        return http.build();
	    }

//	 //로그인 성공 핸들러
//	    @Bean
//	    public LoginSuccessHandler loginSuccessHandler(){
//	        return new LoginSuccessHandler();
//	    }
//	  //로그인 실패 핸들러
//	    @Bean
//	    public LoginFailHandler loginFailHandler(){
//	        return new LoginFailHandler();
//	    }
//	 
	}