package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IVoteCountDao extends IGenericDao<TransactionVoteCount, Integer>{
	
	/**
	 * 根据会员id 及 投票内容id 查找信息
	 * @param transactionVoteCount
	 * @return
	 */
	TransactionVoteCount findInfo(TransactionVoteCount transactionVoteCount);

}
