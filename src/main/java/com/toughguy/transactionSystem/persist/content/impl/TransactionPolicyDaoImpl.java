package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionPolicyDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;

@Repository
public class TransactionPolicyDaoImpl 
				extends GenericDaoImpl<TransactionPolicy, Integer>
				implements ITransactionPolicyDao{

	@Override
	public PagerModel<TransactionPolicy> selectOrId(Map<String, Object> params) {
	// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionPolicy> pm = new PagerModel<TransactionPolicy>();
		int total = getTotalNumOfItems(params);
		List<TransactionPolicy> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".selectOrId", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}

	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumOfItems(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getselectOrId", params);
		return count;
	}

	@Override
	public PagerModel<TransactionPolicy> selectLike(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionPolicy> pm = new PagerModel<TransactionPolicy>();
		int total = getTotalNumOfItemss(params);
		List<TransactionPolicy> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".selectLike", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumOfItemss(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getselectLike", params);
		return count;
	}

	@Override
	public PagerModel<TransactionPolicy> findLike(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionPolicy> pm = new PagerModel<TransactionPolicy>();
		int total = getTotalNumOfItemsLike(params);
		List<TransactionPolicy> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findLike", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumOfItemsLike(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getfindLike", params);
		return count;
	}

	@Override
	public PagerModel<TransactionPolicy> findLikePolicyName(Map<String, Object> params) {
		// TODO Auto-generated method stub
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionPolicy> pm = new PagerModel<TransactionPolicy>();
		int total = getTotalNumOfItemsLike(params);
		List<TransactionPolicy> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findLikePolicyName", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
}

