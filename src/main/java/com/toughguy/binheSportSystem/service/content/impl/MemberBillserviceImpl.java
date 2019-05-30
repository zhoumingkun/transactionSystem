package com.toughguy.binheSportSystem.service.content.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.toughguy.binheSportSystem.model.content.ConsumeBill;
import com.toughguy.binheSportSystem.persist.content.prototype.IMemberBillDao;
import com.toughguy.binheSportSystem.service.content.prototype.IMemberBillService;
import com.toughguy.binheSportSystem.service.impl.GenericServiceImpl;

/**
 * 
 * @author 用户账单查询serviceimpl实现类
 *
 */
@Service
public class MemberBillserviceImpl extends GenericServiceImpl<ConsumeBill, Integer> implements IMemberBillService {
	
	@Override
	public List<ConsumeBill> findAllRecharge(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ((IMemberBillDao)dao).findAllRecharge(map);
	}

	@Override
	public List<ConsumeBill> findAllconsume(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ((IMemberBillDao)dao).findAllconsume(map);
	}
	
	@Override
	public List<ConsumeBill> findAllOtherBill(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ((IMemberBillDao)dao).findAllOtherBill(map);
	}

	@Override
	public List<ConsumeBill> findRecharge(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ((IMemberBillDao)dao).findRecharge(map);
	}

	@Override
	public List<ConsumeBill> findconsume(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ((IMemberBillDao)dao).findconsume(map);
	}

	@Override
	public List<ConsumeBill> findOtherBill(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ((IMemberBillDao)dao).findOtherBill(map);
	}


}
