package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseTypeService extends IGenericService<TransactionEnterpriseType, Integer> {

	/**
	 * 查询信息  状态为1
	 * @return
	 */
	public List<TransactionEnterpriseType> findStatusAll();
}
