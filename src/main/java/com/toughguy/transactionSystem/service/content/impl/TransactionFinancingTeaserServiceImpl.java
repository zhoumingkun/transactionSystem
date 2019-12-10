package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.model.content.po.TransactionFinancingTeaser;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingDao;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingTeaserDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionFinancingTeaserService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

@Service
public class TransactionFinancingTeaserServiceImpl extends GenericServiceImpl< TransactionFinancingTeaser, Integer>implements ITransactionFinancingTeaserService{
	@Autowired
	private ITransactionFinancingTeaserDao transactionFinancingTeaserDao;
	
	@Override
	public List<TransactionFinancingTeaser> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public PagerModel<TransactionFinancingTeaser> findPaginated(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.findPaginated(params);
	}

}
