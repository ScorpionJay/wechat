package com.weixin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.exception.MyException;

@ControllerAdvice
public class AdviceController {
	
	private static Logger logger=LoggerFactory.getLogger(AdviceController.class);
	
//	@Resource(name="messageSource")
//	private MessageSource messages;

	// 异常处理
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public MyException handleException(Exception exception,HttpServletResponse response) {
		logger.error("****系统异常***" + exception.getMessage());

		// exception 判断
		
		response.setStatus(400);
		response.setHeader("testFiled", "hello");
		MyException myexception = new MyException(400, "错误");
		return myexception;
	}

	
}
