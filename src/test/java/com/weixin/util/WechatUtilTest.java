package com.weixin.util;

import java.io.IOException;

import org.apache.http.ParseException;
import org.junit.Test;

import com.weixin.vo.AccessToken;

import net.sf.json.JSONObject;

/**
 * @author       Jay
 */
public class WechatUtilTest {

	@Test
	public void testGetAccessToken() {
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println(token.toString());
	}
	
	@Test
	public void testCreateMenu() {
		String menu = JSONObject.fromObject(WeixinMenuUtil.initMenu()).toString();
		
		//String token = "1IEM802pmhucjCw4P7tDiAJC31HiMzP7iYL6N6DQ2BLrmTMBp3RxhNJD5A-prBm2M9OG-sSkVhgsGMBnVOwtpfKgqW4LXYW783t2SbN-iTDifeSUkRHA7ToE-28CZAkWWHTjAGAQBN";
		// WechatUtil.getAccessToken().getAccessToken()
		try {
			int result =  WeixinMenuUtil.createMenu(WeixinUtil.getAccessToken().getAccessToken(), menu);
			if(result == 0){
				System.out.println("init menu success");
			}else{
				System.out.println("init menu fail");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMenu() throws ParseException, IOException {
//		AccessToken token = WechatUtil.getAccessToken();
//		System.out.println(token.toString());
		String token = "1IEM802pmhucjCw4P7tDiAJC31HiMzP7iYL6N6DQ2BLrmTMBp3RxhNJD5A-prBm2M9OG-sSkVhgsGMBnVOwtpfKgqW4LXYW783t2SbN-iTDifeSUkRHA7ToE-28CZAkWWHTjAGAQBN";
//		System.out.println(WeixinMenuUtil.getMenu(WeixinUtil.getAccessToken().getAccessToken()));
		System.out.println(WeixinMenuUtil.getMenu(token));
	}
	
	@Test
	public void testgetUsers() throws ParseException, IOException {
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println(token.toString());
		System.out.println(WeixinUtil.getUsers(token.getAccessToken()));
	}
	
	@Test
	public void testgetUser() throws ParseException, IOException {
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println(token.toString());
		System.out.println(WeixinUtil.getUser(token.getAccessToken(),"o3DNit6JbMQaruuLPTOyRZb8YxDE"));
	}

	
	@Test
	public void testGet(){
		String obj = WeixinUtil.doGetStr2("http://220.248.75.36/handapp/PGcardAmtServlet?arg1=....&callback=money");
		System.out.println(obj);
	}
	
	@Test
	public void testGetMaterial(){
		WeixinUtil.getMaterial(WeixinUtil.getAccessToken().getAccessToken());
		
	}
	
}
