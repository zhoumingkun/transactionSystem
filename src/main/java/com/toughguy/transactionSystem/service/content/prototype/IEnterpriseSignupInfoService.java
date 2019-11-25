package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.vo.EnterpriseSignupInfo;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseSignupInfoService extends IGenericService<EnterpriseSignupInfo, Integer> {
	/**
	 * 查找报名的企业列表
	 * @param transactionActivity
	 * @return
	 */
	public List<EnterpriseSignupInfo> findSignupEnterpriseList(EnterpriseSignupInfo enterpriseSignupInfo);
}
