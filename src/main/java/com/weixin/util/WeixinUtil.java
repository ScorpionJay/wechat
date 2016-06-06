package com.weixin.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.weixin.vo.AccessToken;
import com.weixin.vo.Oauth2Token;
import com.weixin.vo.UserInfo;

import net.sf.json.JSONObject;

/**
 * @author Jay
 */
@Component
public class WeixinUtil {

	private static final String GET_ACCESS_TOKEN_URL= "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	private static final String GET_USERS_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
	private static final String GET_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	private static final String GET_Oauth2AccessToken_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	private static final String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	
	private static final String GET_JSPAI_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/**
	 * get请求
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
	 * @return
	 */
	public static AccessToken getAccessToken(){
		AccessToken token = new AccessToken();
		String url = GET_ACCESS_TOKEN_URL.replace("APPID", TokenThread.APPID).replace("APPSECRET",TokenThread.APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		System.out.println(jsonObject.toString());
		if(jsonObject != null){
			try {
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println( errorCode + " | "+errorMsg);
			}
		}
		return token;
	}
	
	
	public static AccessToken getAccessToken(String appId, String appSecret){
		AccessToken token = new AccessToken();
		String url = GET_ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET",appSecret);
		JSONObject jsonObject = doGetStr(url);
		System.out.println(jsonObject.toString());
		if(jsonObject != null){
			token.setAccessToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}

	
	
	
	/*
	 * Get user list
	 */
	public static JSONObject getUsers(String token)throws ParseException, IOException {
		String url = GET_USERS_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}
	
	
	/*
	 * Get user info
	 */
	public static UserInfo getUser(String token,String openId)throws ParseException, IOException {
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
				//userInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				userInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println( errorCode + " | "+errorMsg);
			}
		}
		
		return userInfo;
	}
	
	/**
	 * Get OAuth Access Token 
	 */
	public static Oauth2Token getOauth2AccessToken(String appid,String appsecret,String code){
		String url = GET_Oauth2AccessToken_URL.replace("APPID", appid).replace("SECRET",appsecret).replace("CODE", code);	
		JSONObject jsonObject = doGetStr(url);
		Oauth2Token oauth2Token = new Oauth2Token();
		if(jsonObject != null){
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
	public static Oauth2Token getOauth2AccessToken(String code){
		return getOauth2AccessToken(TokenThread.APPID, TokenThread.APPSECRET, code);
	}
	
	/**
	 * Get OAuth Access Token 
	 */
	public static void getMaterial(String token){
		String url = GET_MATERIAL_URL.replace("ACCESS_TOKEN", token);	
		JSONObject jsonObject = doPostStr(url, "{'media_id': 'sKGjZ2k5WZhG7tKxqEn3J91GRYbx7ZueIFYLnCKB2B7MemJ3iBcbCRiZANi4II3R'}");
		System.out.println(jsonObject.toString());
	}
	
	/**
	 * Get JSPAI Token 
	 */
	public static String getJsapiToken(String token){
		String url = GET_JSPAI_URL.replace("ACCESS_TOKEN", token);	
		JSONObject jsonObject = doGetStr(url);
		System.out.println("hack");
		System.out.println(jsonObject.toString());
		
		return jsonObject.getString("ticket");
			
	}
	
}
