package com.toughguy.binheSportSystem.persist.content.prototype;



import java.util.List;
import java.util.Map;

import com.toughguy.binheSportSystem.model.content.Reserve;
import com.toughguy.binheSportSystem.persist.prototype.IGenericDao;

/**
 * 查询场馆预定时间dao接口类
 * @author 
 *
 */
public interface IReserveTimeDao extends IGenericDao<Reserve, Integer> {
	/**
	 * 根据场馆名，起始时间，查询该场馆时间段内的预定信息
	 * @param map
	 * @return
	 */
	public List<Reserve> findReserveTime(Map<String,Object> map);
	
	/**
	 * 根据场馆名查询该场馆的场地数量
	 * @param venue
	 * @return
	 */
	public String findVenueNumber(String venue);

	
	/**
	 * 查询全部的场馆名称
	 * @return
	 */
	public List<String> findAllType();
	
	/**
	 * 查询全部的其他消费的类型名称
	 */
	public List<String> findAllOtherType();
}
