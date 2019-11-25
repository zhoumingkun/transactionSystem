package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseTrade;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IEnterpriseTradeDao extends IGenericDao<TransactionEnterpriseTrade, Integer> {

	public List<TransactionEnterpriseTrade> findStatusAll();
}
