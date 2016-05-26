package com.weixin.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.controller.HelloController;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;

/**
 * 
 * @author jay
 *
 */
public class ShareServlet extends HttpServlet {

	private static final long serialVersionUID = -1847238807216447030L;

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String code = request.getParameter("code");
		// getRequestURI getRequestURL区别
		String url = request.getRequestURL().toString();
		
		String accessToken = WeixinUtil.getAccessToken().getAccessToken();
		String jsapi = WeixinUtil.getJsapiToken(accessToken);
		
		Map<String, String> map = Sign.sign(jsapi, url);

		
		map.put("appId", TokenThread.APPID);
		map.put("title", "测试标题");
		map.put("link", "http://scorpionjay.github.io/");
		map.put("desc", "测试内容");
		map.put("imgUrl", "https://avatars0.githubusercontent.com/u/8603342?v=3&u=d5c989c2b7f53d84c60542d354d7a75a89d9e114&s=140");
		
		request.setAttribute("wxInfo", map);
		
		request.getRequestDispatcher("shareTest.jsp").forward(request, response);
	}
}
