/**
 *	Copyright (c) 2016 Mars 
 */

package com.weixin.service.iface;

import com.weixin.vo.WechatVo;

/**
 * wx service interface
 * 
 * @author jay
 * @since 2016-6-8
 */
public interface WxService {

	/**
	 * add wx
	 * 
	 * @param wechatVo
	 */
	void addWx(WechatVo wechatVo);

	/**
	 * find wx by appId
	 * 
	 * @param appId
	 * @return
	 */
	WechatVo findByAppId(String appId);

	/**
	 * update wx
	 * 
	 * @param wechatVo
	 */
	void update(WechatVo wechatVo);

	/**
	 * find wx by title
	 * 
	 * @param title
	 * @return
	 */
	WechatVo findByTitle(String title);

	/**
	 * delete wx by id
	 * 
	 * @param id
	 */
	void delete(String id);

	
	
	
}
