package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteContentDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class VoteContentDaoImpl
extends GenericDaoImpl<TransactionVoteContent, Integer>
implements IVoteContentDao {

	@Override
	public TransactionVoteContent insertVoteContent(TransactionVoteContent voteContent) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(typeNameSpace + ".insertVoteContent", voteContent);
		return voteContent;
	}

}
