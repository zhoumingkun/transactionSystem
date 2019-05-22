package com.toughguy.binheSportSystem.controller.content;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.toughguy.binheSportSystem.model.content.FieldList;
import com.toughguy.binheSportSystem.model.content.Holiday;
import com.toughguy.binheSportSystem.model.content.Reserve;
import com.toughguy.binheSportSystem.model.content.Scheduled;
import com.toughguy.binheSportSystem.service.content.prototype.IHolidayService;
import com.toughguy.binheSportSystem.service.content.prototype.IReserveTimeService;


//http://localhost:8084/educationSystem/reserve/findReserve?date=2019-04-30&venue=羽毛球
@RestController
@RequestMapping("/reserve")
public class ReserveTimeController {
	
	@Autowired
	private  IReserveTimeService reserveTimeService;
	
	@Autowired
	private IHolidayService holidayService; 
	
	/**
	 * 查询场馆预定时间
	 * @param date
	 * @param venue
	 * @throws ParseException 
	 */
	@RequestMapping("/getReservationList")
	public Scheduled findReserveTime(@RequestParam(name = "date") Date time, @RequestParam(name = "current") String venue) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(time);
		Scheduled stime =new Scheduled();
		List<FieldList> fieldList = new ArrayList<>();
		List<Holiday> list = holidayService.findHoliday(date);		//根据前端参数调用dao查询数据库是否为节假日
		List<Reserve> reservelist=null;
		
		stime.setVenue(venue);		//设置返回参数场馆名和时间(能查询出来下面判断查询结果和传递参数是否一致   否则返回前端传递的数据)
		stime.setDate(date);
		
		//周末或节假日的参数设置
		Map<String,Object> weekendMap = new HashMap<String,Object>();
		weekendMap.put("starttime", date+" 08:00:00");
		weekendMap.put("endtime", date+" 22:00:00");
		weekendMap.put("venue", venue);
		
		//正常时间的参数设置
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("starttime", date+" 06:00:00");
		map.put("endtime", date+" 22:00:00");
		map.put("venue", venue);
		int max = 0;
		if(venue.equals("篮球")) {
			max=4;
		}else if(venue.equals("乒乓球")) {
			max=8;
		}else {
			max=10;
		}
		
		for (int i = 1; i <= max; i++) { 
			FieldList field = new FieldList();
			field.setFieldName(i + "号馆");
			int[] state = null;		//此数组为06:00~22:00已每小时为单位16个时间格中每个时间格的预定情况
			DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date datetime=sf.parse(date);
			if (list.size() == 0) { 	//不是节假日但有可能是周末
				Calendar cal = Calendar.getInstance();
				cal.setTime(datetime);
				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY  || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					reservelist=reserveTimeService.findReserveTime(weekendMap);		//是周六或周日查询时间段为08:00:00 到 22:00:00
					state = new int[] { 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };			//1为未预定   2 为已经预定   -1为不可预定
					
					//-1   可预订       1  已预定    2 不可预定
				}else {
					reservelist=reserveTimeService.findReserveTime(map);	//非节假日非周末就按时间段为06:00:00  到 22:00:00查询
					state = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
				}
			}else {
				reservelist=reserveTimeService.findReserveTime(weekendMap);		//是节假日查询时间段为08:00:00 到 22:00:00
				state = new int[] { 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
			}

			for (Reserve item : reservelist) {
				if(item.getFieldtype().equals(venue) && item.getStarttime().substring(0, 10).equals(date)) {
					stime.setVenue(venue);				//能查询出结果判断传递的参数与数据库是否一致 
					stime.setDate(date);
				}else {
					Scheduled sc = new Scheduled();
					return sc;
				}
				if (i == item.getFieldno() && item.getState() != 1) { 	//判断是否为X号馆  不能是计时
					String start = item.getStarttime();
					String end = item.getEndtime();
					int o = (Integer.parseInt(start.substring(11, 13))) - 6;	//o表示开始时间在格子的第几位
					int n = (Integer.parseInt(end.substring(11, 13))) - 6;		//n表示开始时间在格子的第几位
					if(end.substring(14,19).equals("00:00")) {		//如果结束时间为09:00:00整点  只会占用08:00~09:00的时间格
						n=n-1;
					}
					if (n>15) {		//如果结束时间正好是22:00:00 那就显示最后一个格子为已预定
						n = 15;
					}
					for (int q = o; q <= n; q++) {
						state[q] = 1;
					}
				}
			}
			for (Reserve item : reservelist) {
				if (i == item.getFieldno() && item.getState() == 1) { 		// 判断是否为X号馆 必须是计时
					String start = item.getStarttime(); 		//取到计时的开始时间
					int o = (Integer.parseInt(start.substring(11, 13))) - 6;  //截取 XX点
					for (int w = o; w <= 15; w++) {
						if (state[w] == -1) { // 判断计时开始的时间为未预定
							state[w] = 1;
						} else {
							break;
						}
					}
				}
			}
			field.setState(state);
			fieldList.add(field);
		}
		stime.setFieldList(fieldList);
		return stime;
	}
	
}
