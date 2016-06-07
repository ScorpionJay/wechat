package com.weixin.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.ParseException;

import com.weixin.menu.Button;
import com.weixin.menu.ClickButton;
import com.weixin.menu.Menu;
import com.weixin.menu.ViewButton;

/**
 * @author       Jay
 */
public class WeixinMenuUtil {
	
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	 * Create menu
	 */
	public static int createMenu(String token, String menu) throws ParseException, IOException {
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = WeixinUtil.doPostStr(url, menu);
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}

	/**
	 * Get menu
	 */
	public static JSONObject getMenu(String token)throws ParseException, IOException {
		String url = GET_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = WeixinUtil.doGetStr(url);
		return jsonObject;
	}
	
	/**
	 * init menu
	 */
	public static Menu initMenu() {
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("Button");
		button11.setType("click");
		button11.setKey("11");

		ViewButton button21 = new ViewButton();
		button21.setName("博客");
		button21.setType("view");
		button21.setUrl("http://scorpionjay.github.io");

		ClickButton button31 = new ClickButton();
		button31.setName("扫二维码");
		button31.setType("scancode_push");
		button31.setKey("31");

		ClickButton button32 = new ClickButton();
		button32.setName("获取地址");
		button32.setType("location_select");
		button32.setKey("32");

		ViewButton button33 = new ViewButton();
		button33.setName("公交卡余额查询");
		button33.setType("view");
		button33.setUrl("http://shanghaicity.openservice.kankanews.com/public/traffic/jtkye");
		
		ViewButton button34 = new ViewButton();
		button34.setName("活动额");
		button34.setType("view");
		button34.setUrl("http://weixin.ngrok.io/weixin/test.html");

		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[] { button31, button32 ,button33,button34});

		menu.setButton(new Button[] { button11, button21, button });

		return menu;
	}
}
