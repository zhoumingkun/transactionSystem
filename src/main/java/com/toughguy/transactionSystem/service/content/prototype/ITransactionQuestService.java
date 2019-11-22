package com.toughguy.transactionSystem.service.content.prototype;

import java.io.Serializable;
import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionQuest;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 *  TransactionQuest 实体类的service层
 * @author Guozhenze
 *
 */
public interface ITransactionQuestService 
						extends IGenericService<TransactionQuest, Integer> {
	/**
	 *  	 查找所有的问题
	 * @return
	 */
	List<TransactionQuest> findInfoAll(TransactionQuest quest);
	/**
	 *  	添加问题
	 * @param quest
	 */
	void insertQuest(TransactionQuest quest);
}
