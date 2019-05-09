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
	
	public List<Reserve> findReserveTime(Map<String,Object> map);

}
