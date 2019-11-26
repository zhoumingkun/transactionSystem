package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.model.content.po.TransactionStatistics;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionStatisticsDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;


@Repository
public class TransactionStatisticsDaoImpl 
							extends GenericDaoImpl<TransactionStatistics, Integer>
							implements ITransactionStatisticsDao{

	@Override
	public TransactionStatistics findStatistics(TransactionStatistics statistics) {
			return sqlSessionTemplate.selectOne(typeNameSpace+".findStatistics",statistics );
	}

}
