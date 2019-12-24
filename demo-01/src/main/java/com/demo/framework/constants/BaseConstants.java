package com.demo.framework.constants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


public class BaseConstants {
    //通用的状态码
	//通用的状态码
    public abstract class CommonCode {
        public static final String EXPIRE_CODE         = "-1";       //token失效
        public static final String NOT_SUFFICIENT      = "-2";       //余额不足
        public static final String FAILED_CODE         = "0";       //获取数据失败状态码
        public static final String SUCCESS_CODE        = "1";       //获取数据成功状态码
        public static final String ERROR_CODE          = "0";       //获取数据出错状态码
        public static final String PARAM_ERROR_CODE    = "0";       //参数传递错误状态码
        public static final String NO_LOGIN            = "-99";     //参数传递错误状态码
        public static final String WEIXIN_SUCCESS_CODE = "0"; 		//微信成功状态码
        public static final String REJECT_CODE         = "reject";  //  审批驳回
        public static final String PASS_CODE           = "pass";    //  审批通过
        public static final String PROGRESS            = "progress"; // 进行中
        public static final String DEVICENUMBERERROR   = "9";        // 设备号不匹配
        public static final String NO_QUALIFICATION   = "20";        //无直播资格
        
    }
    //通用的消息
    public abstract class CommonMessage {
        public static final String FAILED_MESSAGE      = "获取数据失败!";    //获取数据失败
        public static final String SUCCESS_MESSAGE     = "请求数据成功!";    //获取数据失败
        public static final String ERROR_MESSAGE       = "请求数据出错!!";   //获取数据出错!
        public static final String PARAM_ERROR_MESSAGE = "请求参数传递错误!!"; //参数传递错误
        public static final String COMMON_FAIL_MSG     = "网络异常, 请稍后再试";

    }
    /**
     * 分红相关配置键值
     */
    public static final String  VIP_NODE = "vip_node";//vip节点奖励 充值用户向上推第三个人
    public static final String  VIP_INDIRECT_PUSH = "vip_indirect_push";//vip间接推送奖励 充值用户向上推第二个人
    public static final String  VIP_DIRECT_PUSH = "vip_direct_push";//vip直接推送奖励 充值用户的推荐人
    public static final String  NODE = "node";//节点奖励 充值用户向上推第三个人
    public static final String  INDIRECT_PUSH = "indirect_push";//间接推送奖励 充值用户向上推第二个人
    public static final String  DIRECT_PUSH = "direct_push";//直接推送奖励 充值用户的推荐人
    public static final String  DISCOUNT = "discount";//前三个月的购买优惠率
    public static final String  ALL_VIP_REWARD = "all_vip_reward";//下线推荐vip奖 下线充值得到的奖励
    public static final String  ALL_REWARD = "all_reward";//下线推荐奖 下线充值得到的奖励
    public static final String  GENERAL_AGENT = "general_agent";//江总分账
    public static final String  BONUS_SERIES = "bonus_series";//往上推多少级
    public static final String  BONUS_TYPE = "bonus_type";// 0 默认分账 全部分充值币种 1按节点分gtc
    public static final String  MIN_PURCHASE_AMOUNT = "min_purchase_amount";//用户最少购买的金额
    public static final String  PURCHASE_CURRENCY = "purchase_currency";//支持购买的币种
    public static final String  GTC_USD_RATE = "gtc_usd_rate";//gtc兑美元汇率
    
    
    
    
    //一天的秒数
   	public static final Integer ONE_DAY_SECOND = 86400;
   	
   	
    public static class MsgConstant{
    	
