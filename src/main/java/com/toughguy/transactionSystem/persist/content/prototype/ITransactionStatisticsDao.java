package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionStatistics;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 * 	判断用户是否参与问卷调查的dao
 * @author Guozhenze
 *
 */
public interface ITransactionStatisticsDao  extends IGenericDao<TransactionStatistics, Integer>{
	/**
	 * 
	 * 
	 * @param statistics
	 * @return
	 */
	TransactionStatistics findStatistics(TransactionStatistics statistics);
}
