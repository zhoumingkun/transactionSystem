package com.toughguy.transactionSystem.persist.content.impl;

import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionPolicyDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

public class TransactionPolicyDaoImpl 
				extends GenericDaoImpl<TransactionPolicy, Integer>
				implements ITransactionPolicyDao{

}

