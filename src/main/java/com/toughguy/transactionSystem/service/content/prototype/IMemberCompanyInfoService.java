package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.vo.MemberCompanyInfo;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IMemberCompanyInfoService 
	extends IGenericService<MemberCompanyInfo, Integer> {
	
	/**
	 * 注册用户
	 * @param memberCompanyInfo
	 */
	public void add(MemberCompanyInfo memberCompanyInfo);
}
