package com.weixin.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jay on 2015/5/26.
 */
@Document(collection="Article")
public class Article implements Serializable{

    private static final long serialVersionUID = -1330735258248742982L;

    @Id
    private String articleId;
    private String title;
    private String summary;
    private String content;
    private Date date;

    public Article(String articleId, String title,String summary, String content, Date date) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.date = date;
    }
    
    public Article( String title, String summary,String content, Date date) {
    	this.title = title;
        this.summary = summary;
        this.content = content;
        this.date = date;
    }

    public Article() {
	}

	public Article(String articleId) {
		super();
		this.articleId = articleId;
	}

	public String getArticleId() {
        return articleId;
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
