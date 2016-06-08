/**
 *	Copyright (c) 2016 Mars 
 */

package com.weixin.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.app.Application;
import com.weixin.service.iface.WxService;
import com.weixin.vo.WechatVo;

/**
* @author Jay
* @since  2016-6-8
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class WxServcieImplTest {

	private Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

	@Autowired
	WxService wxService;
	
	@Test
	public void testAddWechat() {
		WechatVo vo = new WechatVo();
		vo.setAppId("wx8dfda79a073efa18");
		vo.setAppSecret("43b865a6d62dfdec8681ccaf9f804533");
		vo.setTitle("jay's test account");
		wxService.addWx(vo);
		logger.info("add complete");
	}

	@Test
	public void testFindByTilte() {
		WechatVo vo = wxService.findByTitle("jay's test account");
		logger.info(vo.toString());
	}

	@Test
	public void testUpdate() {
		WechatVo vo = new WechatVo();
		vo.setTitle("jay's test account");
		vo.setToken("test");
		wxService.update(vo);
	}
	
	@Test
	public void testDelete() {
		wxService.delete("575821b02530e281000fa81c");
	}

}
