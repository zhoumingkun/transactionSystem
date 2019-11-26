package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IVoteContentDao extends IGenericDao<TransactionVoteContent, Integer>{
	
	/**
	 * 更新选项一计数
	 * @param transactionVoteContent
	 */
	public void updateVoteOptionOne(TransactionVoteContent transactionVoteContent);
	/**
	 * 更新选项二计数
	 * @param transactionVoteContent
	 */
	public void updateVoteOptionTwo(TransactionVoteContent transactionVoteContent);
	
	/**
	 * 查询投票未结束的信息
	 * @param sqlGeneralInfo
	 * @return
	 */
	public List<TransactionVoteContent> findInfo(SqlGeneralInfo sqlGeneralInfo);
	
	/**
	 * 查询投票结束的信息
	 * @param sqlGeneralInfo
	 * @return
	 */
	public List<TransactionVoteContent> findEndInfo(SqlGeneralInfo sqlGeneralInfo);
	
}
