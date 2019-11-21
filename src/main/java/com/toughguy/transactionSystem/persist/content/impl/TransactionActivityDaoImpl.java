package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionActivity;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionActivityDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 活动发布的实现
 * @author liDongSheng
 *
 */
@Repository
public class TransactionActivityDaoImpl extends GenericDaoImpl<TransactionActivity, Integer>implements ITransactionActivityDao{

	@Override
	public int insertActivity(TransactionActivity activity) {
		return sqlSessionTemplate.insert(typeNameSpace+".insertActivity", activity);
	}

	
}
