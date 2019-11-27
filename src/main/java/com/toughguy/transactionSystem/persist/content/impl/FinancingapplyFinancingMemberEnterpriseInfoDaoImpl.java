package com.toughguy.transactionSystem.persist.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
import com.toughguy.transactionSystem.system.SystemContext;
/**
 * 融资申请表和融资表和会员表和企业表联系
 * @author liDongSheng
 *
 */
@Repository
public class FinancingapplyFinancingMemberEnterpriseInfoDaoImpl extends GenericDaoImpl<FinancingapplyFinancingMemberEnterpriseInfo, Integer>implements IFinancingapplyFinancingMemberEnterpriseInfoDao {

	@Override
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findStartFinancingList(Map<String, Object> params) {
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> pm = new PagerModel<FinancingapplyFinancingMemberEnterpriseInfo>();
		int total = getTotalNumStartFinancing(params);
		List<FinancingapplyFinancingMemberEnterpriseInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findStartFinancingList", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumStartFinancing(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalStartFinancing", params);
		return count;
	}


	@Override
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findRunFinancingList(
			Map<String, Object> params) {
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> pm = new PagerModel<FinancingapplyFinancingMemberEnterpriseInfo>();
		int total = getTotalNumRunFinancing(params);
		List<FinancingapplyFinancingMemberEnterpriseInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findRunFinancingList", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	// -- 获取总的条目数 (分页查询中使用)
	private int getTotalNumRunFinancing(Map<String, Object> params) {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalRunFinancing", params);
		return count;
	}

	@Override
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findEndFinancingList(
			Map<String, Object> params) {
		if (params == null)
			params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> pm = new PagerModel<FinancingapplyFinancingMemberEnterpriseInfo>();
		int total = getTotalNumEndFinancing(params);
		List<FinancingapplyFinancingMemberEnterpriseInfo> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findEndFinancingList", params);
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
