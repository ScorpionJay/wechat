package com.weixin.exception;

/**
 * @author Jay
 * @time 2015年5月22日
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * status code
	 */
	private Integer code = 200;

	/**
	 * message
	 */
	private String message;

	public MyException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public MyException() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
