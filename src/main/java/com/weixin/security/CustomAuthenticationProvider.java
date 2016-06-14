package com.weixin.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * http://www.cnblogs.com/yjmyzz/p/how-to-custom-filter-provider-and-token-in-
 * spring-security3.html
 * 
 * @author jay
 * @since 2016年6月14日
 */
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// 如果想做点额外的检查,可以在这个方法里处理,校验不通时,直接抛异常即可
		System.out.println("CustomAuthenticationProvider.additionalAuthenticationChecks() is called!");
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		System.out.println("CustomAuthenticationProvider.retrieveUser() is called!");

		String[] whiteLists = new String[] { "ADMIN", "SUPERVISOR", "JIMMY" };

		// 如果用户在白名单里,直接放行(注:仅仅只是演示,千万不要在实际项目中这么干!)
		if (Arrays.asList(whiteLists).contains(username)) {
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			UserDetails user = new User(username, "whatever", authorities);
			return user;
		}

		return new User(username, "no-password", false, false, false, false, new ArrayList<GrantedAuthority>());
	}

}
