package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMemberCompany;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface ITransactionMemberCompanyService 
			extends IGenericService<TransactionMemberCompany, Integer>{
	List<TransactionMemberCompany> findAllInfo();
}
