package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingApplyDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Repository
public class TransactionFinancingApplyDaoImpl extends GenericDaoImpl<TransactionFinancingApply, Integer>implements ITransactionFinancingApplyDao{

	@Override
	public void updateFinancingCompleteStatus(TransactionFinancingApply transactionFinancingApply) {
		sqlSessionTemplate.update(typeNameSpace + ".updateFinancingCompleteStatus", transactionFinancingApply);
	}

	@Override
	public TransactionFinancingApply findFinancingApply(TransactionFinancingApply transactionFinancingApply) {
		return sqlSessionTemplate.selectOne(typeNameSpace+".findFinancingApply",transactionFinancingApply );
	}

}
