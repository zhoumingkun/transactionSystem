package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseTrade;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseTradeService extends IGenericService<TransactionEnterpriseTrade, Integer> {

	/**
	 * 查询信息  状态为1
	 * @return
	 */
	public List<TransactionEnterpriseTrade> findStatusAll();
}
