package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAddress;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IEnterpriseAddressDao extends IGenericDao<TransactionEnterpriseAddress, Integer>{

	public List<TransactionEnterpriseAddress> findStatusAll();
}
