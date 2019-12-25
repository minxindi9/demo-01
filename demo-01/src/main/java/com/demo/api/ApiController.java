package com.demo.api;

import com.demo.model.Account;
import com.demo.service.CacheTestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CacheTestServiceImpl cacheTestService;

    @RequestMapping("/getAccountList/{status}")
    @ResponseBody
    public List<Account> getAccountList(@PathVariable Integer status){
        logger.info("进入controller");
        return cacheTestService.selectAccount(status);
    }

}
