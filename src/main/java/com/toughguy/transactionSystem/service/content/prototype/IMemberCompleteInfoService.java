package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IMemberCompleteInfoService 
	extends IGenericService<MemberCompleteInfo, Integer>{
	
	/**
	 * 完善全部信息
	 * @return id
	 */
	public void saveCompleteInfo(MemberCompleteInfo info);
	
	
	/**
	 * 查找一个企业用户信息
	 * @param id
	 * @return
	 */
	public MemberCompleteInfo findEnterpriseInfo(MemberCompleteInfo info);
}
