package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingApplyDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Repository
public class TransactionFinancingApplyDaoImpl extends GenericDaoImpl<TransactionFinancingApply, Integer>implements ITransactionFinancingApplyDao{

}
