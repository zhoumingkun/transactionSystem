package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionLog;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionLogDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

/***
 * 	
 * @author Guozhenze
 *
 */
@Repository
public class TransactionLogDaoImpl 
					extends GenericDaoImpl<TransactionLog, Integer>
					implements ITransactionLogDao{
	
}
