package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 活动和报名表联系实体类
 * @author liDongSheng
 *
 */
public class ActivitySignupInfo {
	private String activityImg;				//活动图片
	private String activityName;			//活动名字
	private Date activitySignupStart;		//活动报名开始时间
	private Date activitySignupEnd;			//活动报名结束时间
	private int sum;						//报名人数
	private String activityPerson; 			//发布活动的企业（人）
	private Date activityStart;				//活动开始时间
	private Date activityEnd;				//活动结束时间
	private int activityId;         		//活动id
	private String activityContent;			//活动内容
	private String activityInbusiness;		//与会企业
	private String activityAddress;		    //活动地址
	private String activityTel;		        //活动电话
	private int signupId;					//报名编号
	private int memberId;					//会员编号（报名人）
	private Date signupDate;				//报名时间
	private String signupCode;				//报名二维码
	private boolean signupStatus;			//是否到场	
	
	public ActivitySignupInfo(int activityId, String activityContent, String activityInbusiness, String activityAddress,
			String activityTel, int signupId, int memberId, Date signupDate, String signupCode, boolean signupStatus) {
		super();
		this.activityId = activityId;
		this.activityContent = activityContent;
		this.activityInbusiness = activityInbusiness;
		this.activityAddress = activityAddress;
		this.activityTel = activityTel;
		this.signupId = signupId;
		this.memberId = memberId;
		this.signupDate = signupDate;
		this.signupCode = signupCode;
		this.signupStatus = signupStatus;
	}
	
	public ActivitySignupInfo(String activityImg, String activityName, Date activitySignupStart, Date activitySignupEnd,
			int sum, String activityPerson, Date activityStart, Date activityEnd, int activityId,
			String activityContent, String activityInbusiness, String activityAddress, String activityTel, int signupId,
			int memberId, Date signupDate, String signupCode, boolean signupStatus) {
		super();
		this.activityImg = activityImg;
		this.activityName = activityName;
		this.activitySignupStart = activitySignupStart;
		this.activitySignupEnd = activitySignupEnd;
		this.sum = sum;
		this.activityPerson = activityPerson;
		this.activityStart = activityStart;
		this.activityEnd = activityEnd;
		this.activityId = activityId;
		this.activityContent = activityContent;
		this.activityInbusiness = activityInbusiness;
		this.activityAddress = activityAddress;
		this.activityTel = activityTel;
		this.signupId = signupId;
		this.memberId = memberId;
		this.signupDate = signupDate;
		this.signupCode = signupCode;
		this.signupStatus = signupStatus;
	}

