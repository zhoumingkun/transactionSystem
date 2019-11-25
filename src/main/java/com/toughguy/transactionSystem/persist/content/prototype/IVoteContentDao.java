package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IVoteContentDao extends IGenericDao<TransactionVoteContent, Integer>{
	
	/**
	 * 添加投票内容并返回id
	 * @param voteContent
	 * @return
	 */
	public TransactionVoteContent insertVoteContent(TransactionVoteContent voteContent);
}
