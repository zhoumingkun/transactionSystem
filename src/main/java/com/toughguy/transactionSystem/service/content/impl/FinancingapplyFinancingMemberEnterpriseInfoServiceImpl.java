package com.toughguy.transactionSystem.service.content.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IFinancingapplyFinancingMemberEnterpriseInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
/**
 * 融资申请表和融资表和会员表和企业表联系service
 * @author liDongSheng
 *
 */
@Service
public class FinancingapplyFinancingMemberEnterpriseInfoServiceImpl extends GenericServiceImpl<FinancingapplyFinancingMemberEnterpriseInfo, Integer> implements IFinancingapplyFinancingMemberEnterpriseInfoService{
	@Autowired
	private IFinancingapplyFinancingMemberEnterpriseInfoDao financingapplyFinancingMemberEnterpriseInfoDao;

	@Override
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findStartFinancingList(Map<String, Object> params) {
		return financingapplyFinancingMemberEnterpriseInfoDao.findStartFinancingList(params);
	}

	@Override
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findRunFinancingList(Map<String, Object> params) {
		return financingapplyFinancingMemberEnterpriseInfoDao.findRunFinancingList(params);
	}

	@Override
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findEndFinancingList(Map<String, Object> params) {
		return financingapplyFinancingMemberEnterpriseInfoDao.findEndFinancingList(params);
	}

}
