package com.toughguy.transactionSystem.service.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IEnterpriseService extends IGenericService<TransactionEnterprise, Integer>{
	
	/**
	 * 注册基本信息
	 * @param member
	 */
	public void insertMsg(TransactionEnterprise info);
	/**
	 * 注册基本信息【没有企业证号】
	 * @param info
	 */
	public void insertMsgNoCard(TransactionEnterprise info);
	/**
	 * 判断公司名是否存在
	 * @param info
	 * @return
	 */
	public boolean findEnterpriseName(TransactionEnterprise info);
	
	/**
	 * 完善基本信息
	 * @param info
	 */
	public void saveCompleteInfo(TransactionEnterprise info);
	
	/**
	 * 是否完善信息
	 * @param transactionEnterprise
	 * @return boolean
	 */
	public boolean isComplete(TransactionEnterprise transactionEnterprise);
	
	/**
	 * 返回企业用户完整信息
	 * @param transactionEnterprise
	 * @return
	 */
	public MemberCompleteInfo findEnterpriseInfo(TransactionEnterprise transactionEnterprise);
	
	/**
	 * 企业证件号是否唯一
	 * @param sqlGeneralInfo
	 * @return
	 */
	public boolean isUniqueEnterCard(SqlGeneralInfo sqlGeneralInfo);
	
	
	
	
}
