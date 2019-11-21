package com.toughguy.transactionSystem.model.content.po;
/**
 * 活动报名实体类
 * @author liDongSheng
 *
 */

import java.util.Date;

public class TransactionSignup {
	private int signupId;				//报名编号
	private int acttivityId;			//活动编号
	private int memberId;				//会员编号（报名人）
	private Date signupDate;			//报名时间
	private String signupCode;			//报名二维码
	private boolean signupStatus;		//是否到场		
	public TransactionSignup(int signupId, int acttivityId, int memberId, Date signupDate, String signupCode,
			boolean signupStatus) {
		super();
		this.signupId = signupId;
		this.acttivityId = acttivityId;
		this.memberId = memberId;
		this.signupDate = signupDate;
		this.signupCode = signupCode;
		this.signupStatus = signupStatus;
	}
	public TransactionSignup(int acttivityId, int memberId, Date signupDate, String signupCode, boolean signupStatus) {
		super();
		this.acttivityId = acttivityId;
		this.memberId = memberId;
		this.signupDate = signupDate;
		this.signupCode = signupCode;
		this.signupStatus = signupStatus;
	}
	
	public TransactionSignup() {
		super();
	}
	public int getSignupId() {
		return signupId;
	}
	public void setSignupId(int signupId) {
		this.signupId = signupId;
	}
	public int getActtivityId() {
		return acttivityId;
	}
	public void setActtivityId(int acttivityId) {
		this.acttivityId = acttivityId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
	public String getSignupCode() {
		return signupCode;
	}
	public void setSignupCode(String signupCode) {
		this.signupCode = signupCode;
	}
	public boolean isSignupStatus() {
		return signupStatus;
	}
	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acttivityId;
		result = prime * result + memberId;
		result = prime * result + ((signupCode == null) ? 0 : signupCode.hashCode());
		result = prime * result + ((signupDate == null) ? 0 : signupDate.hashCode());
		result = prime * result + signupId;
		result = prime * result + (signupStatus ? 1231 : 1237);
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
		TransactionSignup other = (TransactionSignup) obj;
		if (acttivityId != other.acttivityId)
			return false;
		if (memberId != other.memberId)
			return false;
		if (signupCode == null) {
			if (other.signupCode != null)
				return false;
		} else if (!signupCode.equals(other.signupCode))
			return false;
		if (signupDate == null) {
			if (other.signupDate != null)
				return false;
		} else if (!signupDate.equals(other.signupDate))
			return false;
		if (signupId != other.signupId)
			return false;
		if (signupStatus != other.signupStatus)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionSignup [signupId=" + signupId + ", acttivityId=" + acttivityId + ", memberId=" + memberId
				+ ", signupDate=" + signupDate + ", signupCode=" + signupCode + ", signupStatus=" + signupStatus + "]";
	}
	
	
	
	
}
