package com.toughguy.binheSportSystem.service.content.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.toughguy.binheSportSystem.model.content.Reserve;
import com.toughguy.binheSportSystem.persist.content.prototype.IReserveTimeDao;
import com.toughguy.binheSportSystem.service.content.prototype.IReserveTimeService;
import com.toughguy.binheSportSystem.service.impl.GenericServiceImpl;

/**
 * 查询场馆预定时间service实现类
 * @author 
 *
 */
@Service
public class ReserveTimeServiceImpl extends GenericServiceImpl<Reserve, Integer> implements IReserveTimeService {
	
	/**
	 * 根据场馆名，起始时间，查询该场馆时间段内的预定信息实现类
	 */
	@Override
	public List<Reserve> findReserveTime(Map<String,Object> map) {
		return ((IReserveTimeDao)dao).findReserveTime(map);
	}

	/**
	 * 根据场馆名查询该场馆的场地数量
	 */
	@Override
	public String findVenueNumber(String venue) {
		// TODO Auto-generated method stub
		return ((IReserveTimeDao)dao).findVenueNumber(venue);
	}

	
	/**
	 * 查询全部的场馆名称
	 */
	@Override
	public List<String> findAllType() {
		// TODO Auto-generated method stub
		return ((IReserveTimeDao)dao).findAllType();
	}
	
	
	/**
	 * 查询全部的其他消费的类型名称
	 */
	public List<String> findAllOtherType(){
		// TODO Auto-generated method stub
		return ((IReserveTimeDao)dao).findAllOtherType();
	}
}
