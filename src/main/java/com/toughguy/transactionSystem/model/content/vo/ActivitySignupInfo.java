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
	private Date activitySignupStart;		//活动开始时间
	private Date activitySignupEnd;			//活动结束时间
	private int sum;						//报名人数
	private String activityPerson; 			//发布活动的企业（人）
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityImg == null) ? 0 : activityImg.hashCode());
		result = prime * result + ((activityName == null) ? 0 : activityName.hashCode());
		result = prime * result + ((activityPerson == null) ? 0 : activityPerson.hashCode());
		result = prime * result + ((activitySignupEnd == null) ? 0 : activitySignupEnd.hashCode());
		result = prime * result + ((activitySignupStart == null) ? 0 : activitySignupStart.hashCode());
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
		if (activityImg == null) {
			if (other.activityImg != null)
				return false;
		} else if (!activityImg.equals(other.activityImg))
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
		if (sum != other.sum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ActtivitySignupInfo [activityImg=" + activityImg + ", activityName=" + activityName
				+ ", activitySignupStart=" + activitySignupStart + ", activitySignupEnd=" + activitySignupEnd + ", sum="
				+ sum + ", activityPerson=" + activityPerson + "]";
	}
	
	
}
