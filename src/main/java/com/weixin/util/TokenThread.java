package com.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.controller.HelloController;
import com.weixin.vo.AccessToken;

/**
 * @author       Jay
 * 获取token的线程
 */
public class TokenThread implements Runnable{
	
	//private static Logger log = Logger.getLogger(TokenThread.class); 
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
    public static String APPID = "wx8dfda79a073efa18";    
    public static String APPSECRET = "43b865a6d62dfdec8681ccaf9f804533";
    public static AccessToken accessToken = null;    
    
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

	public static String getAPPID() {
		return APPID;
	}

	public static void setAPPID(String aPPID) {
		APPID = aPPID;
	}

	public static String getAPPSECRET() {
		return APPSECRET;
	}

	public static void setAPPSECRET(String aPPSECRET) {
		APPSECRET = aPPSECRET;
	}

	public static AccessToken getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(AccessToken accessToken) {
		TokenThread.accessToken = accessToken;
	}  
    
    
    
}
