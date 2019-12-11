package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteCountDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class VoteCountDaoImpl
extends GenericDaoImpl<TransactionVoteCount, Integer>
implements IVoteCountDao {

	@Override
	public TransactionVoteCount findInfo(TransactionVoteCount transactionVoteCount) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findInfo", transactionVoteCount);
	}

	@Override
	public TransactionVoteCount findTime(TransactionVoteCount transactionVoteCount) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findTime", transactionVoteCount);
	}

	

}
