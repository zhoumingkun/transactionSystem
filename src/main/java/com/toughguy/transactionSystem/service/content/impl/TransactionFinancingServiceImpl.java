package com.toughguy.transactionSystem.service.content.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

@Service
public class TransactionFinancingServiceImpl extends GenericServiceImpl< TransactionFinancing, Integer>implements ITransactionFinancingService{
	@Autowired
	private ITransactionFinancingDao transactionFinancingDao;
	
	@Override
	public PagerModel<TransactionFinancing> findEndFinancingPage(Map<String, Object> params) {
		return transactionFinancingDao.findEndFinancing(params);
	}

}
