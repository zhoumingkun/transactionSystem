package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IVoteContentService extends IGenericService<TransactionVoteContent, Integer>{
	/**
	 * 添加投票内容并返回id
	 * @param voteContent
	 * @return
	 */
	public TransactionVoteContent insertVoteContent(TransactionVoteContent voteContent);
}
