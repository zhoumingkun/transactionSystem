package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IEnterpriseTypeDao extends IGenericDao<TransactionEnterpriseType, Integer> {

	public List<TransactionEnterpriseType> findStatusAll();
}
