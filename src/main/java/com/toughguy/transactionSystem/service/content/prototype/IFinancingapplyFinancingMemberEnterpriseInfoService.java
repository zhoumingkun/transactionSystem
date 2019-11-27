package com.toughguy.transactionSystem.service.content.prototype;

import java.util.Map;

import com.toughguy.transactionSystem.model.content.vo.FinancingapplyFinancingMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 融资申请表和融资表和会员表和企业表联系service
 * @author liDongSheng
 *
 */
public interface IFinancingapplyFinancingMemberEnterpriseInfoService extends IGenericService<FinancingapplyFinancingMemberEnterpriseInfo, Integer>{
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
