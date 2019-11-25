package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.po.TransactionVoteOption;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteOptionDao;
import com.toughguy.transactionSystem.service.content.prototype.IVoteOptionService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class VoteOptionServiceImpl
extends GenericServiceImpl<TransactionVoteOption, Integer>
implements IVoteOptionService {
	
	@Autowired
	private IVoteOptionDao dao;
	
	@Override
	public List<TransactionVoteOption> findVoteId(TransactionVoteContent voteContent) {
		// TODO Auto-generated method stub
		return dao.findVoteId(voteContent);
	}

	@Override
	public void updateVoteOptionCount(TransactionVoteOption voteOption) {
		// TODO Auto-generated method stub
		dao.updateVoteOptionCount(voteOption);
	}

}
