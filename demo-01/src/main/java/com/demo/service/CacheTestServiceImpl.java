package com.demo.service;

import com.demo.mapper.AccountMapper;
import com.demo.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheTestServiceImpl {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AccountMapper accountMapper;

    @Cacheable(value = "account")
    public List<Account> selectAccount(Integer status){
        logger.info("开始查询数据库");
        return accountMapper.selectAccount(status);
    }


}
