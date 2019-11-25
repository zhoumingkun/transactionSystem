package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionReghost;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionReghostService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class TransactionReghostServiceImpl extends GenericServiceImpl<TransactionReghost, Integer>implements ITransactionReghostService{

}
