package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.QuestOptionInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IQuestOptionInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;
@Repository
public class QuestOptionInfoDaoImpl 
					extends GenericDaoImpl<QuestOptionInfo, Integer>
					implements IQuestOptionInfoDao{

	@Override
	public List<QuestOptionInfo> findOneInfo(QuestOptionInfo info) {
		return sqlSessionTemplate.selectList(typeNameSpace + ".findOneInfo", info);
	}

	@Override
	public void insertOneInfo(QuestOptionInfo info) {
		sqlSessionTemplate.insert(typeNameSpace + ".insertOneInfo", info);
		sqlSessionTemplate.insert(typeNameSpace + ".insertOneInfo2", info);
	}

	
	
	
	/*@Override
	public List<QuestOptionInfo> selectEnd() {
		return sqlSessionTemplate.selectList(typeNameSpace+ ".selectEnd");
	}*/

	@Override
	public PagerModel<QuestOptionInfo> selectNoEnd(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<QuestOptionInfo> pm = new PagerModel<QuestOptionInfo>();
		int total = getTotalNumOfItems(params);
		List<QuestOptionInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".selectNoEnd", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}

	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumOfItems(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalOfItemsNoEnd", params);
		return count;
	}

	@Override
	public PagerModel<QuestOptionInfo> selectLike(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<QuestOptionInfo> pm = new PagerModel<QuestOptionInfo>();
		int total = getTotalNumOfItemss(params);
		List<QuestOptionInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".selectLike", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	// -- 获取总的条目数 (分页查询中使用)
		private int getTotalNumOfItemss(Map<String, Object> params) {
			int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getSelectLike", params);
			return count;
		}

}
