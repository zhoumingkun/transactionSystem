package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionLog;
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

}
