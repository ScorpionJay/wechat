package com.weixin.entity.mongo;
import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Image entity
 * @author Jay
 * @time 2015-6-4
 */
@Document(collection="Image")
public class Image implements Serializable {

	private static final long serialVersionUID = -1430228444846465054L;

	@Id
	private String id;
	private String summary;
	private String title;
	private String path;
	private Date date = new Date();

	public Image() {
	}

	public Image(String id) {
		this.id = id;
	}

	public Image(String id, String summary, String title, String path, Date date) {
		this.id = id;
		this.summary = summary;
		this.title = title;
		this.path = path;
		this.date = date;
	}

	
	public Image(String summary, String title, String path, Date date) {
		this.summary = summary;
		this.title = title;
		this.path = path;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
