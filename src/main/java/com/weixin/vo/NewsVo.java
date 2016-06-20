package com.weixin.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author jay
 * @since 2016年6月13日
 */
public class NewsVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<WxArticleVo> articles;

	public List<WxArticleVo> getArticles() {
		return articles;
	}

	public void setArticles(List<WxArticleVo> articles) {
		this.articles = articles;
	}

}
