package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancingApply;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 融资申请service
 * @author liDongSheng
 *
 */
public interface ITransactionFinancingApplyService extends IGenericService<TransactionFinancingApply, Integer> {
	/**
	 * 修改还款的状态
	 * @param transactionFinancingApply
	 */
	public void updateFinancingCompleteStatus(TransactionFinancingApply transactionFinancingApply);
}
