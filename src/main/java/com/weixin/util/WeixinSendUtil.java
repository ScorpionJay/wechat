package com.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.controller.HelloController;

import net.sf.json.JSONObject;

/**
 * @author       Jay
 */
public class WeixinSendUtil {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	private static final String SEND_ALL_URL= "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	private static final String ADD_CUSTOMER_SERVICE_URL= "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	
	
	public static void sendAll(){
		String url = SEND_ALL_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken().getAccessToken());
		String content = "{\"filter\":{\"is_to_all\":true},\"text\":{ \"content\":\"CONTENT test\"},\"msgtype\":\"text\"}";
		JSONObject jsonObject = WeixinUtil.doPostStr(url, content);
		log.info(jsonObject.toString());
	}

	public static void addCustomerService(){
		String url = ADD_CUSTOMER_SERVICE_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken().getAccessToken());
		String content = "{\"kf_account\":\"test1@test\",\"nickname\":\"客服1\",\"password\":\"pswmd5\"}";
		JSONObject jsonObject = WeixinUtil.doPostStr(url, content);
		log.info(jsonObject.toString());
	}
	
}
