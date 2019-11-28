package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionRepaymentplan;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionRepaymentplanDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 还款计划的dao实现
 * @author liDongSheng
 *
 */
@Repository
public class TransactionRepaymentplanDaoImpl extends GenericDaoImpl<TransactionRepaymentplan, Integer>implements ITransactionRepaymentplanDao{

}
