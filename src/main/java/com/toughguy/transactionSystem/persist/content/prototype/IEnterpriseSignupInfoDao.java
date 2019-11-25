package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.vo.EnterpriseSignupInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 * 企业和报名的dao层
 * @author liDongSheng
 *
 */
public interface IEnterpriseSignupInfoDao extends IGenericDao<EnterpriseSignupInfo, Integer>{
	/**
	 * 查找报名的企业列表
	 * @param transactionActivity
	 * @return
	 */
	public List<EnterpriseSignupInfo> findSignupEnterprise(EnterpriseSignupInfo enterpriseSignupInfo);
}
