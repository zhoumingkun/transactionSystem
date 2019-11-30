package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionIntegal;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionIntegalService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
/**
 * 
 * @author Guozhenze
 *
 */
@Service
public class TransactionIntegalServiceImpl 
			extends GenericServiceImpl< TransactionIntegal, Integer>
			implements ITransactionIntegalService{

}
