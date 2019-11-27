package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionServiceService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
/**
 * 登记托管的服务类型
 * @author liDongSheng
 *
 */
@Service
public class TransactionServiceServiceImpl extends GenericServiceImpl<TransactionService, Integer>implements ITransactionServiceService{

}
