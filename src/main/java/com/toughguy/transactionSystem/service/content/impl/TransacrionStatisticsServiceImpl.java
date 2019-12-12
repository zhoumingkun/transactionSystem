package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionStatistics;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionStatisticsDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionStatisticsService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;


@Service
public class TransacrionStatisticsServiceImpl 
							extends	GenericServiceImpl<TransactionStatistics, Integer>
							implements ITransactionStatisticsService{
	
	@Autowired
	private ITransactionStatisticsDao statisticsDao;
	
	@Override
	public TransactionStatistics findStatistics(TransactionStatistics statistisc) {
		return statisticsDao.findStatistics(statistisc);
	}

	@Override
	public List<TransactionStatistics> findCopiesCount(TransactionStatistics statistisc) {
		return statisticsDao.findCopiesCount(statistisc);
	}

	@Override
	public TransactionStatistics findTime(TransactionStatistics statistisc) {
		// TODO Auto-generated method stub
		return statisticsDao.findTime(statistisc);
	}
}
