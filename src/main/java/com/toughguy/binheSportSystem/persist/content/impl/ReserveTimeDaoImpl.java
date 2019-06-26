package com.toughguy.binheSportSystem.persist.content.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.toughguy.binheSportSystem.model.content.Reserve;
import com.toughguy.binheSportSystem.persist.content.prototype.IReserveTimeDao;
import com.toughguy.binheSportSystem.persist.impl.GenericDaoImpl;

/**
 * 查询场馆预定时间dao实现类
 * @author 
 *
 */
@Repository
public class ReserveTimeDaoImpl extends GenericDaoImpl<Reserve, Integer>  implements IReserveTimeDao{

	@Override
	public List<Reserve> findReserveTime(Map<String,Object> map) {
		
		return sqlSessionTemplate.selectList(typeNameSpace + ".findReserveTime", map);
	}

	@Override
	public String findVenueNumber(String venue) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findVenueNumber", venue);
	}

	@Override
	public List<String> findAllType() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findAllType");
	}
	
	@Override
	public List<String> findAllOtherType() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findAllOtherType");
	}
}
