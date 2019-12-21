package com.demo.webConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.demo.framework.MyLocaleResolver;


@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		//registry.addViewController("/success").setViewName("basic-table");
	}
	
	//所有的WebMvcConfigurerAdapter组件都会一起起作用
    //@Bean //将组件注册在容器
    /*public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }*/
	
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}

}
