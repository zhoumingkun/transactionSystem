package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 融资申请dao
 * @author liDongSheng
 *
 */
public interface ITransactionFinancingApplyDao extends IGenericDao<TransactionFinancingApply, Integer>{
	/**
	 * 修改还款的状态
	 */
	public void updateFinancingCompleteStatus(TransactionFinancingApply transactionFinancingApply);
	/**
	 * 查找融资活动
	 * @return
	 */
	public TransactionFinancingApply findFinancingApply(TransactionFinancingApply transactionFinancingApply);
	
}
