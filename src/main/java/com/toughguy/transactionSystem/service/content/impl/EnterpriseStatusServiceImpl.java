package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseStatus;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseStatusDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseStatusService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseStatusServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseStatus, Integer>
implements IEnterpriseStatusService{
	
	@Autowired
	private IEnterpriseStatusDao dao;

	@Override
	public List<TransactionEnterpriseStatus> findStatusAll() {
		// TODO Auto-generated method stub
		return dao.findStatusAll();
	}
	
}
