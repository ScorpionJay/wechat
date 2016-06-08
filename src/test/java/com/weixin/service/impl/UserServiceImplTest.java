package com.weixin.service.impl;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.app.Application;
import com.weixin.service.iface.UserService;
import com.weixin.vo.UserVo;

/**
 * @author jay
 * @since 2016年6月8日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserServiceImplTest {

	private Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

	@Autowired
	UserService userService;

	@Test
	public void tesSaveUser() {
		UserVo vo = new UserVo();
		vo.setUserName("jay");
		vo.setPassword("jay123");
		userService.addUser(vo);
	}
	
	@Test
	public void testFindByUsername() {
		userService.findAllUsers();
		logger.info("----");
	}

	@Test
	public void testFindAllUsers() {
		Set<UserVo> users = userService.findAllUsers();
		logger.info(users.toString());
	}
	
	

}
