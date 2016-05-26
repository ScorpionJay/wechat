package com.weixin.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.controller.HelloController;
import com.weixin.util.TokenThread;

/**
 * @author Jay
 */
public class InitServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6319898826127265611L;

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	public void init() throws ServletException {

		TokenThread.APPID = getInitParameter("APPID");
		TokenThread.APPSECRET = getInitParameter("APPSECRET");
		
		log.info("appid:" + TokenThread.APPID);
		log.info("appsecret:" + TokenThread.APPSECRET);
		
		// start token thread
		new Thread(new TokenThread()).start();
		
	}
}
