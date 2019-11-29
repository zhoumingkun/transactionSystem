package com.toughguy.transactionSystem.persist.content.prototype;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.model.content.vo.MemberCompleteInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 企业dao
 * @author 张泽
 */
public interface IEnterpriseDao extends IGenericDao<TransactionEnterprise, Integer> {
	
	/**
	 * 注册基本信息
	 * @param member
	 */
	public void insertBasicMsg(TransactionEnterprise info);
	public void insertMsgNoCard(TransactionEnterprise info);
	/**
	 * 根据公司名查找
	 * @param info
	 * @return
	 */
	public TransactionEnterprise findEnterpriseName(TransactionEnterprise info);
	
	/**
	 * 完善基本资料
	 * @param info
	 */
	public void saveCompleteInfo(TransactionEnterprise info);
	
	/**
	 * 返回资料完善的对象
	 * @param transactionEnterprise
	 * @return TransactionEnterprise
	 */
	public TransactionEnterprise isComplete(TransactionEnterprise transactionEnterprise);
	/**
	 * 返回企业会员完整资料
	 * @param transactionEnterprise
	 * @return
	 */
	public MemberCompleteInfo findEnterpriseInfo(TransactionEnterprise transactionEnterprise);

	/**
	 * 证件类型是否唯一
	 * @param sqlGeneralInfo
	 * @return
	 */
	public TransactionEnterprise isUniqueEnterCard(SqlGeneralInfo sqlGeneralInfo);

}
