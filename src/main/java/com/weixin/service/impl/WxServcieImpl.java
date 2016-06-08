package com.weixin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.weixin.entity.mongo.Wechat;
import com.weixin.service.iface.WxService;
import com.weixin.vo.WechatVo;

/**
 * @author Jay
 * @since 2016-6-8
 */
@Service(value = "WxService")
public class WxServcieImpl implements WxService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void addWx(WechatVo wechatVo) {
		Wechat wechat = new Wechat();

		wechat.setAppId(wechatVo.getAppId());
		wechat.setAppSecret(wechatVo.getAppSecret());
		wechat.setTitle(wechatVo.getTitle());

		mongoTemplate.save(wechat);
	}

	@Override
	public WechatVo findByAppId(String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(WechatVo wechatVo) {
		Wechat wechat = null;
		if (wechatVo.getId() != null) {
			wechat = mongoTemplate.findById(wechatVo.getId(), Wechat.class);
		} else {
			wechat = new Wechat();
		}
		
		wechat.setAppId(wechatVo.getAppId());
		wechat.setAppSecret(wechatVo.getAppSecret());
		wechat.setToken(wechatVo.getToken());
		wechat.setJsapiTicket(wechatVo.getJsapiTicket());
		wechat.setTokenDate(wechatVo.getTokenDate());
		wechat.setJsapiTicketDate(wechatVo.getJsapiTicketDate());

		mongoTemplate.save(wechat);

	}

	@Override
	public WechatVo findByTitle(String title) {
		Wechat wechat = mongoTemplate.findOne(new Query(where("title").is(title)), Wechat.class);

		WechatVo wechatVo = null;
		if (wechat != null) {
			wechatVo = new WechatVo();
			wechatVo.setId(wechat.getId());
			wechatVo.setAppId(wechat.getAppId());
			wechatVo.setAppSecret(wechat.getAppSecret());
			wechatVo.setToken(wechat.getToken());
			wechatVo.setTitle(wechat.getTitle());
			wechatVo.setJsapiTicket(wechat.getJsapiTicket());
			wechatVo.setTokenDate(wechat.getTokenDate());
			wechatVo.setJsapiTicketDate(wechat.getJsapiTicketDate());
		}

		return wechatVo;
	}

	@Override
	public void delete(String id) {
		mongoTemplate.remove(new Query(where("id").is(id)), Wechat.class);
	}

}
