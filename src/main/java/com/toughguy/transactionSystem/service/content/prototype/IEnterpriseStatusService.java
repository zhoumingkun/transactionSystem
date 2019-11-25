package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseStatus;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseStatusService extends IGenericService<TransactionEnterpriseStatus, Integer> {

	/**
	 * 查询信息  状态为1
	 * @return
	 */
	public List<TransactionEnterpriseStatus> findStatusAll();
}
