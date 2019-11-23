package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 会员的基本信息
 * @author 张泽
 *
 */
public interface IMemberBasicInfoDao extends IGenericDao<MemberBasicInfo, Integer> {
	
	/**
	 * 增加一条信息:
	 * 基本信息
	 * @return id
	 */
	public void saveBasicInfo(MemberBasicInfo info);
	
	/**
	 * 检查是否存在用户名及密码
	 * @param info
	 */
	public boolean loginCheck(TransactionMember info);
	
	/**
	 * 检查openId是否注册
	 * @param info
	 */
	public boolean checkOpenId(TransactionMember info);
	
	
	/**
	 * 更新密码
	 * @param info
	 */
	public void updatePassword(TransactionMember info);
	
	/**
	 * 解除绑定
	 * @param info
	 */
	public void updateUserTel(TransactionMember info);
	
	/**
	 * 所有的基本会员信息
	 * @return List<MemberBasicInfo>
	 */
	public List<MemberBasicInfo> memberInfo();
	
	/**
	 * 所有的基本企业信息
	 * @return List<MemberBasicInfo>
	 */
	public List<MemberBasicInfo> enterpriseInfo();
	
}
