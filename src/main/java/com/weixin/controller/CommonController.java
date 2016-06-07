package com.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jay
 * @since 2016年6月7日
 */
@Controller
public class CommonController {

	private static final Logger log = LoggerFactory.getLogger(CommonController.class);

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
		return "index.html";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public String user() {
		log.info("thymeleaf");
		return "greet";
	}

}
