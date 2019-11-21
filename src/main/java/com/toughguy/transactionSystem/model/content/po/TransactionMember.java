package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;
/**
 * 会员实体类
 * @author liDongSheng
 *
 */
public class TransactionMember {
	private int memberId;  				//会员的id
	private String memberTel;			//会员的电话
	private String memberPwd;			//会员的密码
	private Date memberDate;			//会员的注册时间
	private String memberName;			//会员的姓名
	private String memberCard;			//会员的身份证号
	private int integralId;				//会员积分编号
	private String openId;				//openid	
	public TransactionMember(int memberId, String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard, int integralId, String openId) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.integralId = integralId;
		this.openId = openId;
	}
	public TransactionMember(String memberTel, String memberPwd, Date memberDate, String memberName, String memberCard,
			int integralId, String openId) {
		super();
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.integralId = integralId;
		this.openId = openId;
	}
	public TransactionMember() {
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
	public int getIntegralId() {
		return integralId;
	}
	public void setIntegralId(int integralId) {
		this.integralId = integralId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + integralId;
		result = prime * result + ((memberCard == null) ? 0 : memberCard.hashCode());
		result = prime * result + ((memberDate == null) ? 0 : memberDate.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPwd == null) ? 0 : memberPwd.hashCode());
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
		TransactionMember other = (TransactionMember) obj;
		if (integralId != other.integralId)
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
		if (openId == null) {
			if (other.openId != null)
				return false;
		} else if (!openId.equals(other.openId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionMember [memberId=" + memberId + ", memberTel=" + memberTel + ", memberPwd=" + memberPwd
				+ ", memberDate=" + memberDate + ", memberName=" + memberName + ", memberCard=" + memberCard
				+ ", integralId=" + integralId + ", openId=" + openId + "]";
	}
	
	
	
	
}
