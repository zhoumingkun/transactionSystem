package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMember;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.model.content.vo.SqlGeneralInfo;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 会员dao
 * @author 张泽
 */
public interface IMemberDao extends IGenericDao<TransactionMember, Integer> {
	/**
	 * 检查openId是否已经注册
	 * @param info
	 */
	public boolean check(TransactionMember info);
	
	/**
	 * 登录
	 * 检查是否存在用户名及密码
	 * @param info
	 */
	public boolean loginCheck(TransactionMember info);
	
	/**
	 * 更新密码
	 * @param info
	 */
	public void updatePassword(TransactionMember info);
	/**
	 * 忘记密码
	 * @param info
	 */
//	public void resetPassword(TransactionMember info);
	
	/**
	 * 解除绑定
	 * @param info
	 */
	public void updateUserTel(TransactionMember info);
	
	/**
	 * 注册:
	 * 基本信息
	 * @return id
	 */
	public TransactionMember saveBasicInfo(TransactionMember info);
	
	/**
	 * 用户登录后返回信息
	 * @param info
	 * @return
	 */
	public TransactionMember openIdFindUser(TransactionMember info);
/**
 * 签到接口
 */
	/**
	 * 根据memberid查找签到次数
	 * @param info
	 * @return
	 */
	public TransactionMember findOnlineTimes(TransactionMember info);
	
	/**
	 * 根据memberid更新签到次数
	 * @param info
	 */
	public void updateOnlineTimes(TransactionMember info);
	
/**
 * 积分接口
 */	
	/**
	 * 根据memberid查找积分
	 * @param info
	 * @return
	 */
	public TransactionMember findIntegral(TransactionMember info);
	
	/**
	 * 根据memberid更新积分
	 * @param info
	 */
	public void updateIntegral(TransactionMember info);
	
/**
 * 查询手机号是否存在接口
 */	
	/**
	 * 手机号是否存在
	 * @param info
	 * @return
	 */
	public boolean findTel(SqlGeneralInfo info);
	
	/**
	 * 查询所有个人会员的基本信息
	 * @return
	 */
	List<TransactionMember> memberInfo();
	
	/**
	 * 查询所有企业会员的基本信息
	 * @return
	 */
	public List<MemberBasicInfo> enterpriseInfo();
	
	/**
	 * 根据关键字查找
	 * @param sqlGeneralInfo
	 * @return
	 */
	public List<MemberBasicInfo> findKeyword(SqlGeneralInfo sqlGeneralInfo);
	
	/**
	 * 根据memberId 和 onlinetime 查找今天签到的用户是否存在
	 * @param transactionMember
	 * @return
	 */
	public TransactionMember findTodayOnline(TransactionMember transactionMember);
}
