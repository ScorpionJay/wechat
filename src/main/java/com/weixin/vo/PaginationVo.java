package com.weixin.vo;

import java.util.List;

/**
 * 分页对象
 * @author Jay
 * @time 2015年6月1日
 */
public class PaginationVo {
	
	private Integer totalItems;
	private Object data;

	public PaginationVo() {
	}

	public PaginationVo(Integer totalItems, List<Object> data) {
		this.totalItems = totalItems;
		this.data = data;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
