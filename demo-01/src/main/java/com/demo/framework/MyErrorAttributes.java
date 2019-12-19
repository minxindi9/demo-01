package com.demo.framework;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes{

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		// TODO Auto-generated method stub
		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
		map.put("myMsg", "aaaaaaa");
		Map mapp = (Map) webRequest.getAttribute("mapp", 0);
		if(mapp !=null) {
			map.putAll(mapp);
		}
		return map;
		
		
	}
	
	
	

}
