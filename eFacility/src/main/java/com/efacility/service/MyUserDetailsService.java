package com.efacility.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.efacility.dao.UserDao;
import com.efacility.model.Employee;
import com.efacility.model.UserRole;
import com.efacility.web.TestController;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Employee employee = userDao.findByUserName(userName);
		List<GrantedAuthority> authorities = buildUserAuthority(employee.getUserRole());
		return buildUserForAuthentication(employee, authorities);
	}
	
	private User buildUserForAuthentication(Employee employee, List<GrantedAuthority> authorities) {
		return new User(employee.getId(), employee.getPassword(), true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		//Build User's Authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole()));
		}
		
		return new ArrayList<>(setAuths);
	}
}
