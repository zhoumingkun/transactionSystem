package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

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

	@Override
	public List<TransactionStatistics> findCopiesCount(TransactionStatistics statistics) {
		return sqlSessionTemplate.selectList(typeNameSpace+".findCount",statistics );
	}

	@Override
	public TransactionStatistics findTime(TransactionStatistics statistisc) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace+".findTime",statistisc );
	}

}
