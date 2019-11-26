package com.toughguy.transactionSystem.service.content.prototype;

import java.util.Date;

import com.toughguy.transactionSystem.model.content.po.TransactionLog;
import com.toughguy.transactionSystem.service.content.impl.TransactionLogServiceImpl;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 	日志管理service层
 * @author Guozhenze
 *
 */
public interface ITransactionLogService extends  IGenericService<TransactionLog, Integer>{

	void insert(String logContent, int rootId);
	
}
