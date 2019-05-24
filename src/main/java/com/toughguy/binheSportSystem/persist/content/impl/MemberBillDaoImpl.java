package com.toughguy.binheSportSystem.persist.content.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.binheSportSystem.model.content.ConsumeBill;
import com.toughguy.binheSportSystem.persist.content.prototype.IMemberBillDao;
import com.toughguy.binheSportSystem.persist.impl.GenericDaoImpl;

/**
 *  用户账单查询dao实现类
 * @author 
 *
 */
@Repository
public class MemberBillDaoImpl extends GenericDaoImpl<ConsumeBill, Integer> implements IMemberBillDao {
	
	@Override
	public List<ConsumeBill> findAllRecharge(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findAllRecharge", map);
	}

	@Override
	public List<ConsumeBill> findAllconsume(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findAllconsume", map);
	}

	@Override
	public List<ConsumeBill> findRecharge(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findRecharge", map);
	}

	@Override
	public List<ConsumeBill> findconsume(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findconsume", map);
	}

	
}
