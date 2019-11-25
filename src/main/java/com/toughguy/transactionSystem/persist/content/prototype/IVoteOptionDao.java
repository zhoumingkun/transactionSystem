package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.po.TransactionVoteOption;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IVoteOptionDao extends IGenericDao<TransactionVoteOption, Integer>{
	
	/**
	 * 根据投票id查找
	 * @param voteContentId
	 * @return
	 */
	public List<TransactionVoteOption> findVoteId(TransactionVoteContent voteContent);

	/**
	 * 更新选项的投票次数
	 * @param voteOption
	 */
	public void updateVoteOptionCount(TransactionVoteOption voteOption);
}
