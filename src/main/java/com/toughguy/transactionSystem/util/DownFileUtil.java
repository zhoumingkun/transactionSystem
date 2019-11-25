package com.toughguy.transactionSystem.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
public class DownFileUtil {
	/**
	 * 文件下载方法
	 * @param response
	 * @param filePath
	 * @param encode
	 */
	public static void download(HttpServletResponse response, String filePath, String encode) {
	    response.setContentType("text/html;charset=" + encode);
	    BufferedInputStream bis = null;
	    BufferedOutputStream bos = null;
	    String downLoadPath = "down/"+filePath;
	    try {
	        File file = new File(downLoadPath);
	        long fileLength = file.length();
	        String fileName = file.getName(); 
	        response.setContentType("application/x-msdownload;");
	        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(encode), "UTF-8"));
	        response.setHeader("Content-Length", String.valueOf(fileLength));
	        bis = new BufferedInputStream(new FileInputStream(downLoadPath));
	        bos = new BufferedOutputStream(response.getOutputStream());
	        byte[] buff = new byte[2048];
	        int bytesRead;
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	            bos.write(buff, 0, bytesRead);
	        }
	    } catch (Exception e) {
	    } finally {
	        if (bis != null)
	            try {
	                bis.close();
	            } catch (IOException e) {
	            	
	            }
	        if (bos != null)
	            try {
	                bos.close();
	            } catch (IOException e) {
	            	
	            }
	    }
	}
}
