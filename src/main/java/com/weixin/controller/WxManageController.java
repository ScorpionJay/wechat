/**
 *	Copyright (c) 2016 Mars 
 */

package com.weixin.controller;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.weixin.service.iface.WxService;
import com.weixin.util.TokenThread;
import com.weixin.util.WeixinMenuUtil;
import com.weixin.util.WeixinUtil;
import com.weixin.vo.ResultVo;
import com.weixin.vo.WechatVo;

/**
 * wx manage controller
 * 
 * @author Jay
 * @since 2016-6-8
 */
@Controller
@RequestMapping(value = "wxManage")
public class WxManageController {

	@Autowired
	private WxService wxService;
	
	@Autowired
	private WeixinUtil weixinUtil;

	/**
	 * find wx by title
	 * 
	 * @param title
	 * @return
	 */
	@RequestMapping(value = "{title}")
	@ResponseBody
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
	
	/**
	 * Get menu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "menus")
	@ResponseBody
	public ResultVo getMenus() throws Exception {
		ResultVo resultVo = new ResultVo();
		Object obj = WeixinMenuUtil.getMenu(TokenThread.accessToken.getAccessToken());
		resultVo.setObj(obj);
		return resultVo;
	}
	
	
		
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void upload(@RequestParam(value = "file") MultipartFile file) throws Exception {
		
		//String fileId = fileService.save(file.getBytes(), file.getOriginalFilename());
		//Image image = new Image();
		//image.setSummary(summary);
		//image.setPath(fileId);
		
		File f = new File("test.jpg");
		file.transferTo(f);
		weixinUtil.mediaUpload(TokenThread.accessToken.getAccessToken(),f, "image");
		
		//imageService.saveImage(image);
		
	}
	
	
	@RequestMapping(value = "meteials")
	@ResponseBody
	public String getMeteials() {
		return weixinUtil.getMeteialList(TokenThread.accessToken.getAccessToken());
		
	}
	
	
}
