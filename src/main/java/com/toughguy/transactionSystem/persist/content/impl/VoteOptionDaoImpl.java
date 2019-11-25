package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.po.TransactionVoteOption;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteOptionDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class VoteOptionDaoImpl
extends GenericDaoImpl<TransactionVoteOption, Integer>
implements IVoteOptionDao {

	@Override
	public List<TransactionVoteOption> findVoteId(TransactionVoteContent voteContent) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findVoteId", voteContent);
	}

	@Override
	public void updateVoteOptionCount(TransactionVoteOption voteOption) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateVoteOptionCount", voteOption);
	}

}
