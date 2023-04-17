package com.board.user.vo;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.experimental.Delegate;
@Data
public class UserVo implements  UserDetails  {

	public String id;
	public String pwd;
	public String user_name;
	public String user_yn;
	public String user_auth;
	public String ins_date;

	// <method>
	// getAuthorities : 계정의 권한 목록 리턴
	// 리턴타입 : Collection<? extends GrantedAuthority>


   
    private UserVo useVo;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

		// dto.getRole(); // String이므로 위에처럼 타입 변환이 필요함

	// getPassword 계정의 비밀번호를 리턴
	@Override
	public String getPassword() {
		return pwd;
	}

	// getUsername : 계정의 고유한 값을 리턴 *PK 값*
	@Override
	public String getUsername() {
		return id;
	}

	// isAccountNonExpired : 계정의 만료 여부 리턴 ( true일시 만료x )
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// isAccountNonLocked : 계정의 잠김 여부 리턴 ( true일시 잠김x )

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// isCredentialsNonExpired : 비밀번호 만료 여부 리턴 ( true일시 만료x )

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// isEnabled : 계정의 활성화 z여부 ( ture면 활성화 o )

	@Override
	public boolean isEnabled() {

		// 1년간 로그인 안한 계정 즉 휴면계정일때 사용

		return true;
	
	}

	
}