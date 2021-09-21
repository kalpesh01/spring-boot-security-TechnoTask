package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.dao.User;
import com.app.repo.UserRepo;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = this.userRepo.findUser(email);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("Could not found user !!");
		}
		
		CustomUserDetails customerUserDetails= new CustomUserDetails(user);
		
		return customerUserDetails;
	}

}
