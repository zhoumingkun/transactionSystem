package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionMemberCompany;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionMemberCompanyDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

@Repository
public class TransactionMemberCompanyDaoImpl 
				extends GenericDaoImpl<TransactionMemberCompany, Integer>
				implements ITransactionMemberCompanyDao{
}
