/**
 *	Copyright (c) 2016 Mars 
 */

package com.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weixin.service.iface.WxService;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinUtil;
import com.weixin.vo.ResultVo;
import com.weixin.vo.WechatVo;

/**
 * wx manage controller
 * 
 * @author Jay
 * @since 2016-6-8
 */
@RestController
@RequestMapping(value = "wxManage")
public class WxManageController {

	@Autowired
	private WxService wxService;

	/**
	 * find wx by title
	 * 
	 * @param title
	 * @return
	 */
	@RequestMapping(value = "{title}")
	public WechatVo findByTitle(@PathVariable String title) {
		WechatVo wechatVo = wxService.findByTitle(title);
		return wechatVo;
	}

	/**
	 * update wx
	 * 
	 * @param wechatVo
	 */
	@RequestMapping(value = "update")
	public void upate(@RequestBody WechatVo wechatVo) {
		wxService.update(wechatVo);
	}

	/**
	 * update wx
	 * 
	 * @param wechatVo
	 */
	@RequestMapping(value = "{id}/delete")
	public void delete(@PathVariable String id) {
		wxService.delete(id);
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
