package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAuditStatus;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IEnterpriseAuditStatusDao extends IGenericDao<TransactionEnterpriseAuditStatus, Integer>{

	public List<TransactionEnterpriseAuditStatus> findStatusAll();
}
