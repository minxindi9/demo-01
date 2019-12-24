package com.demo;

import javax.sql.DataSource;

import com.demo.framework.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Demo01ApplicationTests {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	RedisUtil redisUtil;
	
	@Test
	public void test() {
		System.out.println("11111");
		System.out.println(dataSource.getClass());
	}

	@Test
	public void test02(){
		redisTemplate.opsForValue().set("min","123456");
		String min = (String) redisTemplate.opsForValue().get("min");
		System.out.println(min);
	}

	@Test
	public void test03(){
		redisUtil.expire("min",60);
		System.out.println(redisUtil.getExpire("min"));
	}

}
