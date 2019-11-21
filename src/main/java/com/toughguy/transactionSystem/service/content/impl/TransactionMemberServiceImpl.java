package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionMemberDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionMemberService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
import com.toughguy.transactionSystem.util.DateUtil;
@Service
public class TransactionMemberServiceImpl extends GenericServiceImpl<TransactionMember,Integer> implements ITransactionMemberService{

	@Autowired
	private ITransactionMemberDao tmd;

	@Override
	public TransactionMember findmeber(TransactionMember member) {
		
		return tmd.findmeber(member);
	}

	@Override
	public List<TransactionMember> findMeberAll() {
		List<TransactionMember> memberAll = tmd.findMemberAll();
		return tmd.findMemberAll();
	}
	



}
