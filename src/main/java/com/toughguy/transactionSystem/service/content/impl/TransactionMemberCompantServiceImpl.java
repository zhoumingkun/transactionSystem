package com.toughguy.transactionSystem.service.content.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMemberCompany;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionMemberCompanyDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionMemberCompanyService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

@Service
public class TransactionMemberCompantServiceImpl
	extends GenericServiceImpl<TransactionMemberCompany, Integer>
	implements ITransactionMemberCompanyService{
	
	@Autowired
	private ITransactionMemberCompanyDao memCompantDao;
	@Override
	public List<TransactionMemberCompany> findAllInfo() {
		return memCompantDao.findAllInfo();
	}
}

