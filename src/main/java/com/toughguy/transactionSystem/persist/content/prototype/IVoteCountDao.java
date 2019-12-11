package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IVoteCountDao extends IGenericDao<TransactionVoteCount, Integer>{
	
	/**
	 * 根据会员id 及 投票内容id 查找信息
	 * @param transactionVoteCount
	 * @return
	 */
	TransactionVoteCount findInfo(TransactionVoteCount transactionVoteCount);
	
	/**
	 * 查询投票是否在规定时间内
	 * @param transactionVoteCount
	 * @return
	 */
	TransactionVoteCount findTime(TransactionVoteCount transactionVoteCount);
	

}
