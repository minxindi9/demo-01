package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.StudentName;
import com.demo.mapper.NameMapper;

@RestController
public class NameController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NameMapper nameMapper;
	
	@RequestMapping("/getNameList")
	public List<StudentName> queryNameList(){
		logger.trace("trace...");
		logger.debug("debug...");
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
		return nameMapper.getNameList();
	}

}
