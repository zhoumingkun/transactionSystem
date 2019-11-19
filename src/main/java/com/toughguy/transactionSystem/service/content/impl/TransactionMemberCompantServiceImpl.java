package com.toughguy.transactionSystem.service.content.impl;



import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMemberCompany;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionMemberCompanyService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

@Service
public class TransactionMemberCompantServiceImpl
	extends GenericServiceImpl<TransactionMemberCompany, Integer>
	implements ITransactionMemberCompanyService{
}
