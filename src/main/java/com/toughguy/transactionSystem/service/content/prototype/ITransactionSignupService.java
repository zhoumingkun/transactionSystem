package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 报名的service接口
 * @author liDongSheng
 *
 */
public interface ITransactionSignupService extends IGenericService<TransactionSignup, Integer> {
	/**
	 * 判断是否报名
	 * @param transactionSignup
	 * @return
	 */
	public TransactionSignup judgeSignup(TransactionSignup transactionSignup);
}
