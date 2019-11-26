package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionLog;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 日志管理dao层
 * @author Guozhenze
 *
 */
public interface ITransactionLogDao extends IGenericDao<TransactionLog, Integer>{
	void insert(TransactionLog log);
}
