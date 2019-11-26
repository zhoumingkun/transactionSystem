package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;
/**
 * 会员实体类
 * @author 张泽
 *
 */
public class TransactionMember {
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
	private Date memberOnlineTime;		//会员签到时间
	public TransactionMember() {
		super();
	}	
	
	public TransactionMember(int memberId, Date memberOnlineTime) {
		super();
		this.memberId = memberId;
		this.memberOnlineTime = memberOnlineTime;
	}

	public TransactionMember(int memberId) {
		super();
		this.memberId = memberId;
	}

	public TransactionMember(String openId) {
		super();
		this.openId = openId;
	}
	
	/**
	 * 更新手机号
	 * @param memberId
	 * @param memberTel
	 */
	public TransactionMember(int memberId, String memberTel) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
	}

	public TransactionMember(String openId, String memberTel) {
		super();
		this.openId = openId;
		this.memberTel = memberTel;
	}

	public TransactionMember(int memberId, int memberIntegral) {
		super();
		this.memberId = memberId;
		this.memberIntegral = memberIntegral;
	}
	/**
	 * 忘记密码/登录
	 * @param openId
	 * @param memberTel
	 * @param memberPwd
	 */
	public TransactionMember(String openId, String memberTel, String memberPwd) {
		super();
		this.openId = openId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
	}

	public TransactionMember(int memberId, String openId, String memberTel, String memberPwd) {
		super();
		this.memberId = memberId;
		this.openId = openId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
	}
	
	public TransactionMember(int memberId, int memberIntegral, int memberRank, int memberOnlineTimes) {
		super();
		this.memberId = memberId;
		this.memberIntegral = memberIntegral;
		this.memberRank = memberRank;
		this.memberOnlineTimes = memberOnlineTimes;
	}
	
	//注册
	public TransactionMember(String openId, String memberTel, String memberPwd, Date memberDate, String memberName,
			String memberCard) {
		super();
		this.openId = openId;
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
	}
	
	//展示
	public TransactionMember(int memberId, String memberTel, Date memberDate, String memberName, String memberCard,
			int memberIntegral, int memberRank) {
		super();
		this.memberId = memberId;
		this.memberTel = memberTel;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.memberIntegral = memberIntegral;
		this.memberRank = memberRank;
	}
	
	
	public TransactionMember(int memberId, String openId, String memberTel, String memberPwd, Date memberDate,
			String memberName, String memberCard, int memberIntegral, int memberRank, int memberOnlineTimes) {
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

	
	public Date getMemberOnlineTime() {
		return memberOnlineTime;
	}

	public void setMemberOnlineTime(Date memberOnlineTime) {
		this.memberOnlineTime = memberOnlineTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberCard == null) ? 0 : memberCard.hashCode());
		result = prime * result + ((memberDate == null) ? 0 : memberDate.hashCode());
		result = prime * result + memberId;
		result = prime * result + memberIntegral;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberOnlineTime == null) ? 0 : memberOnlineTime.hashCode());
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
		TransactionMember other = (TransactionMember) obj;
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
		if (memberOnlineTime == null) {
			if (other.memberOnlineTime != null)
				return false;
		} else if (!memberOnlineTime.equals(other.memberOnlineTime))
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

	@Override
	public String toString() {
		return "TransactionMember [memberId=" + memberId + ", openId=" + openId + ", memberTel=" + memberTel
				+ ", memberPwd=" + memberPwd + ", memberDate=" + memberDate + ", memberName=" + memberName
				+ ", memberCard=" + memberCard + ", memberIntegral=" + memberIntegral + ", memberRank=" + memberRank
				+ ", memberOnlineTimes=" + memberOnlineTimes + ", memberOnlineTime=" + memberOnlineTime + "]";
	}
	
	
}
