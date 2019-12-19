package com.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.demo.framework.exception.LoginException;


@Controller
public class StudentNameController extends CommonController<StudentNameController> {

	//@RequestMapping("/doLogin")
	public String login(String userName,String password,Map map) {
		logger.info("登录开始用户名={},密码={}",userName,password);
		if(password.equals("123456")) {
			map.put("userName", userName);
			return "redirect:success";
		}else {
			map.put("msg", "用户名密码不能为空");
			return "login";
		}
		
	}
	
	@RequestMapping("/doLogin")
	public ModelAndView login1(String userName,String password) {
		logger.info("登录开始用户名={},密码={}",userName,password);
		ModelAndView mv = new ModelAndView();
		if(password.equals("123456")) {
			mv.addObject("userName",userName);
			mv.setViewName("redirect:success");
		}else {
			mv.addObject("msg","用户名密码不能为空");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping("/doLogin1")
	public ModelAndView doLogin1(String userName,String password) throws LoginException {
		logger.info("登录开始用户名={},密码={}",userName,password);
		ModelAndView mv = new ModelAndView();
		if("123456".equals(password)) {
			mv.addObject("userName",userName);
			mv.setViewName("redirect:success");
		}else {
			throw new LoginException();
		}
		return mv;
	}

}
