package com.demo.model.common;


import com.demo.framework.constants.BaseConstants;

public class Response {
    private String status;
    private String msg;
    private Object data;

    public Response(String status, String msg, Object data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取数据成功
     * **/
    public static Response successResponse(Object data) {
        return new Response(BaseConstants.CommonCode.SUCCESS_CODE, BaseConstants.CommonMessage.SUCCESS_MESSAGE, data);
    }

    public static Response successResponse() {
        return new Response(BaseConstants.CommonCode.SUCCESS_CODE, BaseConstants.CommonMessage.SUCCESS_MESSAGE, "");
    }

    public static Response response(String status, String msg, Object data) {
        return new Response(status, msg, data);
    }

    public static Response response(String status) {
        return new Response(status, "", "");
    }
    
    public static Response error(String msg){
        return new Response(BaseConstants.CommonCode.ERROR_CODE, msg, "");
    }
    
    public static Response error(String status, String msg){
        return new Response(status, msg, "");
    }

    public static Response response(String status, String msg) {
        return new Response(status, msg, "");
    }
    
    public static Response response2(String status, String msg) {
        return new Response(status, msg, null);
    }

    public static Response fail(String msg) {
        Result res = new Result(false,"",msg);
        return new Response(BaseConstants.CommonCode.FAILED_CODE, msg, res);
    }
    
    public static Response fail(String msg,String status) {
        Result res = new Result(false,status,msg);
        return new Response(BaseConstants.CommonCode.FAILED_CODE, msg, res);
    }

    public static Response success(String msg) {
        return new Response(BaseConstants.CommonCode.SUCCESS_CODE, msg, msg);
    }

    public static Response fail(String msg, Object data) {
        return new Response(BaseConstants.CommonCode.FAILED_CODE, msg, data);
    }

    public static Response success(String msg, Object data) {
        return new Response(BaseConstants.CommonCode.SUCCESS_CODE, msg, data);
    }
    
    public static Response expire(String msg) {
        return new Response(BaseConstants.CommonCode.EXPIRE_CODE, msg, "");
    }

}
