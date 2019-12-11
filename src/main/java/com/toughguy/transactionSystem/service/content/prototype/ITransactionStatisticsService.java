package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionStatistics;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 	
 * @author Guozhenze
 *
 */
public interface ITransactionStatisticsService  extends IGenericService<TransactionStatistics, Integer>{

	TransactionStatistics findStatistics(TransactionStatistics statistisc);
	List<TransactionStatistics> findCopiesCount(TransactionStatistics statistisc);
}
