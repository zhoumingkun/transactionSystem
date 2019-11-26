package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IVoteCountService extends IGenericService<TransactionVoteCount, Integer>{
	
	/**
	 * 投票检测
	 * @param transactionVoteCount
	 * @return
	 */
	public boolean check(TransactionVoteCount transactionVoteCount);

}
