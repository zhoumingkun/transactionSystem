package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteCountDao;
import com.toughguy.transactionSystem.service.content.prototype.IVoteCountService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class VoteCountServiceImpl
extends GenericServiceImpl<TransactionVoteCount, Integer>
implements IVoteCountService {

	@Autowired
	private IVoteCountDao dao;
	
	@Override
	public boolean check(TransactionVoteCount transactionVoteCount) {
		// TODO Auto-generated method stub
		TransactionVoteCount info = dao.findInfo(transactionVoteCount);
		return info == null;
	}
	
		

}
