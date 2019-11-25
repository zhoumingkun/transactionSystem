package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAuditStatus;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseAuditStatusService extends IGenericService<TransactionEnterpriseAuditStatus, Integer>{

	/**
	 * 查询信息  状态为1
	 * @return
	 */
	public List<TransactionEnterpriseAuditStatus> findStatusAll();
}
