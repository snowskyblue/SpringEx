package com.kim.security.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kim.security.dao.BDaoTemplate;
import com.kim.security.dto.UserDto;

//spring security를 사용하면 클라이언트에서 요청(j_spring_security_check)하면 이곳으로 요청됨
//FrontController로 가는게 아니라 spring이 알아서 처리함
public class CustomUserDetailsService implements UserDetailsService{
	
	
	//@Autowired 
	//BDaoTemplate bDaoTemplate; //db처리 객체 주입(필드-멤버변수-로 주입)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BDaoTemplate bDaoTemplate = new BDaoTemplate();

		System.out.println(username);
		UserDto dto =  bDaoTemplate.login(username);
		if(dto == null) {
			throw  new UsernameNotFoundException("No user found with username");
		}
		String pw = dto.getPpw();
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(username, pw , roles);

		return user;
	}
}
