package com.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.util.CheckUtil;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;
import com.weixin.vo.AccessToken;
import com.weixin.vo.ResultVo;


@Controller
@RequestMapping(value="wx")
public class WxController {

	private static final Logger log = LoggerFactory.getLogger(WxController.class);

	
	@Autowired
	private WeixinUtil weixinUtil;
	
	
	@RequestMapping(value = "token")
	@ResponseBody
	public ResultVo getToken(String appId, String appSecret) {
		log.info("get token >>> appId: {} appSecret {}" ,appId,appSecret);
		
		ResultVo resultVo = new ResultVo();
		
		AccessToken accessToken = weixinUtil.getAccessToken(appId, appSecret);
		
		resultVo.setObj(accessToken.getAccessToken());
		
		// 修改线程中的token 和检验的token
		TokenThread.setAPPID(appId);
		TokenThread.setAPPSECRET(appSecret);
		
		TokenThread.setAccessToken(accessToken);
		
		log.info("-------------------------");
		log.info(TokenThread.APPID);
		log.info(TokenThread.APPSECRET);
		

		
		return resultVo;
	}


}
