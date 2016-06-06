package com.weixin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.util.Sign;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;

/**
 * 微信分享控制器
*  @author jay
*  @since  2016年6月3日
*/
@Controller
//@RequestMapping(value="share")
public class WxShareController {
	
	private static final Logger log = LoggerFactory.getLogger(WxShareController.class);

	@RequestMapping(value = "test")
	public void shareTest(Model model,HttpServletRequest request, HttpServletResponse response) {
		log.info("share test");
		
		response.setCharacterEncoding("UTF-8");

		// getRequestURI getRequestURL区别
		String url = request.getRequestURL().toString();
		
		String accessToken = TokenThread.accessToken.getAccessToken();
		String jsapi = WeixinUtil.getJsapiToken(accessToken);
		
		System.out.println(url);
		
		Map<String, String> map = Sign.sign(jsapi, url);

		
		map.put("appId", TokenThread.APPID);
		map.put("title", "测试标题");
		map.put("link", "http://scorpionjay.github.io/");
		map.put("desc", "测试内容");
		map.put("imgUrl", "https://avatars0.githubusercontent.com/u/8603342?v=3&u=d5c989c2b7f53d84c60542d354d7a75a89d9e114&s=140");
		
		request.setAttribute("wxInfo", map);
		
		try {
			request.getRequestDispatcher("shareTest.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
