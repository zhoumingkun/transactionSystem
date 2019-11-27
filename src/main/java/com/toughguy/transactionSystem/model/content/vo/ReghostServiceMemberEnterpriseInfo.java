package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 登记托管和服务类型的实体类
 * @author liDongSheng
 *
 */
public class ReghostServiceMemberEnterpriseInfo {
	private int serviceId;				//服务类型的编号
	private String serviceType;			//服务类型
	private int reghostId; 				// 登记托管id
	private int memberId; 				// 会员id
	private Date reghostDate;			//登记托管的时间
	private String memberTel;			//会员的电话
	private String memberName;			//会员的姓名
	private String enterpriseName;		// 企业名称
	private String enterpriseCardType;	// 企业证件类型
	/*
	private String reghostName;				//登记企业名称
	private String reghostPerson;			//联系人
	private String reghostTel;				//手机号
	private String reghostServicePerson;	//服务人员
	private String reghostNeed;				//需求说明
	private int enterpriseTypeId;			//企业类型
	*/
	public ReghostServiceMemberEnterpriseInfo(int serviceId, String serviceType, int reghostId, int memberId,
			Date reghostDate, String memberTel, String memberName, String enterpriseName, String enterpriseCardType) {
		super();
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.reghostId = reghostId;
		this.memberId = memberId;
		this.reghostDate = reghostDate;
		this.memberTel = memberTel;
		this.memberName = memberName;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
	}
	public ReghostServiceMemberEnterpriseInfo(String serviceType, int reghostId, int memberId, Date reghostDate,
			String memberTel, String memberName, String enterpriseName, String enterpriseCardType) {
		super();
		this.serviceType = serviceType;
		this.reghostId = reghostId;
		this.memberId = memberId;
		this.reghostDate = reghostDate;
		this.memberTel = memberTel;
		this.memberName = memberName;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
	}
	public ReghostServiceMemberEnterpriseInfo() {
		super();
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getReghostId() {
		return reghostId;
	}
	public void setReghostId(int reghostId) {
		this.reghostId = reghostId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getReghostDate() {
		return reghostDate;
	}
	public void setReghostDate(Date reghostDate) {
		this.reghostDate = reghostDate;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseCardType == null) ? 0 : enterpriseCardType.hashCode());
		result = prime * result + ((enterpriseName == null) ? 0 : enterpriseName.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberTel == null) ? 0 : memberTel.hashCode());
		result = prime * result + ((reghostDate == null) ? 0 : reghostDate.hashCode());
		result = prime * result + reghostId;
		result = prime * result + serviceId;
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
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
		ReghostServiceMemberEnterpriseInfo other = (ReghostServiceMemberEnterpriseInfo) obj;
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
		if (memberId != other.memberId)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberTel == null) {
			if (other.memberTel != null)
				return false;
		} else if (!memberTel.equals(other.memberTel))
			return false;
		if (reghostDate == null) {
			if (other.reghostDate != null)
				return false;
		} else if (!reghostDate.equals(other.reghostDate))
			return false;
		if (reghostId != other.reghostId)
			return false;
		if (serviceId != other.serviceId)
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReghostServiceMemberEnterpriseInfo [serviceId=" + serviceId + ", serviceType=" + serviceType
				+ ", reghostId=" + reghostId + ", memberId=" + memberId + ", reghostDate=" + reghostDate
				+ ", memberTel=" + memberTel + ", memberName=" + memberName + ", enterpriseName=" + enterpriseName
				+ ", enterpriseCardType=" + enterpriseCardType + "]";
	}
	
}
