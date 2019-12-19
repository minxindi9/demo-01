package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class CommonController<T> {
	Logger logger = LoggerFactory.getLogger(getClass());

}
