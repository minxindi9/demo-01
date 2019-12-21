package com.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Account;



public interface AccountMapper {
	
	public Account checkLogin(@Param("userName") String userName,@Param("password")String password);

	public int insertAccount(Account account);
	
}
