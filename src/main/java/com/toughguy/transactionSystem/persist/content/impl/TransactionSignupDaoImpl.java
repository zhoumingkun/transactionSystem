package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionSignupDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

/**
 * 报名的实现类
 * @author liDongSheng
 *
 */
@Repository
public class TransactionSignupDaoImpl extends GenericDaoImpl<TransactionSignup, Integer>implements ITransactionSignupDao{

	@Override
	public TransactionSignup findSignup(TransactionSignup transactionSignup) {
		return sqlSessionTemplate.selectOne(typeNameSpace+".findSignup",transactionSignup );
	}



}
