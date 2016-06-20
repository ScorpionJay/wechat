package com.weixin.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.weixin.security.CustomAuthenticationProvider;
import com.weixin.security.CustomLoginFilter;
import com.weixin.security.CustomUserDetailsService;
import com.weixin.security.LoginSuccessHandler;
import com.weixin.security.LogoutSuccessHandler;

/**
 * @author jay
 * @since 2016年6月7日
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置不拦截规则
		web.ignoring().antMatchers("/app/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// 允许所有用户访问"/" 和 "/greet"
		http.authorizeRequests().antMatchers("/", "/hello", "/login.html", "/wx/**","/api/file/**").permitAll()

				// 其他访问均系要验证权限
				.anyRequest().authenticated();
				
				

				// 禁掉crsf
				
				http.addFilter(customLoginFilter());
				
				http
				.formLogin().loginPage("/login").permitAll().successHandler(loginSuccessHandler()).loginProcessingUrl("/logonUrl")
				.defaultSuccessUrl("/main")
				.usernameParameter("username").passwordParameter("password")
				
				.and().csrf().disable()
				
				
				
				;//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// 无状态
				
				
				//http.authenticationProvider(customAuthenticationProvider());

				// 退出
				http.logout()

				// 退出后的默认地址
				.logoutUrl("/logout").logoutSuccessUrl("/login");//.logoutSuccessHandler(logoutSuccessHandler());

				// session失效
//				.invalidateHttpSession(true);

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
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new LogoutSuccessHandler();
	}
	
	
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		return new CustomAuthenticationProvider();
	}

	@Bean
	public CustomLoginFilter customLoginFilter() throws Exception {
		CustomLoginFilter filter = new CustomLoginFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
