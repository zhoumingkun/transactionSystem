package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionService;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionServiceDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 登记托管的服务类型
 * @author liDongSheng
 *
 */
@Repository
public class TransactionServiceDaoImpl extends GenericDaoImpl<TransactionService, Integer>implements ITransactionServiceDao{

}
