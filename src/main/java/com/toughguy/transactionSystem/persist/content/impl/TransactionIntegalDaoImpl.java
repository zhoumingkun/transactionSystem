package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;


import com.toughguy.transactionSystem.model.content.po.TransactionIntegal;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionIntegalDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 
 * 	
 * @author Guozhenze
 *
 */
@Repository
public class TransactionIntegalDaoImpl 
				extends GenericDaoImpl<TransactionIntegal, Integer>
				implements ITransactionIntegalDao{

}
