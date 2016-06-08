package com.weixin.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.service.iface.UserService;
import com.weixin.vo.UserVo;

/**
 * @author jay
 * @since 2016年6月7日
 */
@Controller
public class CommonController {

	private static final Logger log = LoggerFactory.getLogger(CommonController.class);

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login() {
		log.info("login");
		return "login";
	}
	
	@RequestMapping("/")
	public String login(Model model) {
		log.info("thymeleaf");
		model.addAttribute("hello", "Hello------");
		model.addAttribute("world", "World------");
		model.addAttribute("username", "test");
		
		Set<UserVo> users = userService.findAllUsers();
		log.info(users.toString());
		return "index";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public String user() {
		log.info("thymeleaf");
		return "greet";
	}

}
