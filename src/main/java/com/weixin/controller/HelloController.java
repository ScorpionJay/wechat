package com.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.entity.User;
import com.weixin.vo.UserVo;

/**
 * 测试控制器
 * 
 * @author jay
 * @since 2016年6月3日
 */
@Controller
public class HelloController {

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "greet")
	@ResponseBody
	public String greet() {
		log.info("greet");
		return "hello this is jay";
	}

	@RequestMapping(value = "greet1")
	@ResponseBody
	public UserVo greet1() {
		log.info("greet1");
		UserVo vo = new UserVo();
		vo.setName("jay");
		vo.setSkill("java");
		return vo;
	}

	@RequestMapping(value = "greet2")
	public String greet2(Model model) {
		model.addAttribute("name", "jay");
		return "hello";

	}

	@RequestMapping(value = "greet3/{name}")
	public String greet3(Model model, @PathVariable String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/thymeleaf")
	public String doIt(Model model) {
		log.info("thymeleaf");
		model.addAttribute("hello", "Hello------");
		model.addAttribute("world", "World------");

		return "test";
	}

	@RequestMapping("/main")
	public String login(Model model) {
		log.info("thymeleaf");
		model.addAttribute("hello", "Hello------");
		model.addAttribute("world", "World------");

		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication	auth = ctx.getAuthentication();
		model.addAttribute("username", "test");
		if(auth.getPrincipal() instanceof UserDetails){
			User user =(User)auth.getPrincipal();
			model.addAttribute("username", user.getName());
		}
		
		
		
		return "main";
	}

}
