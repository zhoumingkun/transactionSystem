package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.toughguy.transactionSystem.filter.PagerFilter;
import com.toughguy.transactionSystem.model.content.vo.QuestOptionInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 
 * @author Guozhenze
 *
 */

public interface IQuestOptionInfoDao  extends IGenericDao<QuestOptionInfo, Integer>{
	/**
	 * 	根据卷子id 查询卷子问题
	 * @param info
	 * @return
	 */
	List<QuestOptionInfo> findOneInfo(QuestOptionInfo info);
	
	/**
	 * 	新增一份卷子
	 * @param info
	 */
	void insertOneInfo(QuestOptionInfo info);
	
/*	*//**
	 * 	查询所有已结束的问卷调差
	 * @return
	 *//*
	List<QuestOptionInfo> selectEnd();*/
	/**
	 * 	查询所有未结束的问卷调差
	 * @return
	 */
	public PagerModel<QuestOptionInfo> selectNoEnd(Map<String, Object> params);
	/**
	 * 
	 * 	模糊查询
	 * @param params
	 * @return
	 */
	
	public PagerModel<QuestOptionInfo> selectLike(Map<String, Object> params);
	
}

