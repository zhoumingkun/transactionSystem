package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
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
	public void updateVoteOptionOne(TransactionVoteContent transactionVoteContent) {
		// TODO Auto-generated method stub
		dao.updateVoteOptionOne(transactionVoteContent);
	}

	@Override
	public void updateVoteOptionTwo(TransactionVoteContent transactionVoteContent) {
		// TODO Auto-generated method stub
		dao.updateVoteOptionTwo(transactionVoteContent);
	}

	@Override
	public List<TransactionVoteContent> findInfo(SqlGeneralInfo sqlGeneralInfo) {
		// TODO Auto-generated method stub
		return dao.findInfo(sqlGeneralInfo);
	}

	@Override
	public List<TransactionVoteContent> findEndInfo(SqlGeneralInfo sqlGeneralInfo) {
		// TODO Auto-generated method stub
		return dao.findEndInfo(sqlGeneralInfo);
	}
	

}
