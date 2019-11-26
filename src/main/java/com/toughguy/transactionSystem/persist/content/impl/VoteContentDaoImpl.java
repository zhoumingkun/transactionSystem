package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteContentDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class VoteContentDaoImpl
extends GenericDaoImpl<TransactionVoteContent, Integer>
implements IVoteContentDao {

	@Override
	public void updateVoteOptionOne(TransactionVoteContent transactionVoteContent) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateVoteOptionOne", transactionVoteContent);
	}

	@Override
	public void updateVoteOptionTwo(TransactionVoteContent transactionVoteContent) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateVoteOptionTwo", transactionVoteContent);
	}

	@Override
	public List<TransactionVoteContent> findInfo(SqlGeneralInfo sqlGeneralInfo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findInfo", sqlGeneralInfo);
	}

	@Override
	public List<TransactionVoteContent> findEndInfo(SqlGeneralInfo sqlGeneralInfo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findEndInfo", sqlGeneralInfo);
	}


}
