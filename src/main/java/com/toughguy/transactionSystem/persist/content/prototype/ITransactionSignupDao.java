package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 报名的dao接口
 * @author liDongSheng
 *
 */

public interface ITransactionSignupDao extends IGenericDao<TransactionSignup, Integer>{
	/**
	 * 查找用户
	 * @return
	 */
	public TransactionSignup findSignup(TransactionSignup transactionSignup);
	
}
