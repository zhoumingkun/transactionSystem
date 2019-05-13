package com.toughguy.binheSportSystem.service.content.prototype;

import java.util.List;
import java.util.Map;
import com.toughguy.binheSportSystem.model.content.ConsumeBill;
import com.toughguy.binheSportSystem.service.prototype.IGenericService;

/**
 * 
 * @author 用户账单查询service接口类
 *
 */
public interface IMemberBillService extends IGenericService<ConsumeBill, Integer> {
	/**
	 * 根据卡号 手机号 日期查询用户充值记录
	 * @return
	 */
	public List<ConsumeBill> findRecharge(Map<String,Object> map);
	
	/**
	 * 根据卡号 手机号 日期查询用户消费记录
	 * @return
	 */
	public List<ConsumeBill> findconsume(Map<String,Object> map);
}
