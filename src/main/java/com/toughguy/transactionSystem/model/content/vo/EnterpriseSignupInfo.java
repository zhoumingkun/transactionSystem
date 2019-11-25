package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;
/**
 * 企业表和报名表联系的实体类
 * @author liDongSheng
 *
 */
public class EnterpriseSignupInfo {
	private int enterpriseId;					// 企业ID
	private int memberId;						// 会员ID
	private String enterpriseName;				// 企业名称
	private String enterpriseCardType;			// 企业证件类型
	private String enterpriseCardId;			// 企业证件号
	private int enterpriseTypeId;				// 企业类型ID
	private int enterpriseTradeId;				// 所属行业ID
	private int enterpriseAreaId;				// 所属领域ID
	private int enterpriseAddressId;			// 所在地区ID
	private String enterpriseTaxpayer;			// 纳税人识别号
	private Date enterpriseValidityDateStart;	// 证件有限期开始时间
	private Date enterpriseValidityDateEnd;		// 证件有限期结束时间
	private String enterpriseCertificationUnit; // 发证单位
	private String enterpriseRegAddress;		// 注册地址
	private int enterpriseStatusId;				// 企业状态ID
	private Date enterpriseRegDate;				// 注册日期
	private double enterpriseRegMoney;			// 注册资本
	private String enterpriseLegalPersonName;   // 法定代表人名称
	private String enterpriseLegalPersonCard;	// 法定代表人身份证
	private int enterpriseAuditStatusId;			// 企业审核状态
	private int signupId;				//报名编号
	private int activityId;			//活动编号
	private Date signupDate;			//报名时间
	private String signupCode;			//报名二维码
	private Boolean signupStatus;		//是否到场
	public EnterpriseSignupInfo(int enterpriseId, int memberId, String enterpriseName, String enterpriseCardType,
			String enterpriseCardId, int enterpriseTypeId, int enterpriseTradeId, int enterpriseAreaId,
			int enterpriseAddressId, String enterpriseTaxpayer, Date enterpriseValidityDateStart,
			Date enterpriseValidityDateEnd, String enterpriseCertificationUnit, String enterpriseRegAddress,
			int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney, String enterpriseLegalPersonName,
			String enterpriseLegalPersonCard, int enterpriseAuditStatusId, int signupId, int activityId,
			Date signupDate, String signupCode, Boolean signupStatus) {
		super();
		this.enterpriseId = enterpriseId;
		this.memberId = memberId;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
		this.enterpriseCardId = enterpriseCardId;
		this.enterpriseTypeId = enterpriseTypeId;
		this.enterpriseTradeId = enterpriseTradeId;
		this.enterpriseAreaId = enterpriseAreaId;
		this.enterpriseAddressId = enterpriseAddressId;
		this.enterpriseTaxpayer = enterpriseTaxpayer;
		this.enterpriseValidityDateStart = enterpriseValidityDateStart;
		this.enterpriseValidityDateEnd = enterpriseValidityDateEnd;
		this.enterpriseCertificationUnit = enterpriseCertificationUnit;
		this.enterpriseRegAddress = enterpriseRegAddress;
		this.enterpriseStatusId = enterpriseStatusId;
		this.enterpriseRegDate = enterpriseRegDate;
		this.enterpriseRegMoney = enterpriseRegMoney;
		this.enterpriseLegalPersonName = enterpriseLegalPersonName;
		this.enterpriseLegalPersonCard = enterpriseLegalPersonCard;
		this.enterpriseAuditStatusId = enterpriseAuditStatusId;
		this.signupId = signupId;
		this.activityId = activityId;
		this.signupDate = signupDate;
		this.signupCode = signupCode;
		this.signupStatus = signupStatus;
	}
	public EnterpriseSignupInfo() {
		super();
	}
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	public int getEnterpriseTypeId() {
		return enterpriseTypeId;
	}
	public void setEnterpriseTypeId(int enterpriseTypeId) {
		this.enterpriseTypeId = enterpriseTypeId;
	}
	public int getEnterpriseTradeId() {
		return enterpriseTradeId;
	}
	public void setEnterpriseTradeId(int enterpriseTradeId) {
		this.enterpriseTradeId = enterpriseTradeId;
	}
	public int getEnterpriseAreaId() {
		return enterpriseAreaId;
	}
	public void setEnterpriseAreaId(int enterpriseAreaId) {
		this.enterpriseAreaId = enterpriseAreaId;
	}
	public int getEnterpriseAddressId() {
		return enterpriseAddressId;
	}
	public void setEnterpriseAddressId(int enterpriseAddressId) {
		this.enterpriseAddressId = enterpriseAddressId;
	}
	public String getEnterpriseTaxpayer() {
		return enterpriseTaxpayer;
	}
	public void setEnterpriseTaxpayer(String enterpriseTaxpayer) {
		this.enterpriseTaxpayer = enterpriseTaxpayer;
	}
	public Date getEnterpriseValidityDateStart() {
		return enterpriseValidityDateStart;
	}
	public void setEnterpriseValidityDateStart(Date enterpriseValidityDateStart) {
		this.enterpriseValidityDateStart = enterpriseValidityDateStart;
	}
	public Date getEnterpriseValidityDateEnd() {
		return enterpriseValidityDateEnd;
	}
	public void setEnterpriseValidityDateEnd(Date enterpriseValidityDateEnd) {
		this.enterpriseValidityDateEnd = enterpriseValidityDateEnd;
	}
	public String getEnterpriseCertificationUnit() {
		return enterpriseCertificationUnit;
	}
	public void setEnterpriseCertificationUnit(String enterpriseCertificationUnit) {
		this.enterpriseCertificationUnit = enterpriseCertificationUnit;
	}
	public String getEnterpriseRegAddress() {
		return enterpriseRegAddress;
	}
	public void setEnterpriseRegAddress(String enterpriseRegAddress) {
		this.enterpriseRegAddress = enterpriseRegAddress;
	}
	public int getEnterpriseStatusId() {
		return enterpriseStatusId;
	}
	public void setEnterpriseStatusId(int enterpriseStatusId) {
		this.enterpriseStatusId = enterpriseStatusId;
	}
	public Date getEnterpriseRegDate() {
		return enterpriseRegDate;
	}
	public void setEnterpriseRegDate(Date enterpriseRegDate) {
		this.enterpriseRegDate = enterpriseRegDate;
	}
	public double getEnterpriseRegMoney() {
		return enterpriseRegMoney;
	}
	public void setEnterpriseRegMoney(double enterpriseRegMoney) {
		this.enterpriseRegMoney = enterpriseRegMoney;
	}
	public String getEnterpriseLegalPersonName() {
		return enterpriseLegalPersonName;
	}
	public void setEnterpriseLegalPersonName(String enterpriseLegalPersonName) {
		this.enterpriseLegalPersonName = enterpriseLegalPersonName;
	}
	public String getEnterpriseLegalPersonCard() {
		return enterpriseLegalPersonCard;
	}
	public void setEnterpriseLegalPersonCard(String enterpriseLegalPersonCard) {
		this.enterpriseLegalPersonCard = enterpriseLegalPersonCard;
	}
	public int getEnterpriseAuditStatusId() {
		return enterpriseAuditStatusId;
	}
	public void setEnterpriseAuditStatusId(int enterpriseAuditStatusId) {
		this.enterpriseAuditStatusId = enterpriseAuditStatusId;
	}
	public int getSignupId() {
		return signupId;
	}
	public void setSignupId(int signupId) {
		this.signupId = signupId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
	public Boolean getSignupStatus() {
		return signupStatus;
	}
	public void setSignupStatus(Boolean signupStatus) {
		this.signupStatus = signupStatus;
	}
	@Override
	public String toString() {
		return "EnterpriseSignupInfo [enterpriseId=" + enterpriseId + ", memberId=" + memberId + ", enterpriseName="
				+ enterpriseName + ", enterpriseCardType=" + enterpriseCardType + ", enterpriseCardId="
				+ enterpriseCardId + ", enterpriseTypeId=" + enterpriseTypeId + ", enterpriseTradeId="
				+ enterpriseTradeId + ", enterpriseAreaId=" + enterpriseAreaId + ", enterpriseAddressId="
				+ enterpriseAddressId + ", enterpriseTaxpayer=" + enterpriseTaxpayer + ", enterpriseValidityDateStart="
				+ enterpriseValidityDateStart + ", enterpriseValidityDateEnd=" + enterpriseValidityDateEnd
				+ ", enterpriseCertificationUnit=" + enterpriseCertificationUnit + ", enterpriseRegAddress="
				+ enterpriseRegAddress + ", enterpriseStatusId=" + enterpriseStatusId + ", enterpriseRegDate="
				+ enterpriseRegDate + ", enterpriseRegMoney=" + enterpriseRegMoney + ", enterpriseLegalPersonName="
				+ enterpriseLegalPersonName + ", enterpriseLegalPersonCard=" + enterpriseLegalPersonCard
				+ ", enterpriseAuditStatusId=" + enterpriseAuditStatusId + ", signupId=" + signupId + ", activityId="
				+ activityId + ", signupDate=" + signupDate + ", signupCode=" + signupCode + ", signupStatus="
				+ signupStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activityId;
		result = prime * result + enterpriseAddressId;
		result = prime * result + enterpriseAreaId;
		result = prime * result + enterpriseAuditStatusId;
		result = prime * result + ((enterpriseCardId == null) ? 0 : enterpriseCardId.hashCode());
		result = prime * result + ((enterpriseCardType == null) ? 0 : enterpriseCardType.hashCode());
		result = prime * result + ((enterpriseCertificationUnit == null) ? 0 : enterpriseCertificationUnit.hashCode());
		result = prime * result + enterpriseId;
		result = prime * result + ((enterpriseLegalPersonCard == null) ? 0 : enterpriseLegalPersonCard.hashCode());
		result = prime * result + ((enterpriseLegalPersonName == null) ? 0 : enterpriseLegalPersonName.hashCode());
		result = prime * result + ((enterpriseName == null) ? 0 : enterpriseName.hashCode());
		result = prime * result + ((enterpriseRegAddress == null) ? 0 : enterpriseRegAddress.hashCode());
		result = prime * result + ((enterpriseRegDate == null) ? 0 : enterpriseRegDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(enterpriseRegMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + enterpriseStatusId;
		result = prime * result + ((enterpriseTaxpayer == null) ? 0 : enterpriseTaxpayer.hashCode());
		result = prime * result + enterpriseTradeId;
		result = prime * result + enterpriseTypeId;
		result = prime * result + ((enterpriseValidityDateEnd == null) ? 0 : enterpriseValidityDateEnd.hashCode());
		result = prime * result + ((enterpriseValidityDateStart == null) ? 0 : enterpriseValidityDateStart.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((signupCode == null) ? 0 : signupCode.hashCode());
		result = prime * result + ((signupDate == null) ? 0 : signupDate.hashCode());
		result = prime * result + signupId;
		result = prime * result + ((signupStatus == null) ? 0 : signupStatus.hashCode());
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
		EnterpriseSignupInfo other = (EnterpriseSignupInfo) obj;
		if (activityId != other.activityId)
			return false;
		if (enterpriseAddressId != other.enterpriseAddressId)
			return false;
		if (enterpriseAreaId != other.enterpriseAreaId)
			return false;
		if (enterpriseAuditStatusId != other.enterpriseAuditStatusId)
			return false;
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
		if (enterpriseCertificationUnit == null) {
			if (other.enterpriseCertificationUnit != null)
				return false;
		} else if (!enterpriseCertificationUnit.equals(other.enterpriseCertificationUnit))
			return false;
		if (enterpriseId != other.enterpriseId)
			return false;
		if (enterpriseLegalPersonCard == null) {
			if (other.enterpriseLegalPersonCard != null)
				return false;
		} else if (!enterpriseLegalPersonCard.equals(other.enterpriseLegalPersonCard))
			return false;
		if (enterpriseLegalPersonName == null) {
			if (other.enterpriseLegalPersonName != null)
				return false;
		} else if (!enterpriseLegalPersonName.equals(other.enterpriseLegalPersonName))
			return false;
		if (enterpriseName == null) {
			if (other.enterpriseName != null)
				return false;
		} else if (!enterpriseName.equals(other.enterpriseName))
			return false;
		if (enterpriseRegAddress == null) {
			if (other.enterpriseRegAddress != null)
				return false;
		} else if (!enterpriseRegAddress.equals(other.enterpriseRegAddress))
			return false;
		if (enterpriseRegDate == null) {
			if (other.enterpriseRegDate != null)
				return false;
		} else if (!enterpriseRegDate.equals(other.enterpriseRegDate))
			return false;
		if (Double.doubleToLongBits(enterpriseRegMoney) != Double.doubleToLongBits(other.enterpriseRegMoney))
			return false;
		if (enterpriseStatusId != other.enterpriseStatusId)
			return false;
		if (enterpriseTaxpayer == null) {
			if (other.enterpriseTaxpayer != null)
				return false;
		} else if (!enterpriseTaxpayer.equals(other.enterpriseTaxpayer))
			return false;
		if (enterpriseTradeId != other.enterpriseTradeId)
			return false;
		if (enterpriseTypeId != other.enterpriseTypeId)
			return false;
		if (enterpriseValidityDateEnd == null) {
			if (other.enterpriseValidityDateEnd != null)
				return false;
		} else if (!enterpriseValidityDateEnd.equals(other.enterpriseValidityDateEnd))
			return false;
		if (enterpriseValidityDateStart == null) {
			if (other.enterpriseValidityDateStart != null)
				return false;
		} else if (!enterpriseValidityDateStart.equals(other.enterpriseValidityDateStart))
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
		if (signupStatus == null) {
			if (other.signupStatus != null)
				return false;
		} else if (!signupStatus.equals(other.signupStatus))
			return false;
		return true;
	}
	
	
	
	
	
	
}
