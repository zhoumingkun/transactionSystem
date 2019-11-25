package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseService extends IGenericService<TransactionEnterprise, Integer>{
	
	/**
	 * 注册基本信息
	 * @param member
	 */
	public void insertMsg(TransactionEnterprise info);
	public void insertMsgNoCard(TransactionEnterprise info);
	/**
	 * 判断公司名是否存在
	 * @param info
	 * @return
	 */
	public boolean findEnterpriseName(TransactionEnterprise info);
	
	/**
	 * 完善基本信息
	 * @param info
	 */
	public void saveCompleteInfo(TransactionEnterprise info);
	
}
