package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IActivitySignupInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;
/**
 * 活动发布的实现
 * @author liDongSheng
 *
 */
@Repository
public class ActivitySignupInfoDaoImpl extends GenericDaoImpl<ActivitySignupInfo, Integer>implements IActivitySignupInfoDao{

	@Override
	public PagerModel<ActivitySignupInfo> findEndActivity(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<ActivitySignupInfo> pm = new PagerModel<ActivitySignupInfo>();
		int total = getTotalNumEndActivity(params);
		List<ActivitySignupInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findEndActivity", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}

	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumEndActivity(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalEndActivity", params);
		return count;
	}

	@Override
	public PagerModel<ActivitySignupInfo> findEndActivitySignup(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<ActivitySignupInfo> pm = new PagerModel<ActivitySignupInfo>();
		int total = getTotalNumEndActivitySignup(params);
		List<ActivitySignupInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findEndActivitySignup", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumEndActivitySignup(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalEndActivitySignup", params);
		return count;
	}
	
}
