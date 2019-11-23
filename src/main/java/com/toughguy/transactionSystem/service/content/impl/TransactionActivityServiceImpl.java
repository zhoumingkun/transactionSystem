package com.toughguy.transactionSystem.service.content.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionActivity;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionActivityDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionActivityService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

/**
 * 活动发布的实现
 * @author liDongSheng
 *
 */
@Service
public class TransactionActivityServiceImpl extends GenericServiceImpl<TransactionActivity, Integer>implements ITransactionActivityService{
	@Autowired
	private ITransactionActivityDao transactionActivityDao;
	
	@Override
	public PagerModel<TransactionActivity> findEndActivityPage(Map<String, Object> params) {
		return transactionActivityDao.findEndActivity(params);
	}
}
