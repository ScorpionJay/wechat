package com.weixin.vo;

import java.io.Serializable;

/**
 * @author Jay
 * @since 2016年6月3日
 */
public class ResultVo implements Serializable{

	private static final long serialVersionUID = -6328005499278436366L;
	
	private Integer code = 0;
	private Object obj;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public ResultVo() {
		super();
	}

	public ResultVo(Integer code, Object obj) {
		super();
		this.code = code;
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "ResultVo [code=" + code + ", obj=" + obj + "]";
	}

}
