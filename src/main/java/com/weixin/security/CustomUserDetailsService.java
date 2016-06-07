package com.weixin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
*@author	jay
*@since		2016年6月7日
*/
public class CustomUserDetailsService implements UserDetailsService {

	private Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info(username);
		
		// 这里去查询
		
		SecurityUser user = new SecurityUser();
		
		
		if(username.equals("jay")){
			user.setName(username);
			user.setPassword(username);
		}
		
		return user;
	}
	

}
