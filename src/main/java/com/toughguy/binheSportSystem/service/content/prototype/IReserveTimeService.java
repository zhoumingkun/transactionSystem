package com.toughguy.binheSportSystem.service.content.prototype;


import java.util.List;
import java.util.Map;

import com.toughguy.binheSportSystem.model.content.Reserve;
import com.toughguy.binheSportSystem.service.prototype.IGenericService;

/**
 * 查询场馆预定时间service接口类
 * @author 
 *
 */
public interface IReserveTimeService extends IGenericService<Reserve, Integer> {
	
	/**
	 * 根据条件查询该场馆时间段内的预定信息
	 * @param starttime 开始时间
	 * @param endtime 结束时间
	 * @param venue  场馆名
	 * @return
	 */
	public List<Reserve> findReserveTime(Map<String,Object> map);

}
