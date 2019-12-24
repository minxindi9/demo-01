package com.demo.model;

public class MailBean {
    private String recipient;   //邮件接收人
    private String subject; //邮件主题
    private String content; //邮件内容
    private String emailCode;//邮箱验证码

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    @Override
    public String toString() {
        return "MailBean{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", emailCode='" + emailCode + '\'' +
                '}';
    }
}
