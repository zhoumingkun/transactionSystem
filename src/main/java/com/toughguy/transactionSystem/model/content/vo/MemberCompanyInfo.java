package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

public class MemberCompanyInfo {
	private int memberId;	     // 会员id
	private String memberTel;	 // 会员电话
	private String memberPwd;	 // 会员密码
	private Date memberDate;	 // 会员注册日期
	private String memberName;   // 会员姓名
	private String memberCard;   // 会员身份证
	private int companyId;          // 企业id
	private String companyName;     // 企业名称
	private String companyCardType; // 企业证件类型
	private String companyCardId;   // 企业证件号
	
	public MemberCompanyInfo(int memberId, String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard, int companyId, String companyName, String companyCardType, String companyCardId) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyCardType = companyCardType;
		this.companyCardId = companyCardId;
	}
	public MemberCompanyInfo(String memberTel, String memberPwd, Date memberDate, String memberName, String memberCard,
			String companyName, String companyCardType, String companyCardId) {
		super();
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.companyName = companyName;
		this.companyCardType = companyCardType;
		this.companyCardId = companyCardId;
	}
	
	public MemberCompanyInfo(int memberId, String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard, String companyName, String companyCardType, String companyCardId) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.companyName = companyName;
		this.companyCardType = companyCardType;
		this.companyCardId = companyCardId;
	}
	public MemberCompanyInfo() {
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
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCardType() {
		return companyCardType;
	}
	public void setCompanyCardType(String companyCardType) {
		this.companyCardType = companyCardType;
	}
	public String getCompanyCardId() {
		return companyCardId;
	}
	public void setCompanyCardId(String companyCardId) {
		this.companyCardId = companyCardId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCardId == null) ? 0 : companyCardId.hashCode());
		result = prime * result + ((companyCardType == null) ? 0 : companyCardType.hashCode());
		result = prime * result + companyId;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((memberCard == null) ? 0 : memberCard.hashCode());
		result = prime * result + ((memberDate == null) ? 0 : memberDate.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPwd == null) ? 0 : memberPwd.hashCode());
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
		MemberCompanyInfo other = (MemberCompanyInfo) obj;
		if (companyCardId == null) {
			if (other.companyCardId != null)
				return false;
		} else if (!companyCardId.equals(other.companyCardId))
			return false;
		if (companyCardType == null) {
			if (other.companyCardType != null)
				return false;
		} else if (!companyCardType.equals(other.companyCardType))
			return false;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
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
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberPwd == null) {
			if (other.memberPwd != null)
				return false;
		} else if (!memberPwd.equals(other.memberPwd))
			return false;
		if (memberTel == null) {
			if (other.memberTel != null)
				return false;
		} else if (!memberTel.equals(other.memberTel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MemberCompanyInfo [memberId=" + memberId + ", memberTel=" + memberTel + ", memberPwd=" + memberPwd
				+ ", memberDate=" + memberDate + ", memberName=" + memberName + ", memberCard=" + memberCard
				+ ", companyId=" + companyId + ", companyName=" + companyName + ", companyCardType=" + companyCardType
				+ ", companyCardId=" + companyCardId + "]";
	}
	
	
	
}
