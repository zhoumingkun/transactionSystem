package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseTrade;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseTradeService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseTradeServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseTrade, Integer>
implements IEnterpriseTradeService{

}
