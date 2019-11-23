package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 后台企业用户信息
 * @author 张泽
 *
 */
public class EnterpriseMemberInfo {
	
	private int memberId;  				//会员的id
	private String openId;				//openid
	
	private String enterpriseName;		// 企业名称
	private String memberTel;			//会员的电话

	private int memberRank;				//会员等级
	private int memberOnlineTimes;		//会员签到次数
	private Date memberDate;			//会员的注册时间
	
	
}
