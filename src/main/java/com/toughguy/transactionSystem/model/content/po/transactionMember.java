package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

public class transactionMember {
	private int memberId;
	private String memberTel;
	private String memberPwd;
	private Date memberDate;
	private String memberName;
	private String memberCard;
	public transactionMember(int memberId, String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
	}
	public transactionMember(String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard) {
		super();
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
	}
	public transactionMember() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		transactionMember other = (transactionMember) obj;
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
		return "transactionMember [memberId=" + memberId + ", memberTel=" + memberTel + ", memberPwd=" + memberPwd
				+ ", memberDate=" + memberDate + ", memberName=" + memberName + ", memberCard=" + memberCard + "]";
	}
	
	
	
	
}
