package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteContentDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;
@Service
public class VoteContentDaoImpl
extends GenericDaoImpl<TransactionVoteContent, Integer>
implements IVoteContentDao {

	@Override
	public void updateVoteOptionOne(TransactionVoteContent transactionVoteContent) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateVoteOptionOne", transactionVoteContent);
	}

	@Override
	public void updateVoteOptionTwo(TransactionVoteContent transactionVoteContent) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateVoteOptionTwo", transactionVoteContent);
	}

	@Override
	public PagerModel<TransactionVoteContent> findInfo(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
				if (params == null)
					params = new HashMap<String, Object>();
				params.put("offset", SystemContext.getOffset());
				params.put("limit", SystemContext.getPageSize());
				PagerModel<TransactionVoteContent> pm = new PagerModel<TransactionVoteContent>();
				int total = getTotalInfo(params);
				List<TransactionVoteContent> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findInfo", params);
				pm.setTotal(total);
				pm.setData(entitys);
				return pm;
	}
// -- 获取总的条目数 (分页查询中使用)
	private int getTotalInfo(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalInfo", params);
		return count;
	}
		

	@Override
	public PagerModel<TransactionVoteContent> findEndInfo(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());System.out.println("111111111111");
		params.put("limit", SystemContext.getPageSize());
		PagerModel<TransactionVoteContent> pm = new PagerModel<TransactionVoteContent>();
		int total = getTotalEndInfo(params);
		List<TransactionVoteContent> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findEndInfo", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalEndInfo(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalEndInfo", params);
		return count;
	}

}
