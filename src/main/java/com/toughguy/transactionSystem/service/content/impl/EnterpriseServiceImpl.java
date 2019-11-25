package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseServiceImpl 
extends GenericServiceImpl<TransactionEnterprise, Integer>
implements IEnterpriseService{
	@Autowired
	private IEnterpriseDao dao; 
	
	@Override
	public void insertMsg(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		dao.insertBasicMsg(info);
	}
	@Override
	public void insertMsgNoCard(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		dao.insertMsgNoCard(info);
	}
	
	@Override
	public boolean findEnterpriseName(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		TransactionEnterprise nameInfo = dao.findEnterpriseName(info);
		return nameInfo==null;
	}
	@Override
	public void saveCompleteInfo(TransactionEnterprise info) {
		// TODO Auto-generated method stub
		dao.saveCompleteInfo(info);
	}

	
	
}
