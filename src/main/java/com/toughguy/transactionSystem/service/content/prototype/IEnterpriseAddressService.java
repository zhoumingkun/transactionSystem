package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAddress;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseAddressService extends IGenericService<TransactionEnterpriseAddress, Integer>{
	
	/**
	 * 查询信息  状态为1
	 * @return
	 */
	public List<TransactionEnterpriseAddress> findStatusAll();
}
