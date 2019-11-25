package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionFinancingDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;
@Repository
public class TransactionFinancingDaoImpl extends GenericDaoImpl<TransactionFinancing, Integer>implements ITransactionFinancingDao{
	
	@Override
	public PagerModel<TransactionFinancing> findEndFinancing(Map<String, Object> params) {
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionFinancing> pm = new PagerModel<TransactionFinancing>();
		int total = getTotalNumEndFinancing(params);
		List<TransactionFinancing> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findEndFinancing", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}

	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumEndFinancing(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalEndFinancing", params);
		return count;
	}
}
