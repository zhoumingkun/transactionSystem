package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 
 * @author 会员基本信息
 *
 */
public class MemberBasicInfo {
	private int memberId;  				//会员的id
	private String openId;				//openid
	private String memberTel;			//会员的电话
	private String memberPwd;			//会员的密码
	private Date memberDate;			//会员的注册时间
	private String memberName;			//会员的姓名
	private String memberCard;			//会员的身份证号
	private int memberIntegral;			//会员积分
	private int memberRank;				//会员等级
	private int memberOnlineTimes;		//会员签到次数
	
	private String enterpriseName;				// 企业名称
	private String enterpriseCardType;			// 企业证件类型
	private String enterpriseCardId;			// 企业证件号
	
	/**
	 * 基本资料
	 * @param memberTel
	 * @param memberPwd
	 * @param memberDate
	 * @param memberName
	 * @param memberCard
	 * @param openId
	 * @param enterpriseName
	 * @param enterpriseCardType
	 * @param enterpriseCardId
	 */
	public MemberBasicInfo(String openId, String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard, String enterpriseName, String enterpriseCardType, String enterpriseCardId) {
		super();
		this.openId = openId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
		this.enterpriseCardId = enterpriseCardId;
	}
	
	
	/**
	 * 签到接口
	 * @param memberId
	 * @param memberOnlineTimes
	 */
	public MemberBasicInfo(int memberId, int memberOnlineTimes) {
		super();
		this.memberId = memberId;
		this.memberOnlineTimes = memberOnlineTimes;
	}
	
	
	/**
	 * 手机查询接口
	 * @param memberTel
	 */
	public MemberBasicInfo(String memberTel) {
		super();
		this.memberTel = memberTel;
	}
	


	public MemberBasicInfo(int memberId, String openId, String memberTel, String memberPwd, Date memberDate,
			String memberName, String memberCard, int memberIntegral, int memberRank, int memberOnlineTimes,
			String enterpriseName, String enterpriseCardType, String enterpriseCardId) {
		super();
		this.memberId = memberId;
		this.openId = openId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.memberIntegral = memberIntegral;
		this.memberRank = memberRank;
		this.memberOnlineTimes = memberOnlineTimes;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
		this.enterpriseCardId = enterpriseCardId;
	}
	
	
	public MemberBasicInfo(int memberId) {
		super();
		this.memberId = memberId;
	}


	public MemberBasicInfo() {
		super();
	}

	@Override
	public String toString() {
		return "MemberBasicInfo [memberId=" + memberId + ", openId=" + openId + ", memberTel=" + memberTel
				+ ", memberPwd=" + memberPwd + ", memberDate=" + memberDate + ", memberName=" + memberName
				+ ", memberCard=" + memberCard + ", memberIntegral=" + memberIntegral + ", memberRank=" + memberRank
				+ ", memberOnlineTimes=" + memberOnlineTimes + ", enterpriseName=" + enterpriseName
				+ ", enterpriseCardType=" + enterpriseCardType + ", enterpriseCardId=" + enterpriseCardId + "]";
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public Date getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberCard() {
		return memberCard;
	}

	public void setMemberCard(String memberCard) {
		this.memberCard = memberCard;
	}

	public int getMemberIntegral() {
		return memberIntegral;
	}

	public void setMemberIntegral(int memberIntegral) {
		this.memberIntegral = memberIntegral;
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

	public String getEnterpriseCardType() {
		return enterpriseCardType;
	}

	public void setEnterpriseCardType(String enterpriseCardType) {
		this.enterpriseCardType = enterpriseCardType;
	}

	public String getEnterpriseCardId() {
		return enterpriseCardId;
	}

	public void setEnterpriseCardId(String enterpriseCardId) {
		this.enterpriseCardId = enterpriseCardId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseCardId == null) ? 0 : enterpriseCardId.hashCode());
		result = prime * result + ((enterpriseCardType == null) ? 0 : enterpriseCardType.hashCode());
		result = prime * result + ((enterpriseName == null) ? 0 : enterpriseName.hashCode());
		result = prime * result + ((memberCard == null) ? 0 : memberCard.hashCode());
		result = prime * result + ((memberDate == null) ? 0 : memberDate.hashCode());
		result = prime * result + memberId;
		result = prime * result + memberIntegral;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + memberOnlineTimes;
		result = prime * result + ((memberPwd == null) ? 0 : memberPwd.hashCode());
		result = prime * result + memberRank;
		result = prime * result + ((memberTel == null) ? 0 : memberTel.hashCode());
		result = prime * result + ((openId == null) ? 0 : openId.hashCode());
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
		if (enterpriseCardId == null) {
			if (other.enterpriseCardId != null)
				return false;
		} else if (!enterpriseCardId.equals(other.enterpriseCardId))
			return false;
		if (enterpriseCardType == null) {
			if (other.enterpriseCardType != null)
				return false;
		} else if (!enterpriseCardType.equals(other.enterpriseCardType))
			return false;
		if (enterpriseName == null) {
			if (other.enterpriseName != null)
				return false;
		} else if (!enterpriseName.equals(other.enterpriseName))
			return false;
		if (memberCard == null) {
			if (other.memberCard != null)
				return false;
		} else if (!memberCard.equals(other.memberCard))
			return false;
		if (memberDate == null) {
			if (other.memberDate != null)
				return false;
		} else if (!memberDate.equals(other.memberDate))
			return false;
		if (memberId != other.memberId)
			return false;
		if (memberIntegral != other.memberIntegral)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberOnlineTimes != other.memberOnlineTimes)
			return false;
		if (memberPwd == null) {
			if (other.memberPwd != null)
				return false;
		} else if (!memberPwd.equals(other.memberPwd))
			return false;
		if (memberRank != other.memberRank)
			return false;
		if (memberTel == null) {
			if (other.memberTel != null)
				return false;
		} else if (!memberTel.equals(other.memberTel))
			return false;
		if (openId == null) {
			if (other.openId != null)
				return false;
		} else if (!openId.equals(other.openId))
			return false;
		return true;
	}
	
}
