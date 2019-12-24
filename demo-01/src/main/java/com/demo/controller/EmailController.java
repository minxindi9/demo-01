package com.demo.controller;

import com.demo.framework.utils.RedisUtil;
import com.demo.model.MailBean;
import com.demo.model.common.Response;
import com.demo.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class EmailController extends CommonController<EmailController> {

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping("/email/sendEmail/test")
    public Response sendEmailTest(){
        logger.info("发送邮件测试");
        MailBean mb = new MailBean();
        mb.setRecipient("minxindi9@163.com");
        mb.setContent("");
        mb.setSubject("邮件测试！！！！");
        emailService.sendTemplateMail1(mb);
        return Response.success("验证码已发送至邮箱，3分钟类有效");
    }

    @ResponseBody
    @RequestMapping("/email/sendEmail")
    public Response sendEmail(String email){
        logger.info("发送邮件验证码");
        if(StringUtils.isEmpty(email)){
            return Response.error("邮箱不能为空");
        }

        Random random = new Random();
        int emailCode = random.nextInt(100);

        redisUtil.set(email,emailCode+"",60*3);

        MailBean mb = new MailBean();
        mb.setRecipient(email);
        mb.setContent("");
        mb.setSubject("验证码");
        mb.setEmailCode(emailCode+"");
        emailService.sendTemplateMail1(mb);
        return Response.success("验证码已发送至邮箱，3分钟类有效");
    }

}
