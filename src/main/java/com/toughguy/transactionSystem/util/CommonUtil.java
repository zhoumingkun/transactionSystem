package com.toughguy.binheSportSystem.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.InputStream;
import net.sf.json.JSONObject;
import com.toughguy.binheSportSystem.model.content.MyX509TrustManager;




public class CommonUtil {
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		
		URL url = new URL(requestUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setSSLSocketFactory(ssf);
		            
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		            // 设置请求方式（GET/POST）
		conn.setRequestMethod(requestMethod);
		
		// 当outputStr不为null时向输出流写数据
		if (null != outputStr) {
		OutputStream outputStream = conn.getOutputStream();
		             // 注意编码格式
		outputStream.write(outputStr.getBytes("UTF-8"));
		outputStream.close();
		}
		
		// 从输入流读取返回内容
		InputStream inputStream = conn.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		StringBuffer buffer = new StringBuffer();
		while ((str = bufferedReader.readLine()) != null) {
		buffer.append(str);
		}
		
		// 释放资源
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		inputStream = null;
		conn.disconnect();
		jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			System.out.println("连接超时：{}");
		} catch (Exception e) {
		System.out.println("https请求异常：{}");
		}
		return jsonObject;
		}

}
