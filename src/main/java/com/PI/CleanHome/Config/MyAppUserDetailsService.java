package com.PI.CleanHome.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PI.CleanHome.model.Admin;
import com.PI.CleanHome.model.Cleaner;
import com.PI.CleanHome.model.Cliente;
import com.PI.CleanHome.service.AdminService;
import com.PI.CleanHome.service.CleanerService;
import com.PI.CleanHome.service.ClienteService;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private	ClienteService clienteService;
	@Autowired
	private	CleanerService cleanerService;
	@Autowired
	private	AdminService adminService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cliente = clienteService.findByEmail(email);
		Cleaner cleaner = cleanerService.findByEmail(email);
		Admin admin = adminService.findByEmail(email);
		GrantedAuthority authority;
		UserDetails userDetails;
		
		if(cliente != null) {
			authority = new SimpleGrantedAuthority(cliente.getRole());
			
			userDetails = (UserDetails)new User(cliente.getEmail(),
					cliente.getSenha(), Arrays.asList(authority));
		} else if(cleaner != null) {
			authority = new SimpleGrantedAuthority(cleaner.getRole());
			
			userDetails = (UserDetails)new User(cleaner.getEmail(),
					cleaner.getSenha(), Arrays.asList(authority));
		} else{
			authority = new SimpleGrantedAuthority(admin.getRole());
			
			userDetails = (UserDetails)new User(admin.getEmail(),
					admin.getSenha(), Arrays.asList(authority));
		}
		
		
		return userDetails;
	}
	
} 
