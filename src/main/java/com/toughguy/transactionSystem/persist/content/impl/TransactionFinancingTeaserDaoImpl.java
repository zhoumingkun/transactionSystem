package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancingTeaser;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingTeaserDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;
@Repository
public class TransactionFinancingTeaserDaoImpl extends GenericDaoImpl<TransactionFinancingTeaser, Integer>implements ITransactionFinancingTeaserDao{
	
	@Override
	public List<TransactionFinancingTeaser> findAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findAll");
	}
	
	@Override
	public PagerModel<TransactionFinancingTeaser> findPaginated(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionFinancingTeaser> pm = new PagerModel<TransactionFinancingTeaser>();
		int total = getTotalOfItems(params);
		List<TransactionFinancingTeaser> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findPaginated", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalOfItems(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalOfItems", params);
		return count;
	}
}
