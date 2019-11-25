package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseArea;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IEnterpriseAreaDao extends IGenericDao<TransactionEnterpriseArea, Integer>{

	public List<TransactionEnterpriseArea> findStatusAll();
}
