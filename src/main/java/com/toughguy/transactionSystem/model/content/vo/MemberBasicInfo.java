package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 
 * @author 会员基本信息
 *
 */
public class MemberBasicInfo {
	private int memberId;  				//会员的id
//	private String openId;				//openid
	private String memberTel;			//会员的电话
//	private String memberPwd;			//会员的密码
	private Date memberDate;			//会员的注册时间
//	private String memberName;			//会员的姓名
//	private String memberCard;			//会员的身份证号
//	private int memberIntegral;			//会员积分
	private int memberRank;				//会员等级
	private int memberOnlineTimes;		//会员签到次数
	
	private String enterpriseName;				// 企业名称
//	private String enterpriseCardType;			// 企业证件类型
//	private String enterpriseCardId;			// 企业证件号

	public MemberBasicInfo(int memberId, String memberTel, Date memberDate, int memberRank, int memberOnlineTimes,
			String enterpriseName) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
		this.memberDate = memberDate;
		this.memberRank = memberRank;
		this.memberOnlineTimes = memberOnlineTimes;
		this.enterpriseName = enterpriseName;
	}
	public MemberBasicInfo() {
		super();
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public Date getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}
	public int getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(int memberRank) {
		this.memberRank = memberRank;
	}
	public int getMemberOnlineTimes() {
		return memberOnlineTimes;
	}
	public void setMemberOnlineTimes(int memberOnlineTimes) {
		this.memberOnlineTimes = memberOnlineTimes;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseName == null) ? 0 : enterpriseName.hashCode());
		result = prime * result + ((memberDate == null) ? 0 : memberDate.hashCode());
		result = prime * result + memberId;
		result = prime * result + memberOnlineTimes;
		result = prime * result + memberRank;
		result = prime * result + ((memberTel == null) ? 0 : memberTel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberBasicInfo other = (MemberBasicInfo) obj;
		if (enterpriseName == null) {
			if (other.enterpriseName != null)
				return false;
		} else if (!enterpriseName.equals(other.enterpriseName))
			return false;
		if (memberDate == null) {
			if (other.memberDate != null)
				return false;
		} else if (!memberDate.equals(other.memberDate))
			return false;
		if (memberId != other.memberId)
			return false;
		if (memberOnlineTimes != other.memberOnlineTimes)
			return false;
		if (memberRank != other.memberRank)
			return false;
		if (memberTel == null) {
			if (other.memberTel != null)
				return false;
		} else if (!memberTel.equals(other.memberTel))
			return false;
		return true;
	}
	
	
	
}
