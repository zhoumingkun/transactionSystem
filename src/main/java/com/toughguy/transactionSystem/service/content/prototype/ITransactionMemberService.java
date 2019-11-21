package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface ITransactionMemberService extends IGenericService<TransactionMember, Integer>{
	TransactionMember findmeber(TransactionMember member);
	List<TransactionMember> findMeberAll();
	
}
