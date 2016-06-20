package com.weixin.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.Hash;
import com.weixin.vo.AccessToken;
import com.weixin.vo.NewsVo;
import com.weixin.vo.Oauth2Token;
import com.weixin.vo.UserInfo;
import com.weixin.vo.WxMediaVo;

import net.sf.json.JSONObject;

/**
 * @author Jay
 */
@Component
public class WeixinUtil {

	private static final Logger log = LoggerFactory.getLogger(WeixinUtil.class);

	private static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	private static final String GET_USERS_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
	private static final String GET_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	private static final String GET_Oauth2AccessToken_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	private static final String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";

	private static final String GET_JSPAI_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	private static final String MEDIA_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

	private static final String GET_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	
	/**
	 * 添加永久素材
	 */
	private static final String METERIAL_ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	
	/**
	 * 上传图片
	 */
	private static final String UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	
	/**
	 * 上传永久素材
	 */
	private static final String MATERIAL_ADD_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";

	
	/**
	 * 获取素材总数
	 */
	private static final String GET_METERIALCOUNT_URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	
	
	/**
	 * 获取素材列表
	 */
	private static final String GET_METERIALLIST_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	
	/**
	 * 群发
	 */
	private static final String SEND_ALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * get请求
	 * 
	 * @param url
	 * @return
	 */
	public static JSONObject doGetStr(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = JSONObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	public static String doGetStr2(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		String result = "";
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param outStr
	 * @return
	 */
	public static JSONObject doPostStr(String url, String outStr) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		try {
			httpost.setEntity(new StringEntity(outStr, "UTF-8"));
			HttpResponse response = httpClient.execute(httpost);
			String result = EntityUtils.toString(response.getEntity(), "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * get access_token
	 * 
	 * @return
	 */
	public static AccessToken getAccessToken() {
		AccessToken token = new AccessToken();
		String url = GET_ACCESS_TOKEN_URL.replace("APPID", TokenThread.APPID).replace("APPSECRET",
				TokenThread.APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		System.out.println(jsonObject.toString());
		if (jsonObject != null) {
			try {
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println(errorCode + " | " + errorMsg);
			}
		}
		return token;
	}

	public static AccessToken getAccessToken(String appId, String appSecret) {
		AccessToken token = new AccessToken();
		String url = GET_ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret);
		JSONObject jsonObject = doGetStr(url);
		System.out.println(jsonObject.toString());
		if (jsonObject != null) {
			token.setAccessToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}

	/*
	 * Get user list
	 */
	public static List<UserInfo> getUsers(String token) throws ParseException, IOException {
		String url = GET_USERS_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		Object obj = jsonObject.get("data");
		Map<String, List<String>> map = (Map<String, List<String>>) obj;
		List<String> list = map.get("openid");
		List<UserInfo> userList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			UserInfo userInfo = WeixinUtil.getUser(token, list.get(i));
			userList.add(userInfo);
		}

		return userList;
	}

	/*
	 * Get user info
	 */
	public static UserInfo getUser(String token, String openId) throws ParseException, IOException {
		String url = GET_USER_URL.replace("ACCESS_TOKEN", token).replace("OPENID", openId);
		JSONObject jsonObject = doGetStr(url);
		System.out.println("hack");
		System.out.println(jsonObject.toString());
		UserInfo userInfo = new UserInfo();
		if (null != jsonObject) {
			try {
				userInfo = new UserInfo();
				// openId
				userInfo.setOpenId(jsonObject.getString("openid"));
				// 昵称
				userInfo.setNickname(jsonObject.getString("nickname"));
				// 性别
				userInfo.setSex(jsonObject.getInt("sex"));
				// 国家
				userInfo.setCountry(jsonObject.getString("country"));
				// 省
				userInfo.setProvince(jsonObject.getString("province"));
				// 城市
				userInfo.setCity(jsonObject.getString("city"));
				// 图片url
				userInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// privilege
				// userInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"),
				// List.class));
			} catch (Exception e) {
				userInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println(errorCode + " | " + errorMsg);
			}
		}

		return userInfo;
	}

	/**
	 * Get OAuth Access Token
	 */
	public static Oauth2Token getOauth2AccessToken(String appid, String appsecret, String code) {
		String url = GET_Oauth2AccessToken_URL.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE",
				code);
		JSONObject jsonObject = doGetStr(url);
		Oauth2Token oauth2Token = new Oauth2Token();
		if (jsonObject != null) {
			try {
				oauth2Token.setAccessToken(jsonObject.getString("access_token"));
				oauth2Token.setExpiresIn(jsonObject.getInt("expires_in"));
				oauth2Token.setRefreshToken(jsonObject.getString("refresh_token"));
				oauth2Token.setOpenId(jsonObject.getString("openid"));
				oauth2Token.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println(errorCode + " :" + errorMsg);
			}
		}
		return oauth2Token;
	}

	/**
	 * get OAuth access token
	 */
	public static Oauth2Token getOauth2AccessToken(String code) {
		return getOauth2AccessToken(TokenThread.APPID, TokenThread.APPSECRET, code);
	}

	/**
	 * Get material
	 */
	public  void getMaterial(String token,String mediaId) {
		String url = GET_MATERIAL_URL.replace("ACCESS_TOKEN", token);
//		JSONObject jsonObject = doPostStr(url,
//				"{'media_id': 'X-fJF8E32mDZQnq6XgyDBTI7iriawzkKNQv2QzrzrYg");
		Map<String, Object> params = new HashMap<>();
		params.put("media_id", mediaId);
		String result = restTemplate.postForObject(url, params, String.class);

		log.info(result.toString());
		
//		System.out.println(jsonObject.toString());
	}

	/**
	 * Get JSPAI Token
	 */
	public static String getJsapiToken(String token) {
		String url = GET_JSPAI_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		System.out.println(jsonObject.toString());

		return jsonObject.getString("ticket");

	}

	/**
	 * media upload
	 * 
	 * @param token
	 * @param file
	 * @param type
	 * @return
	 */
	public WxMediaVo mediaUpload(String token, File file, String type) {
		String url = MEDIA_UPLOAD_URL.replace("ACCESS_TOKEN", token).replace("TYPE", type);
		// JSONObject jsonObject = doPostStr(url, "{'media': file}");
		// System.out.println(jsonObject.toString());

		FileSystemResource resource = new FileSystemResource(file);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("jarFile", resource);

		// WxMediaVo vo = restTemplate.postForObject(url, param,
		// WxMediaVo.class);

		String str = restTemplate.postForObject(url, param, String.class);

		WxMediaVo vo = null;
		try {
			vo = new ObjectMapper().readValue(str, WxMediaVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info(vo.toString());
		return vo;

	}
	
	/**
	 * get media
	 * @param token
	 * @param mediaId
	 */
	public void getMedia(String token,String mediaId){
		String url = GET_MEDIA_URL.replace("ACCESS_TOKEN", token).replace("MEDIA_ID", mediaId);
		HttpHeaders result = restTemplate.headForHeaders(url);
		log.info(result.toString());
	}

	
	
	/**
	 * 添加图文
	 * @param token
	 * @param newsVo
	 */
	public void meterialAddNews(String token,NewsVo newsVo){
		String url = METERIAL_ADD_NEWS.replace("ACCESS_TOKEN", token);
		String result = restTemplate.postForObject(url, newsVo, String.class);

		log.info(result.toString());
//		{"media_id":"X-fJF8E32mDZQnq6XgyDBaBEx3KMckF_oePNQfBjt4I"}
//		X-fJF8E32mDZQnq6XgyDBTI7iriawzkKNQv2QzrzrYg
		
		// 这里的media_id 保存到本地数据库
		
		
	}
	
	
	
	
	/**
	 * 获取素材总数
	 * @param token
	 * @param newsVo
	 */
	public void getMeteialCount(String token){
		String url = GET_METERIALCOUNT_URL.replace("ACCESS_TOKEN", token);
		String result = restTemplate.getForObject(url, String.class);

		log.info(result.toString());
//		{"media_id":"X-fJF8E32mDZQnq6XgyDBaBEx3KMckF_oePNQfBjt4I"}
		
		/**
		 * {"voice_count":0,"video_count":0,"image_count":2,"news_count":1}
		 */
		// 这里的media_id 保存到本地数据库
		
		
	}
	
	
	
	/**
	 * 获取素材总数
	 * @param token
	 * @param newsVo
	 */
	public String getMeteialList(String token){
		String url = GET_METERIALLIST_URL.replace("ACCESS_TOKEN", token);
		Map<String, Object> param = new HashMap<>();
		param.put("type", "image");
		param.put("offset", 0);
		param.put("count", 10);
		String result = restTemplate.postForObject(url, param, String.class);

		log.info(result.toString());
		return result;
//		{"media_id":"X-fJF8E32mDZQnq6XgyDBaBEx3KMckF_oePNQfBjt4I"}
		
		/**
		 * {"voice_count":0,"video_count":0,"image_count":2,"news_count":1}
		 */
		// 这里的media_id 保存到本地数据库
		
		
	}
	

	/**
	 * 群发
	 * user not agree mass-send protocol   没有权限
	 * @param token
	 */
	public void sendALL(String token){
		String url = SEND_ALL_URL.replace("ACCESS_TOKEN", token);
		Map<String, Object> param = new HashMap<>();
		
		Map<String, Object> mpnews = new HashMap<>();
		mpnews.put("media_id", "X-fJF8E32mDZQnq6XgyDBaBEx3KMckF_oePNQfBjt4I"); //test
		param.put("mpnews", mpnews);
		param.put("msgtype", "mpnews");
		
		Map<String, Object> filter = new HashMap<>();
		filter.put("is_to_all", true);
		param.put("filter", filter);
		
		
		
		String result = restTemplate.postForObject(url, param, String.class);

		log.info(result.toString());
//		{"media_id":"X-fJF8E32mDZQnq6XgyDBaBEx3KMckF_oePNQfBjt4I"}
		
		/**
		 * {"voice_count":0,"video_count":0,"image_count":2,"news_count":1}
		 */
		// 这里的media_id 保存到本地数据库
		
		
	}
	
	/**
	 * Upload image 
	 * @param token
	 * @param file
	 */
	public void uploadImg(String token,File file){
		String url = UPLOAD_IMG.replace("ACCESS_TOKEN", token);
		FileSystemResource resource = new FileSystemResource(file);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("jarFile", resource);
		String imgUrl = restTemplate.postForObject(url, param, String.class);
		log.info(imgUrl);

		// http://mmbiz.qpic.cn/mmbiz/NlnaapibtH6EVOVBmPlf1TQI6Mwt6DLO79rhQNHZYE4Q12NN88coMAWcMAibeRaeMqRnQDAR90ibJk4sNqNm2EWkQ/0
		// 保存到本地数据库
		
		
	}
	
	/**
	 * access_token	是	调用接口凭证
	 *	type	是	媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 *	media	是	form-data中媒体文件标识，有filename、filelength、content-type等信息
	 *{"media_id":"X-fJF8E32mDZQnq6XgyDBRGqKvuTPm9YJqFPk7dqcUY","url":"https:\/\/mmbiz.qlogo.cn\/mmbiz\/NlnaapibtH6EVOVBmPlf1TQI6Mwt6DLO79rhQNHZYE4Q12NN88coMAWcMAibeRaeMqRnQDAR90ibJk4sNqNm2EWkQ\/0?wx_fmt=jpeg"}
	 * @param token
	 * @param file
	 * @param type
	 */
	public void materialAdd(String token,File file,String type){
		String url = MATERIAL_ADD_URL.replace("ACCESS_TOKEN", token);
		FileSystemResource resource = new FileSystemResource(file);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("media", resource);
		param.add("type", type);
		
		String result = restTemplate.postForObject(url, param, String.class);
		log.info(result);
		
		JSONObject obj = JSONObject.fromObject(result);
		
		String mediaId = obj.getString("media_id");
		log.info(mediaId);
		if(type.equals("image")){
			String imgUrl = obj.getString("url");
			log.info(imgUrl);
		}
		
		// 本地是否需要保存
		
	}
	
	
}
