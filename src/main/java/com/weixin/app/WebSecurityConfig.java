package com.weixin.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.weixin.security.CustomUserDetailsService;
import com.weixin.security.LoginSuccessHandler;

/**
 * @author jay
 * @since 2016年6月7日
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// 允许所有用户访问"/" 和 "/greet"
		http.authorizeRequests().antMatchers("/", "/hello", "/login.html", "/app/**", "/wx/**").permitAll()

				// 其他访问均系要验证权限
				.anyRequest().authenticated()

				.and().formLogin()

				// 登录页面是"/login"
				.loginPage("/login").permitAll()

				// 登录成功后存储用户信息c
				.successHandler(loginSuccessHandler()).defaultSuccessUrl("/main").and().logout()

				// 退出后的默认地址
				.logoutSuccessUrl("/login.html").permitAll().logoutUrl("/logout").invalidateHttpSession(true)

				.and().csrf().disable();

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}

	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}

}
