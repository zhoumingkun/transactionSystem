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

	
	
	
	/**
	 * 	生成日志的方法
	 * @param request
	 * @return
	 */
	public static String insertLog(String logContent,int rootId) {
		try {
			TransactionLog log = new TransactionLog();
			log.setLogContent(logContent);
			log.setRootId(rootId);
			log.setLogTime(new Date());
			new TransactionLogServiceImpl().save(log);
		} catch (Exception e) {
			return "0";
		}
		return "1";
	}
	
}
