package com.toughguy.transactionSystem.service.content.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionLog;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionLogDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

/**
 * 
 * @author Guozhenze
 *
 */
@Service
public class TransactionLogServiceImpl  
						extends GenericServiceImpl<TransactionLog, Integer>
						implements ITransactionLogService{
	
	@Autowired
	private ITransactionLogDao logDao;
	
	public void insert(String logContent, int rootId) {
		TransactionLog log = new TransactionLog();
		log.setLogTime(new Date());
		log.setLogContent(logContent);
		log.setRootId(rootId);
		logDao.insert(log);
	}
}
