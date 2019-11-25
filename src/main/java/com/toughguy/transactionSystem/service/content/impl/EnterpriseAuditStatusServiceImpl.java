package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAuditStatus;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseAuditStatusDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAuditStatusService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseAuditStatusServiceImpl
extends GenericServiceImpl<TransactionEnterpriseAuditStatus, Integer>
implements IEnterpriseAuditStatusService{
	@Autowired
	private IEnterpriseAuditStatusDao dao;

	@Override
	public List<TransactionEnterpriseAuditStatus> findStatusAll() {
		// TODO Auto-generated method stub
		return dao.findStatusAll();
	}
}
