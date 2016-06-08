package com.weixin.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.service.iface.WxService;
import com.weixin.util.CheckUtil;
import com.weixin.util.MessageUtil;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;
import com.weixin.vo.AccessToken;
import com.weixin.vo.ResultVo;
import com.weixin.vo.WechatVo;

import net.sf.json.JSONObject;

/**
 * 微信控制器
 * @author jay
 * @since  2016年6月3日
 */
@Controller
@RequestMapping(value="wx")
public class WxController {

	private static final Logger log = LoggerFactory.getLogger(WxController.class);
	
	@Autowired
	private WxService wxService;
	
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
		
		WechatVo wechatVo =  new WechatVo();
		wechatVo.setId("5758256f2530b3e6080571a1"); // hard code
		wechatVo.setAppId(appId);
		wechatVo.setAppSecret(appSecret);
		wechatVo.setToken(accessToken.getAccessToken());
		
		wxService.update(wechatVo);
		
		return resultVo;
	}

	@RequestMapping(value = "check",method= RequestMethod.GET)
	public void check(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.info("check");
		
		String signature = request.getParameter("signature");	
		String timestamp = request.getParameter("timestamp");	
		String nonce = request.getParameter("nonce");	
		String echostr = request.getParameter("echostr");	
		PrintWriter out =  response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}
	
	@RequestMapping(value = "check",method= RequestMethod.POST)
	public void wxPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =  response.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
			
			log.info(JSONObject.fromObject(map).toString());
			
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String createTime = map.get("CreateTime");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String msgId = map.get("MsgId");
			System.out.println(content);
			String message = null;
			
			String nickName = "";//WechatUtil.getUser( WechatUtil.getAccessToken().getAccessToken(), fromUserName).getString("nickname");
			
			String msg = nickName;
			
			if("text".equals(msgType)){
				if("hi".equals(content)){
					msg +=  " hi";
				}else if("你好".equals(content)){
					msg += " 你也好☺";
				}else if(content.contains("公交卡")){
					String result = WeixinUtil.doGetStr2("http://220.248.75.36/handapp/PGcardAmtServlet?arg1="+ content.replaceAll("[^x00-xff]*", ""));
					result = result.substring(6,result.length()-3);
					msg += "公交卡余额" + result;
				}else if(content.contains("123")){
					//msg += " 页面跳转 <a href='http://scorpioner.xicp.net/wechat/index.html?id="+ fromUserName 
					//		+" &token= "+ WechatUtil.getAccessToken().getAccessToken()+"&nickName="+  nickName +"'>跳转</a>" ;
					System.out.println(msg);
				}else{
					msg += "OMG!!!";
					log.info(msg);
				}
				message = MessageUtil.initText(toUserName, fromUserName, msg);
			}else if("event".equals(msgType) && map.get("Event").equals("CLICK")){
			
				msg += "您好！您还没有绑定，请先绑定！ <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ TokenThread.APPID +"&redirect_uri=http://wind.zicp.net/wechat/oauth.do&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect'>bind</a>";
				//msg += "您好！您还没有绑定，请先绑定！ <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8dfda79a073efa18&redirect_uri=http%3A%2F%2Fwind%2Engrok%2Eio%2Fwechat%2FoauthServlet&response_type=code&scope=snsapi_base&state=123#wechat_redirect'>绑定</a>";
				//msg += " <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=http%3A%2F%2Fchong.qq.com%2Fphp%2Findex.php%3Fd%3D%26c%3DwxAdapter%26m%3DmobileDeal%26showwxpaytitle%3D1%26vb2ctag%3D4_2030_5_1194_60&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect'>click base</a>";
				//msg += " <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=http%3A%2F%2Fchong.qq.com%2Fphp%2Findex.php%3Fd%3D%26c%3DwxAdapter%26m%3DmobileDeal%26showwxpaytitle%3D1%26vb2ctag%3D4_2030_5_1194_60&response_type=code&scope=snsapi_base&state=123#wechat_redirect'>click</a>";
				log.info(msg);
				message = MessageUtil.initText(toUserName, fromUserName, msg);
			
			}else if("location".equals(msgType)){// 地址
				msg += "您的地址是：" + map.get("Label");
				message = MessageUtil.initText(toUserName, fromUserName, msg);
			}
			
			log.info("token: "+TokenThread.accessToken.getAccessToken());
			
			out.print(message);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get flower users
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "users")
	@ResponseBody
	public ResultVo getUsers() throws Exception {
		ResultVo resultVo = new ResultVo();
		Object obj = WeixinUtil.getUsers(TokenThread.accessToken.getAccessToken());
		resultVo.setObj(obj);
		return resultVo;
	}
	
}
