package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IMemberBasicInfoService
	extends IGenericService<MemberBasicInfo, Integer>{
	
	/**
	 * 所有的基本企业信息
	 * @return List<MemberBasicInfo>
	 */
	public List<MemberBasicInfo> enterpriseInfo();
	

}
