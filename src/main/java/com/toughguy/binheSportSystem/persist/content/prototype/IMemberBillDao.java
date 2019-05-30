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
	 * 查询用户全部充值记录
	 * @return
	 */
	 public List<ConsumeBill> findAllRecharge(Map<String,Object> map);			
	 
	 
	 /**
	  * 查询用户全部场馆消费记录
	  * @return
	  */
	 public List<ConsumeBill> findAllconsume(Map<String,Object> map);
	 
	 
	 /**
	  * 查询用户全部商品和游泳记录
	  * @return
	  */
	 public List<ConsumeBill> findAllOtherBill(Map<String,Object> map);
	 
	 
	/**
	 * 查询用户时间区间内的充值记录
	 * @return
	 */
	 public List<ConsumeBill> findRecharge(Map<String,Object> map);			
	 
	 
	 /**
	  * 查询用户时间区间内的消费记录
	  * @return
	  */
	 public List<ConsumeBill> findconsume(Map<String,Object> map);
	 
	 
	 /**
	  * 查询用户时间区间内的商品和游泳记录
	  * @return
	  */
	 public List<ConsumeBill> findOtherBill(Map<String,Object> map);

}
