package com.toughguy.binheSportSystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the"License"); 
 * you may not use this file except in compliance with the License.  
 * You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
 * See the License for the specific language governing permissions and limitations under the License.
 * Copyright [2017] [RanJi] [Email-jiran1221@163.com]
 * 
 * 处理日期的工具类
 * @author RanJi
 * @date 2017-10-13
 * @since JDK1.7
 * @version 1.0
 */
public abstract class DateUtil {
	 /**
     * Default time format :  yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Time format :  yyyy-MM-dd HH:mm
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String TIME_FORMAT = "HH:mm";

    /**
     * Default date format
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * Default month format
     */
    public static final String MONTH_FORMAT = "yyyy-MM";
    /**
     * Default day format
     */
    public static final String DAY_FORMAT = "dd";


    //Date pattern,  demo:  2013-09-11
    public static final String DATE_PATTERN = "^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$";


    private DateUtil() {}
    
    /*
     * 判断是否为日期格式,如: 2016-12-12
     * */
     public static boolean isDate(String dateAsText) {
         return StringUtils.isNotEmpty(dateAsText) && dateAsText.matches(DATE_PATTERN);
     }

     public static Date now() {
         return new Date();
     }

     public static String toDateText(Date date) {
         return toDateText(date, DATE_FORMAT);
     }

     public static String toDateText(Date date, String pattern) {
         if (date == null || pattern == null) {
             return null;
         }
         SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
         return dateFormat.format(date);
     }

     public static Date getDate(String dateText) {
         return getDate(dateText, DATE_FORMAT);
     }


     public static Date getDate(String dateText, String pattern) {
         SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
         try {
             return dateFormat.parse(dateText);
         } catch (ParseException e) {
             throw new IllegalStateException("Parse date from [" + dateText + "," + pattern + "] failed", e);
         }
     }

     public static String toDateTime(Date date) {
         return toDateText(date, DATE_TIME_FORMAT);
     }


     /**
      * Return current year.
      *
      * @return Current year
      */
     public static int currentYear() {
         return calendar().get(Calendar.YEAR);
     }

     public static Calendar calendar() {
         return Calendar.getInstance();
     }

     /**
 	 * @Description 是否为当天24h内
 	 * @author bobo
 	 * @param inputJudgeDate 要判断是否在当天24h内的时间
 	 * @return
 	 * boolean
 	 */
 	public static boolean isToday(Date inputJudgeDate) {
 		boolean flag = false;
 		//获取当前系统时间
 		long longDate = System.currentTimeMillis();
 		Date nowDate = new Date(longDate);
 		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		String format = dateFormat.format(nowDate);
 		String subDate = format.substring(0, 10);
 		//定义每天的24h时间范围
 		String beginTime = subDate + " 00:00:00";
 		String endTime = subDate + " 23:59:59";
 		Date paseBeginTime = null;
 		Date paseEndTime = null;
 		try {
 			paseBeginTime = dateFormat.parse(beginTime);
 			paseEndTime = dateFormat.parse(endTime);
 			
 		} catch (ParseException e) {
 			e.printStackTrace();
 		}
 		if(inputJudgeDate.after(paseBeginTime) && inputJudgeDate.before(paseEndTime)) {
 			flag = true;
 		}
 		return flag;
 	}
}
