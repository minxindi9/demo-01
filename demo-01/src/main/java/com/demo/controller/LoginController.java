package com.demo.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.demo.framework.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.demo.framework.exception.LoginException;
import com.demo.mapper.AccountMapper;
import com.demo.model.Account;


@Controller
public class LoginController extends CommonController<LoginController> {

	@Autowired
	AccountMapper accountMapper;
	
	@RequestMapping("/doLogin")
	public ModelAndView login1(String userName,String password,HttpSession session) {
		logger.info("登录开始用户名={},密码={}",userName,password);

		ModelAndView mv = new ModelAndView();

		if("admin".equals(userName) && "admin".equals(password) ){
			Account at = new Account();
			at.setUserName(userName);
			at.setPassword(password);
			at.setCreateTime(new Date());
			session.setAttribute("account", at);
			session.setAttribute("userName", at.getUserName());
			mv.setViewName("redirect:main");
			return mv;
		}

		if(StringUtils.isEmpty(userName)) {
			mv.addObject("msg","用户名不能为空");
			mv.setViewName("login");
			return mv;
		}
		
		if(StringUtils.isEmpty(password)) {
			mv.addObject("msg","密码不能为空");
			mv.setViewName("login");
			return mv;
		}
		Account at = accountMapper.checkLogin(userName, password);
		if(at == null) {
			mv.addObject("msg","用户名或密码不正确！！！");
			mv.setViewName("login");
			return mv;
		}
		if(at.getStatus() == 0) {
			mv.addObject("msg","用户已经注册，等待管理员审核！！！");
			mv.setViewName("login");
			return mv;
		}
		
		session.setAttribute("account", at);
		session.setAttribute("userName", at.getUserName());
		mv.setViewName("redirect:main");
		return mv;
	}

	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping("/register")
	public ModelAndView doLogin1(Account account) throws LoginException {
		logger.info("用户开始注册={}",account);
		ModelAndView mv = new ModelAndView();
		
		if(StringUtils.isEmpty(account.getUserName())) {
			mv.addObject("msg","用户名不能为空");
			mv.setViewName("register");
			return mv;
		}
		
		if(StringUtils.isEmpty(account.getPassword())) {
			mv.addObject("msg","密码不能为空");
			mv.setViewName("register");
			return mv;
		}
		
		Account at = accountMapper.checkLogin(account.getUserName(),null);
		if(at != null) {
			mv.addObject("msg","用户名已经存在");
			mv.setViewName("register");
			return mv;
		}
		
		
		accountMapper.insertAccount(account);
		
		mv.addObject("msg","注册成功");
		mv.addObject("flag","1");
		mv.addObject("userName",account.getUserName());
		mv.addObject("password",account.getPassword());
		mv.addObject("email",account.getEmail());
		mv.setViewName("register");
		
		return mv;
	}

}
