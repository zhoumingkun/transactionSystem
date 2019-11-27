package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.Map;

import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 融资申请表和融资表和会员表和企业表联系的dao
 * @author liDongSheng
 *
 */
public interface IFinancingapplyFinancingMemberEnterpriseInfoDao extends IGenericDao<FinancingapplyFinancingMemberEnterpriseInfo, Integer>{

	/**
	 * 查找某一个活动的待启动的融资
	 *
	 * @return
	 */
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findStartFinancingList(Map<String, Object> params);
	
	/**
	 * 查找某一个活动的进行中的融资
	 *
	 * @return
	 */
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findRunFinancingList(Map<String, Object> params);
	
	/**
	 * 查找某一个活动的结束的融资
	 *
	 * @return
	 */
	public PagerModel<FinancingapplyFinancingMemberEnterpriseInfo> findEndFinancingList(Map<String, Object> params);
}
