package com.toughguy.transactionSystem.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
/**
 * 	转为json工具类
 * @date 2019-11-22
 * @since JDK1.8
 * @version 1.0
 * @author Guozhenze
 *
 */
public class requestJSONUtil {
	/**
	 * 将前台传过来的数据直接转化为JSONObject
	 * @param request
	 * @param response
	 * @return
	 */
   public static JSONObject request(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject=null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            
            jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
