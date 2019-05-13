package com.toughguy.binheSportSystem.persist.content.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.binheSportSystem.model.content.ConsumeBill;
import com.toughguy.binheSportSystem.persist.prototype.IGenericDao;

/**
 *  用户账单查询dao接口类
 * @author 
 *
 */
public interface IMemberBillDao extends IGenericDao<ConsumeBill, Integer> {
	/**
	 * 查询用户充值记录
	 * @return
	 */
	 public List<ConsumeBill> findRecharge(Map<String,Object> map);			
	 
	 
	 /**
	  * 查询用户消费记录
	  * @return
	  */
	 public List<ConsumeBill> findconsume(Map<String,Object> map);

}
