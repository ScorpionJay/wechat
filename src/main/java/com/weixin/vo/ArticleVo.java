package com.weixin.vo;

import java.util.Date;

/**
 * Created by Jay on 2015/5/26.
 */
public class ArticleVo {

	private String articleId;
	private String title;
	private String summary;
	private String content;
	private Date date;

	public ArticleVo() {
	}

	public ArticleVo(String articleId,String title, String summary,String content, Date date) {
		this.articleId = articleId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.date = date;
	}

	public ArticleVo(String title, String summary,String content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
