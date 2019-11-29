package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingApplyDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingApplyService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class TransactionFinancingApplyServiceImpl extends GenericServiceImpl<TransactionFinancingApply, Integer>implements ITransactionFinancingApplyService{
	@Autowired
	private ITransactionFinancingApplyDao transactionFinancingApplyDao;
	@Override
	public void updateFinancingCompleteStatus(TransactionFinancingApply transactionFinancingApply) {
		transactionFinancingApplyDao.updateFinancingCompleteStatus(transactionFinancingApply);
	}
	@Override
	public TransactionFinancingApply judgeFinancingApply(TransactionFinancingApply transactionFinancingApply) {
		return transactionFinancingApplyDao.findFinancingApply(transactionFinancingApply);
	}

}
