package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionSignupDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionSignupService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

/**
 * 报名的实现
 * @author s
 *
 */

@Service
public class TransactionSignupServiceImpl extends GenericServiceImpl<TransactionSignup,Integer> implements ITransactionSignupService{
	@Autowired
	private ITransactionSignupDao transactionSignupDao; 
	
	@Override
	public TransactionSignup judgeSignup(TransactionSignup transactionSignup) {
		return transactionSignupDao.findSignup(transactionSignup);
	}

	

}
