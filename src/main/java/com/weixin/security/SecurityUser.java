package com.weixin.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.weixin.entity.User;

/**
 * @author jay
 * @since 2016年6月7日
 */
public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1902779697414925687L;
	
	public SecurityUser() {
	}

	public SecurityUser(User user) {
		if (user != null) {
			this.setId(user.getId());
			this.setName(user.getName());
			this.setEmail(user.getEmail());
			this.setPassword(user.getPassword());
			this.setDob(user.getDob());
			//this.setSRoles(suser.getSRoles());
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
