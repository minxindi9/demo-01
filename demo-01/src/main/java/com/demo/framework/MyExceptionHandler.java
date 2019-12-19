package com.demo.framework;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.framework.exception.LoginException;

@ControllerAdvice
public class MyExceptionHandler {
	
	
	@ExceptionHandler(LoginException.class)
	public String handleException(Exception e, HttpServletRequest request){
	      Map<String,Object> map = new HashMap<>();
	//传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程
	/**
	* Integer statusCode = (Integer) request
	.getAttribute("javax.servlet.error.status_code");
	*/
	      request.setAttribute("javax.servlet.error.status_code",400);
	      map.put("code","login fail");
	      map.put("messages",e.getMessage());
	      request.setAttribute("mapp", map);
	      //转发到/error
	      return "forward:/error";
	  }

}
