package com.weixin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author jay
 * @since 2016年6月14日
 */
public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter  {


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		//获取用户名、密码数据  
	    String username = obtainUsername(request);  
	    String password = obtainPassword(request);  
	    String token = request.getParameter("token");
	    if (username == null) {  
	        username = "";  
	    }  
	    if (password == null) {  
	        password = "";  
	    }  
	    
	    username = username.trim(); 
	    System.out.println("hack.................");
	    CustomToken authRequest = new CustomToken(username, password,token);  
	    setDetails(request, authRequest);  
		return this.getAuthenticationManager().authenticate(authRequest);
	}



}
