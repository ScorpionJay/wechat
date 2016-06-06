package com.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.controller.HelloController;
import com.weixin.vo.AccessToken;

/**
 * 获取token的线程( 存储appid appsecret token，将来可以使用数据库存放，例如redis缓存起来 )
 * @author       Jay
 * @since		 2016-6-6
 */
public class TokenThread implements Runnable{
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	// 不经常改的变量
    public static String APPID;    
    public static String APPSECRET;
    public static AccessToken accessToken;    
    
    public void run() {    
        while (true) {    
        	log.info("get token");
            try {    
                accessToken = WeixinUtil.getAccessToken();  
                if (null != accessToken) {    
                    log.info(("get access_token success" + accessToken.getExpiresIn() + accessToken.getAccessToken()));   
                    // sleep 7000s    
                    Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);    
                } else {    
                    // if access_token is null，60s will get again    
                    Thread.sleep(60 * 1000);    
                }    
            } catch (InterruptedException e) {    
                try {    
                    Thread.sleep(60 * 1000);    
                } catch (InterruptedException e1) {    
                    log.error("{}", e1);    
                }    
                log.error("{}", e);    
            }    
        }    
    }    
    
}