    	/**
         * 验证码短信
         * @param str
         * @return
         */
        public static String CodeMsg(Map<String,String> params,String msg,int isChina){
        	if(params.get("msgCode")!=null){
        		String msgCode = params.get("msgCode");
	        	//此处填写注册短信消息模板
	        	String msgTemplate = msg.replace("{0}", msgCode);
	        	try {
	        		if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}	
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        }
        /**
         * 购买商品短息
         * @param str
         * @return
         */
        public static String buyProductMsg(Map<String,String> params,int isChina,String sign){
        		String msg = sign+""+params.get("msg");
        		//此处填写注册短信消息模板
//        		String msgTemplate = msg.replace("{0}", msgCode);
        		try {
        			if(isChina!=1){
        				return URLEncoder.encode(msg,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msg;
	        		}	
        				
        		} catch (UnsupportedEncodingException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		return null;
        }
        /**
         * 出账 发给领导短信
         * @param str
         * @return
         */
        public static String outAccountMsg(String msg,int isChina ){
        	try {
        		if(isChina!=1){
        			return URLEncoder.encode(msg,"utf-8").replaceAll("\\+", "%20");
        		}else{
        			return msg;
        		}	
        			
        	} catch (UnsupportedEncodingException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	return null;
        }
        /**
         * 设置购汇汇率发送短信
         * @param str
         * @return
         */
        public static String rateMsg(Map<String,String> params){
        	if(params.get("rateCode")!=null){
        		String rateCode = params.get("rateCode");
        		//此处填写注册短信消息模板
        		String msgTemplate = "您的购汇汇率是"+rateCode+"，有效时间10分钟，请尽快进行确认购汇。【GoPay全球汇】";
        		try {
        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
        		} catch (UnsupportedEncodingException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        	return null;
        }
        

        /**
         * 订金支付短信
         */
        public static String depositPaidMsg(Map<String,String> params,int isChina){
        	if(params.get("destination")!=null&&params.get("days")!=null&&params.get("deposit")!=null&&params.get("orderId")!=null){
        		String destination = params.get("destination");//目的地
        		String days = 	params.get("days");	//行程天数
        		String deposit = params.get("deposit"); //订金金额
        		String orderId = params.get("orderId");//订单号
        		String msgTemplate = "您的"+destination+days+"日游活动，订单号"+orderId+"订金已支付成功，支付金额"+deposit+"元。【AC环游】";
	        	try {
	        		if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        }
        /**
         * 订金退款短信
         * @param params
         * @return
         */
        public static String depositRefundMsg(Map<String,String> params,int isChina){
        	if(params.get("destination")!=null&&params.get("days")!=null&&params.get("deposit")!=null&&params.get("refundId")!=null){
        		String destination = params.get("destination");//目的地
        		String days = 	params.get("days");	//行程天数
        		String deposit = params.get("deposit"); //订金金额
        		String refundId = params.get("refundId");//退款号
        		String msgTemplate = "您的"+destination+days+"日游活动，订金退款成功，退款金额"+deposit+"元。退款流水号"+refundId+"【AC环游】";
	        	try { 
					if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        }
        
        /**
         * 召集结束短信
         * @param params
         * @return
         */
        public static String conveneCompleteMsg(Map<String,String> params,int isChina,String sign){
        	if(params.get("destination")!=null&&params.get("days")!=null&&params.get("date")!=null&&params.get("discount")!=null){
        		String destination = params.get("destination");//目的地
        		String days = 	params.get("days");	//行程天数
        		String date = params.get("date"); //结束日期
        		String discount = params.get("discount");//折扣
        		String msgTemplate = sign+""+"尊敬的会员，截止"+date+"AC环游为您量身定制的"+destination+days+"日游活动即将结束，活动期间VIP会员畅享"+discount+"折优惠。回复TD退订 【AC环游】";
	        	try {
	        		if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}	
	        			
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        }
        
        /**
         * 中标短信
         * @param params
         * @return
         */
        public static String bidMsg(Map<String,String> params,int isChina,String sign){
        	if(params.get("destination")!=null&&params.get("days")!=null&&params.get("conveneId")!=null&&params.get("bidMoney")!=null){
        		String destination = params.get("destination");//目的地
        		String days = 	params.get("days");	//行程天数
        		String conveneId = params.get("conveneId"); //召集编号
        		String bidMoney = params.get("bidMoney");//中标金额
        		String msgTemplate = sign+""+"恭喜您，您参与"+destination+days+"日游召集活动的竞标的产品中标，召集编号"+conveneId+"已中标，中标金额"+bidMoney+"元。【AC环游】";
	        	try {
	        		if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}	
	        			
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        }
        
        /**
         * 召集成功短信
         * @param params
         * @return
         */
        public static String ConveneSuccessMsg(Map<String,String> params,int isChina,String sign ){
        	if(params.get("destination")!=null&&params.get("days")!=null&&params.get("conveneId")!=null){
        		String destination = params.get("destination");//目的地
        		String days = 	params.get("days");	//行程天数
        		String conveneId = params.get("conveneId"); //召集编号
        		String msgTemplate = sign+""+"恭喜您，您参与"+destination+days+"日游召集活动已经成功召集，召集编号"+conveneId+"，请您尽快支付尾款。【AC环游】";
	        	try {
	        		if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}	
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        } 
        
        /**
         * paypal充值到账短信
         * @param params
         * @return
         */
        public static String payaplMsg(Map<String,String> params,String msg,int isChina){
        	if(params.get("amt")!=null){
        		String msgCode = params.get("amt");
	        	//此处填写paypal充值到账短信模板
	        	String msgTemplate = msg.replace("{0}", msgCode);
	        	try {
	        		if(isChina!=1){
	        			return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
	        		}else{
	        			return msgTemplate;
	        		}	
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			return null;
        }
        /**
         * 出账汇款短信
         * @param params
         * @return
         */
        public static String outAccountMsgToMember(String msg,int isChina){
        		String msgTemplate = msg;
        		try {
        			if(isChina!=1){
        				return URLEncoder.encode(msgTemplate,"utf-8").replaceAll("\\+", "%20");
        			}else{
        				return msgTemplate;
        			}	
        		} catch (UnsupportedEncodingException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	return null;
        }
    	
    }
}
