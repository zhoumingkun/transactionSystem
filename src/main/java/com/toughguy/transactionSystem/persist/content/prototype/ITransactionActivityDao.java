package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionActivity;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 * 活动发布的dao
 * @author liDongSheng
 *
 */
public interface ITransactionActivityDao extends IGenericDao<TransactionActivity, Integer>{
	public int insertActivity(TransactionActivity activity);      //新增活动
}
