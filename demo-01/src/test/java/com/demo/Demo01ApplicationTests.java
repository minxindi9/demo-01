package com.demo;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo01ApplicationTests {
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() {
		System.out.println("11111");
		System.out.println(dataSource.getClass());
	}

}
