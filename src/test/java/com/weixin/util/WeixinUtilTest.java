package com.weixin.util;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.app.Application;
import com.weixin.service.iface.WxService;
import com.weixin.vo.WechatVo;

/**
* @author	jay
* @since	2016年6月12日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class WeixinUtilTest {

	@Autowired
	WxService wxService;
	
	@Test
	public void testDoGetStr() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoGetStr2() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPostStr() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAccessToken() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAccessTokenStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOauth2AccessTokenStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOauth2AccessTokenString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaterial() {
		WeixinUtil.getMaterial("RAXYqeU-aVSjeSzVQMROsx7DkkFN8ATTkjIxvxrpEPQasfPz2guXpqIPwhl2gtogtzaJnei_rWU-x9Pb_VX4AQWVuGTcdjIjCVaU0ZK-gDcdk-La_iO6xnB8le_xE2vRYFNaAEAELT");
	}

	@Test
	public void testGetJsapiToken() {
		fail("Not yet implemented");
	}

	@Test
	public void testMediaUpload() {
	
		
		File file = new File("f:/test.jpg");
		
		WechatVo vo = wxService.findByTitle("jay's test account");
		WeixinUtil.mediaUpload(vo.getToken(), file, "image");
		
	}

}
