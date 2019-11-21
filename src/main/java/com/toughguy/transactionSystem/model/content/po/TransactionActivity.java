package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;
/**
 * 活动发布实体类
 * @author liDongSheng
 *
 */
public class TransactionActivity {
	private int activityId;         		//活动id
	private String activityName;			//活动名称
	private String activityPerson;			//活动发起公司（人）
	private String activityContent;			//活动内容
	private String activityImg;				//活动图片
	private Date activitySignupStart;		//报名开始时间
	private Date activitySignupEnd;			//报名结束时间
	private Date activityStart;				//活动开始时间
	private Date activityEnd;				//活动结束时间
	public TransactionActivity(int activityId, String activityName, String activityPerson, String activityContent,
			String activityImg, Date activitySignupStart, Date activitySignupEnd, Date activityStart,
			Date activityEnd) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityPerson = activityPerson;
		this.activityContent = activityContent;
		this.activityImg = activityImg;
		this.activitySignupStart = activitySignupStart;
		this.activitySignupEnd = activitySignupEnd;
		this.activityStart = activityStart;
		this.activityEnd = activityEnd;
	}
	public TransactionActivity(String activityName, String activityPerson, String activityContent, String activityImg,
			Date activitySignupStart, Date activitySignupEnd, Date activityStart, Date activityEnd) {
		super();
		this.activityName = activityName;
		this.activityPerson = activityPerson;
		this.activityContent = activityContent;
		this.activityImg = activityImg;
		this.activitySignupStart = activitySignupStart;
		this.activitySignupEnd = activitySignupEnd;
		this.activityStart = activityStart;
		this.activityEnd = activityEnd;
	}
	public TransactionActivity() {
		super();
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityPerson() {
		return activityPerson;
	}
	public void setActivityPerson(String activityPerson) {
		this.activityPerson = activityPerson;
	}
	public String getActivityContent() {
		return activityContent;
	}
	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}
	public String getActivityImg() {
		return activityImg;
	}
	public void setActivityImg(String activityImg) {
		this.activityImg = activityImg;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityContent == null) ? 0 : activityContent.hashCode());
		result = prime * result + ((activityEnd == null) ? 0 : activityEnd.hashCode());
		result = prime * result + activityId;
		result = prime * result + ((activityImg == null) ? 0 : activityImg.hashCode());
		result = prime * result + ((activityName == null) ? 0 : activityName.hashCode());
		result = prime * result + ((activityPerson == null) ? 0 : activityPerson.hashCode());
		result = prime * result + ((activitySignupEnd == null) ? 0 : activitySignupEnd.hashCode());
		result = prime * result + ((activitySignupStart == null) ? 0 : activitySignupStart.hashCode());
		result = prime * result + ((activityStart == null) ? 0 : activityStart.hashCode());
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
		TransactionActivity other = (TransactionActivity) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "TransactionActivity [activityId=" + activityId + ", activityName=" + activityName + ", activityPerson="
				+ activityPerson + ", activityContent=" + activityContent + ", activityImg=" + activityImg
				+ ", activitySignupStart=" + activitySignupStart + ", activitySignupEnd=" + activitySignupEnd
				+ ", activityStart=" + activityStart + ", activityEnd=" + activityEnd + "]";
	}
	
	
	
}
