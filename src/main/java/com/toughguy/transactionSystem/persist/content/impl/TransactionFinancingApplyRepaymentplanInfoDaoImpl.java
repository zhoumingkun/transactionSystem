package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.TransactionFinancingApplyRepaymentplanInfo;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingApplyRepaymentplanInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

/**
 *  融资表和融资申请表和计划表的联系
 * @author liDongSheng
 *
 */
@Repository
public class TransactionFinancingApplyRepaymentplanInfoDaoImpl extends GenericDaoImpl<TransactionFinancingApplyRepaymentplanInfo, Integer>implements ITransactionFinancingApplyRepaymentplanInfoDao{

}
