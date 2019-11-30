package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.toughguy.transactionSystem.model.content.vo.QuestOptionInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 
 * @author Guozhenze
 *
 */
public interface IQuestOptionInfoService extends IGenericService<QuestOptionInfo, Integer>{
	/**
	 * 	查找某一份卷的所有的问题
	 * @param info
	 * @return
	 */
	List<QuestOptionInfo> findOne(QuestOptionInfo info);
	/**
	 * 	新增一份卷子
	 * @param info
	 */
	void insertInfo(QuestOptionInfo info);
/*	*//**
	 * 
	 * 查询所有已结束的问卷调差
	 * @return
	 *//*
	
	List<QuestOptionInfo> selectEnd();*/
	
	/**
	 * 
	 * 查询所有未结束的问卷调差
	 * @return
	 */

	public PagerModel<QuestOptionInfo> selectNoEnd(Map<String, Object> params);
	

	
}
