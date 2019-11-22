package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionQuest;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface ITransactionQuestDao extends IGenericDao<TransactionQuest, Integer>{
	/**
	 * 	查询所有问卷调查的问题
	 * @return
	 */
	List<TransactionQuest> findInfoAll(TransactionQuest quest);
	/**
	 * 	增加问题
	 * @param oqInfo
	 *
	 */
	void insertQuest(TransactionQuest oqInfo);
}