	public ActivitySignupInfo(String activityImg, String activityName, Date activitySignupStart,
			Date activitySignupEnd, int sum, String activityPerson) {
		super();
		this.activityImg = activityImg;
		this.activityName = activityName;
		this.activitySignupStart = activitySignupStart;
		this.activitySignupEnd = activitySignupEnd;
		this.sum = sum;
		this.activityPerson = activityPerson;
	}
	public ActivitySignupInfo() {
		super();
	}
	public String getActivityImg() {
		return activityImg;
	}
	public void setActivityImg(String activityImg) {
		this.activityImg = activityImg;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Date getActivitySignupStart() {
		return activitySignupStart;
	}
	public void setActivitySignupStart(Date activitySignupStart) {
		this.activitySignupStart = activitySignupStart;
	}
	public Date getActivitySignupEnd() {
		return activitySignupEnd;
	}
	public void setActivitySignupEnd(Date activitySignupEnd) {
		this.activitySignupEnd = activitySignupEnd;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getActivityPerson() {
		return activityPerson;
	}
	public void setActivityPerson(String activityPerson) {
		this.activityPerson = activityPerson;
	}
	
	public Date getActivityStart() {
		return activityStart;
	}
	public void setActivityStart(Date activityStart) {
		this.activityStart = activityStart;
	}
	public Date getActivityEnd() {
		return activityEnd;
	}
	public void setActivityEnd(Date activityEnd) {
		this.activityEnd = activityEnd;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityContent() {
		return activityContent;
	}
	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}
	public String getActivityInbusiness() {
		return activityInbusiness;
	}
	public void setActivityInbusiness(String activityInbusiness) {
		this.activityInbusiness = activityInbusiness;
	}
	public String getActivityAddress() {
		return activityAddress;
	}
	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}
	public String getActivityTel() {
		return activityTel;
	}
	public void setActivityTel(String activityTel) {
		this.activityTel = activityTel;
	}
	public int getSignupId() {
		return signupId;
	}
	public void setSignupId(int signupId) {
		this.signupId = signupId;
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
		result = prime * result + ((activityAddress == null) ? 0 : activityAddress.hashCode());
		result = prime * result + ((activityContent == null) ? 0 : activityContent.hashCode());
		result = prime * result + ((activityEnd == null) ? 0 : activityEnd.hashCode());
		result = prime * result + activityId;
		result = prime * result + ((activityImg == null) ? 0 : activityImg.hashCode());
		result = prime * result + ((activityInbusiness == null) ? 0 : activityInbusiness.hashCode());
		result = prime * result + ((activityName == null) ? 0 : activityName.hashCode());
		result = prime * result + ((activityPerson == null) ? 0 : activityPerson.hashCode());
		result = prime * result + ((activitySignupEnd == null) ? 0 : activitySignupEnd.hashCode());
		result = prime * result + ((activitySignupStart == null) ? 0 : activitySignupStart.hashCode());
		result = prime * result + ((activityStart == null) ? 0 : activityStart.hashCode());
		result = prime * result + ((activityTel == null) ? 0 : activityTel.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((signupCode == null) ? 0 : signupCode.hashCode());
		result = prime * result + ((signupDate == null) ? 0 : signupDate.hashCode());
		result = prime * result + signupId;
		result = prime * result + (signupStatus ? 1231 : 1237);
		result = prime * result + sum;
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
		ActivitySignupInfo other = (ActivitySignupInfo) obj;
		if (activityAddress == null) {
			if (other.activityAddress != null)
				return false;
		} else if (!activityAddress.equals(other.activityAddress))
			return false;
		if (activityContent == null) {
			if (other.activityContent != null)
				return false;
		} else if (!activityContent.equals(other.activityContent))
			return false;
		if (activityEnd == null) {
			if (other.activityEnd != null)
				return false;
		} else if (!activityEnd.equals(other.activityEnd))
			return false;
		if (activityId != other.activityId)
			return false;
		if (activityImg == null) {
			if (other.activityImg != null)
				return false;
		} else if (!activityImg.equals(other.activityImg))
			return false;
		if (activityInbusiness == null) {
			if (other.activityInbusiness != null)
				return false;
		} else if (!activityInbusiness.equals(other.activityInbusiness))
			return false;
		if (activityName == null) {
			if (other.activityName != null)
				return false;
		} else if (!activityName.equals(other.activityName))
			return false;
		if (activityPerson == null) {
			if (other.activityPerson != null)
				return false;
		} else if (!activityPerson.equals(other.activityPerson))
			return false;
		if (activitySignupEnd == null) {
			if (other.activitySignupEnd != null)
				return false;
		} else if (!activitySignupEnd.equals(other.activitySignupEnd))
			return false;
		if (activitySignupStart == null) {
			if (other.activitySignupStart != null)
				return false;
		} else if (!activitySignupStart.equals(other.activitySignupStart))
			return false;
		if (activityStart == null) {
			if (other.activityStart != null)
				return false;
		} else if (!activityStart.equals(other.activityStart))
			return false;
		if (activityTel == null) {
			if (other.activityTel != null)
				return false;
		} else if (!activityTel.equals(other.activityTel))
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
		if (sum != other.sum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ActivitySignupInfo [activityImg=" + activityImg + ", activityName=" + activityName
				+ ", activitySignupStart=" + activitySignupStart + ", activitySignupEnd=" + activitySignupEnd + ", sum="
				+ sum + ", activityPerson=" + activityPerson + ", activityStart=" + activityStart + ", activityEnd="
				+ activityEnd + ", activityId=" + activityId + ", activityContent=" + activityContent
				+ ", activityInbusiness=" + activityInbusiness + ", activityAddress=" + activityAddress
				+ ", activityTel=" + activityTel + ", signupId=" + signupId + ", memberId=" + memberId + ", signupDate="
				+ signupDate + ", signupCode=" + signupCode + ", signupStatus=" + signupStatus + "]";
	}
	
}
