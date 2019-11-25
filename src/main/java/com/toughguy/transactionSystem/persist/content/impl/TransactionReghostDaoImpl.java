package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionReghost;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionReghostDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Repository
public class TransactionReghostDaoImpl  extends GenericDaoImpl<TransactionReghost, Integer>implements ITransactionReghostDao{

}
