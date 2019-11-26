package com.toughguy.transactionSystem.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;



/***
 * 	发送手机验证码工具类
 * @author Guozhenze
 *
 */
public class SendTelUtli {

	public static int sendTel(String tel) {
	    String host = "https://dxyzm.market.alicloudapi.com";
	    String path = "/chuangxin/dxjk";
	    String method = "POST";
	    String appcode = "7f1393fffe884785bc5b47a1011f500a";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    //测试可用默认短信模板,测试模板为专用模板不可修改,如需自定义短信内容或改动任意字符,请联系旺旺或QQ726980650进行申请
      
	    Integer a =  (int) ((Math.random()*9+1)*1000);
	  
	    querys.put("content", "【股权交易托管中心】您的验证码为"+a.toString()+"，有效期为3分钟，请确保是本人操作，不要把验证码泄露给他人。");
	    querys.put("mobile", tel);
	    Map<String, String> bodys = new HashMap<String, String>();
	    
            try {
	   
	    	HttpResponse response = HttpUtil.doPost(host, path, method, headers, querys, bodys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {	  
	    	e.printStackTrace();
	    }
            return a;
	}
	public static void main(String[] args) {
		int a = sendTel("15161126613");
		System.out.println(a);
	}

}
