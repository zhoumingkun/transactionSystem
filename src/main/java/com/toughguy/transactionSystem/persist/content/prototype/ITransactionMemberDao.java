package com.toughguy.transactionSystem.persist.content.prototype;


import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface ITransactionMemberDao extends IGenericDao<TransactionMember, Integer>{
	TransactionMember findmeber(TransactionMember member);
	List<TransactionMember> findMemberAll();
}
