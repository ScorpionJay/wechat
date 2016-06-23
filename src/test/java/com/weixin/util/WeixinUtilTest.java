package com.weixin.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.app.Application;
import com.weixin.service.iface.WxService;
import com.weixin.vo.WxArticleVo;
import com.weixin.vo.NewsVo;
import com.weixin.vo.WechatVo;

/**
* @author	jay
* @since	2016年6月12日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class WeixinUtilTest {

	@Autowired
	private WeixinUtil weixinUtil;
	
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
		WechatVo vo = wxService.findByTitle("jay's test account");
//		weixinUtil.getMaterial(vo.getToken(),"X-fJF8E32mDZQnq6XgyDBTI7iriawzkKNQv2QzrzrYg");
		weixinUtil.getMaterial(vo.getToken(),"X-fJF8E32mDZQnq6XgyDBaBEx3KMckF_oePNQfBjt4I");
		
	}

	@Test
	public void testGetJsapiToken() {
		fail("Not yet implemented");
	}

	@Test
	public void testMediaUpload() {
	
		
		File file = new File("f:/test.jpg");
		
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.mediaUpload(vo.getToken(), file, "image");
		
	}
	
	@Test
	public void testGetMedia(){
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.getMedia(vo.getToken(), "T7Nk3B95drKWVXL5HaLV06Ka93vUYZfoxsGlECIO7wM632K8-W5N2zJYxTGBxgAk");
	}

	
	@Test
	public void testUploadImg() {
		File file = new File("f:/test.jpg");
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.uploadImg(vo.getToken(), file);
	}
	
	@Test
	public void testMaterialAdd() {
		File file = new File("f:/jay.jpg");
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.materialAdd(vo.getToken(), file,"image");
		
	}
	
	@Test
	public void testMeterialAddNews() {
		WechatVo vo = wxService.findByTitle("jay's test account");
		
		NewsVo newsVo = new NewsVo();
		
		WxArticleVo WxArticleVo = new WxArticleVo("test", "X-fJF8E32mDZQnq6XgyDBdTSYbO_sGK_u6QPYGqZpJk", "jay", "简介", 1, "这是测试内容", "http://scorpionjay.github.io/");
		
		List<WxArticleVo> list = new ArrayList<>();
		list.add(WxArticleVo);
		
		newsVo.setArticles(list);
		
		weixinUtil.meterialAddNews(vo.getToken(), newsVo);
		
	}
	
	@Test
	public void testGetMeteialCount() {
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.getMeteialCount(vo.getToken());
		
	}
	
	@Test
	public void testGetMeteialList() {
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.getMeteialList(vo.getToken());
		
	}
	
	@Test
	public void testSendALL() {
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.sendALL(vo.getToken());
		
	}
	
	
	@Test
	public void testMessagePreview() {
		WechatVo vo = wxService.findByTitle("jay's test account");
		weixinUtil.messagePreview(vo.getToken(),"test openId");
		
	}
}
