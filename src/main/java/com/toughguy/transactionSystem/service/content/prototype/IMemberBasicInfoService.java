package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IMemberBasicInfoService
	extends IGenericService<MemberBasicInfo, Integer>{
	
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
	 * 检查openId是否已经注册
	 * @param info
	 */
	public boolean check(TransactionMember info);
	
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
