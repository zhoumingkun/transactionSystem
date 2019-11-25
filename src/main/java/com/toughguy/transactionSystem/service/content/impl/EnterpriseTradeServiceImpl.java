package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseTrade;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseTradeDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseTradeService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseTradeServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseTrade, Integer>
implements IEnterpriseTradeService{

	@Autowired
	private IEnterpriseTradeDao dao;

	@Override
	public List<TransactionEnterpriseTrade> findStatusAll() {
		// TODO Auto-generated method stub
		return dao.findStatusAll();
	}
}
