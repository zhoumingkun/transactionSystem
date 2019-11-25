package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteContentDao;
import com.toughguy.transactionSystem.service.content.prototype.IVoteContentService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class VoteContentServiceImpl
extends GenericServiceImpl<TransactionVoteContent, Integer>
implements IVoteContentService {
	
	@Autowired
	private IVoteContentDao dao;
	
	@Override
	public TransactionVoteContent insertVoteContent(TransactionVoteContent voteContent) {
		// TODO Auto-generated method stub
		return dao.insertVoteContent(voteContent);
	}

}
