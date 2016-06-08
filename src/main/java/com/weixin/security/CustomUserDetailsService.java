package com.weixin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.weixin.service.iface.UserService;
import com.weixin.vo.UserVo;

/**
*@author	jay
*@since		2016年6月7日
*/
public class CustomUserDetailsService implements UserDetailsService {

	private Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info(username);
		
		// 这里去查询
		UserVo userVo =	userService.findByUserName(username);
		
		SecurityUser user = new SecurityUser();
		if(userVo != null){
			user.setName(username);
			user.setPassword(userVo.getPassword());
		}
		
		return user;
	}
	

}
