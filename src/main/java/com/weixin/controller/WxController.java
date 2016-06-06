package com.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;
import com.weixin.vo.AccessToken;
import com.weixin.vo.ResultVo;

/**
 * 微信控制器
 * @author jay
 * @since  2016年6月3日
 */
@Controller
@RequestMapping(value="wx")
public class WxController {

	private static final Logger log = LoggerFactory.getLogger(WxController.class);
	
	@RequestMapping(value = "token")
	@ResponseBody
	public ResultVo getToken(String appId, String appSecret) {
		
		log.info("get token >>> appId: {} appSecret {}" ,appId,appSecret);
		
		ResultVo resultVo = new ResultVo();
		
		AccessToken accessToken = WeixinUtil.getAccessToken(appId, appSecret);
		
		resultVo.setObj(accessToken.getAccessToken());
		
		// 修改线程中的token 和检验的token
		TokenThread.APPID = appId;
		TokenThread.APPSECRET = appSecret;
		TokenThread.accessToken = accessToken;
		
		log.info("-------------------------");
		log.info(TokenThread.APPID);
		log.info(TokenThread.APPSECRET);
		
		return resultVo;
	}


}
