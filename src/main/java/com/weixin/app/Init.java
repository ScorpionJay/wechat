package com.weixin.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.weixin.util.TokenThread;

/**
 * @author 	jay
 * @since 	2016-6-6
 */
@Component
public class Init implements ApplicationRunner {

	private Logger log = LoggerFactory.getLogger(Init.class);
	
	@Autowired
	Environment env;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		TokenThread.APPID = env.getProperty("weixin.appid");
		TokenThread.APPSECRET = env.getProperty("weixin.appsecret");
		
		log.info("appid:" + TokenThread.APPID);
		log.info("appsecret:" + TokenThread.APPSECRET);
		
		// start token thread
		new Thread(new TokenThread()).start();
		
	}

}
