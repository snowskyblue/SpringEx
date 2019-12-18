package org.kook.secProject.security;

import java.util.ArrayList;
import java.util.Collection;

import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.dto.UserDto;
import org.kook.secProject.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		BDaoTemplate dao = Constant.dao;
		UserDto dto = dao.login1(username);		
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
