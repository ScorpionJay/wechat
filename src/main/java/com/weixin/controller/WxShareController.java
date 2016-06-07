package com.weixin.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.util.Sign;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;
import com.weixin.vo.WxShareVo;

/**
 * 微信分享控制器
*  @author jay
*  @since  2016年6月3日
*/
@Controller
@RequestMapping(value="share")
public class WxShareController {
	
	private static final Logger log = LoggerFactory.getLogger(WxShareController.class);

	@RequestMapping(value = "test")
	@ResponseBody
	public WxShareVo shareTest(String url) {
		log.info("share test");
		// getRequestURI getRequestURL区别
		
		String accessToken = TokenThread.accessToken.getAccessToken();
		String jsapi = WeixinUtil.getJsapiToken(accessToken);
		Map<String, String> map = Sign.sign(jsapi, url);
		
		WxShareVo wxShareVo = new WxShareVo();
		wxShareVo.setAppId(TokenThread.APPID);
		wxShareVo.setDesc("测试内容");
		wxShareVo.setImgUrl("https://avatars0.githubusercontent.com/u/8603342?v=3&u=d5c989c2b7f53d84c60542d354d7a75a89d9e114&s=140");
		wxShareVo.setLink("测试标题");
		wxShareVo.setTitle("测试标题");
		wxShareVo.setMap(map);
		
		return wxShareVo;
	}

	

}
