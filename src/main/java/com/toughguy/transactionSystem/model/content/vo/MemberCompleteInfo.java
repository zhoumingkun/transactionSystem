package com.toughguy.transactionSystem.model.content.vo;

import java.io.Serializable;
import java.util.Date;

public class MemberCompleteInfo implements Serializable {

	private static final long serialVersionUID = 2214948310859590902L;
	// 会员基本信息
	private int memberId;  				//会员的id
	private String openId;				//openid
	
	private String memberName;			//会员的姓名
	private String memberTel;			//会员的电话
	private String memberCard;			//会员的身份证号
	
	private int memberIntegral;			//会员积分
	private int memberRank;				//会员等级
	private int memberOnlineTimes;		//会员签到次数
	private Date memberDate;			//会员的注册时间
	
	// 企业完整信息
	private int enterpriseId;					// 企业ID
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
	// 审核状态信息
	private String auditStatusType;		// 状态类型
	
	// 行业信息
	private String tradeType;	//行业类型
	
	// 企业类型
	private String enterpriseType;  // 企业类型
	
	// 企业状态
	private String enterpriseStatus;	// 企业状态
	
	// 所在领域
//	private int enterpriseAreaId;	// ID
	private String enterpriseArea;	// 领域
	
	// 地址信息
	private String addressName;	// 地址名
	
	
	
	 public MemberCompleteInfo(int memberId) {
		super();
		this.memberId = memberId;
	}

	/**
	  * 完善资料
	  * 
	  * @param memberId
	  * @param openId
	  * @param enterpriseAddressId
	  * @param enterpriseTradeId
	  * @param enterpriseAreaId
	  * @param enterpriseTaxpayer
	  * @param enterpriseValidityDateStart
	  * @param enterpriseValidityDateEnd
	  * @param enterpriseCertificationUnit
	  * @param enterpriseRegAddress
	  * @param enterpriseStatusId
	  * @param enterpriseRegDate
	  * @param enterpriseRegMoney
	  * @param enterpriseLegalPersonName
	  * @param enterpriseLegalPersonCard
	  * @param enterpriseAuditStatus
	  * @param enterpriseTypeId
	  */
	public MemberCompleteInfo(int memberId, String openId, int enterpriseAddressId, int enterpriseTradeId, int enterpriseAreaId, String enterpriseTaxpayer,
			Date enterpriseValidityDateStart, Date enterpriseValidityDateEnd, String enterpriseCertificationUnit, String enterpriseRegAddress,
			int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney, String enterpriseLegalPersonName,
			String enterpriseLegalPersonCard, int enterpriseAuditStatus, int enterpriseTypeId) {
		super();
		this.memberId = memberId;
		this.openId = openId;
		this.enterpriseAddressId = enterpriseAddressId;
		this.enterpriseTradeId = enterpriseTradeId;
		this.enterpriseAreaId = enterpriseAreaId;
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
		this.enterpriseAuditStatusId = enterpriseAuditStatus;
		this.enterpriseTypeId = enterpriseTypeId;
	}

	public MemberCompleteInfo(int memberId, String openId, String memberName, String memberTel, String memberCard,
			int memberIntegral, int memberRank, int memberOnlineTimes, Date memberDate, int enterpriseId,
			String enterpriseName, String enterpriseCardType, String enterpriseCardId, int enterpriseTypeId,
			int enterpriseTradeId, int enterpriseAreaId, int enterpriseAddressId, String enterpriseTaxpayer,
			Date enterpriseValidityDateStart, Date enterpriseValidityDateEnd, String enterpriseCertificationUnit,
			String enterpriseRegAddress, int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney,
			String enterpriseLegalPersonName, String enterpriseLegalPersonCard, int enterpriseAuditStatusId,
			String auditStatusType, String tradeType, String enterpriseType, String enterpriseStatus,
			String enterpriseArea, String addressName) {
		super();
		this.memberId = memberId;
		this.openId = openId;
		this.memberName = memberName;
		this.memberTel = memberTel;
		this.memberCard = memberCard;
		this.memberIntegral = memberIntegral;
		this.memberRank = memberRank;
		this.memberOnlineTimes = memberOnlineTimes;
		this.memberDate = memberDate;
		this.enterpriseId = enterpriseId;
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
		this.auditStatusType = auditStatusType;
		this.tradeType = tradeType;
		this.enterpriseType = enterpriseType;
		this.enterpriseStatus = enterpriseStatus;
		this.enterpriseArea = enterpriseArea;
		this.addressName = addressName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result + ((auditStatusType == null) ? 0 : auditStatusType.hashCode());
		result = prime * result + enterpriseAddressId;
		result = prime * result + ((enterpriseArea == null) ? 0 : enterpriseArea.hashCode());
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
		result = prime * result + ((enterpriseStatus == null) ? 0 : enterpriseStatus.hashCode());
		result = prime * result + enterpriseStatusId;
		result = prime * result + ((enterpriseTaxpayer == null) ? 0 : enterpriseTaxpayer.hashCode());
		result = prime * result + enterpriseTradeId;
		result = prime * result + ((enterpriseType == null) ? 0 : enterpriseType.hashCode());
		result = prime * result + enterpriseTypeId;
		result = prime * result + ((enterpriseValidityDateEnd == null) ? 0 : enterpriseValidityDateEnd.hashCode());
		result = prime * result + ((enterpriseValidityDateStart == null) ? 0 : enterpriseValidityDateStart.hashCode());
		result = prime * result + ((memberCard == null) ? 0 : memberCard.hashCode());
		result = prime * result + ((memberDate == null) ? 0 : memberDate.hashCode());
		result = prime * result + memberId;
		result = prime * result + memberIntegral;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + memberOnlineTimes;
		result = prime * result + memberRank;
		result = prime * result + ((memberTel == null) ? 0 : memberTel.hashCode());
		result = prime * result + ((openId == null) ? 0 : openId.hashCode());
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
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
		MemberCompleteInfo other = (MemberCompleteInfo) obj;
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
			return false;
		if (auditStatusType == null) {
			if (other.auditStatusType != null)
				return false;
		} else if (!auditStatusType.equals(other.auditStatusType))
			return false;
		if (enterpriseAddressId != other.enterpriseAddressId)
			return false;
		if (enterpriseArea == null) {
			if (other.enterpriseArea != null)
				return false;
		} else if (!enterpriseArea.equals(other.enterpriseArea))
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
		if (enterpriseStatus == null) {
			if (other.enterpriseStatus != null)
				return false;
		} else if (!enterpriseStatus.equals(other.enterpriseStatus))
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
		if (enterpriseType == null) {
			if (other.enterpriseType != null)
				return false;
		} else if (!enterpriseType.equals(other.enterpriseType))
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
		if (memberOnlineTimes != other.memberOnlineTimes)
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
		if (tradeType == null) {
			if (other.tradeType != null)
				return false;
		} else if (!tradeType.equals(other.tradeType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberCompleteInfo [memberId=" + memberId + ", openId=" + openId + ", memberName=" + memberName
				+ ", memberTel=" + memberTel + ", memberCard=" + memberCard + ", memberIntegral=" + memberIntegral
				+ ", memberRank=" + memberRank + ", memberOnlineTimes=" + memberOnlineTimes + ", memberDate="
				+ memberDate + ", enterpriseId=" + enterpriseId + ", enterpriseName=" + enterpriseName
				+ ", enterpriseCardType=" + enterpriseCardType + ", enterpriseCardId=" + enterpriseCardId
				+ ", enterpriseTypeId=" + enterpriseTypeId + ", enterpriseTradeId=" + enterpriseTradeId
				+ ", enterpriseAreaId=" + enterpriseAreaId + ", enterpriseAddressId=" + enterpriseAddressId
				+ ", enterpriseTaxpayer=" + enterpriseTaxpayer + ", enterpriseValidityDateStart="
				+ enterpriseValidityDateStart + ", enterpriseValidityDateEnd=" + enterpriseValidityDateEnd
				+ ", enterpriseCertificationUnit=" + enterpriseCertificationUnit + ", enterpriseRegAddress="
				+ enterpriseRegAddress + ", enterpriseStatusId=" + enterpriseStatusId + ", enterpriseRegDate="
				+ enterpriseRegDate + ", enterpriseRegMoney=" + enterpriseRegMoney + ", enterpriseLegalPersonName="
				+ enterpriseLegalPersonName + ", enterpriseLegalPersonCard=" + enterpriseLegalPersonCard
				+ ", enterpriseAuditStatusId=" + enterpriseAuditStatusId + ", auditStatusType=" + auditStatusType
				+ ", tradeType=" + tradeType + ", enterpriseType=" + enterpriseType + ", enterpriseStatus="
				+ enterpriseStatus + ", enterpriseArea=" + enterpriseArea + ", addressName=" + addressName + "]";
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
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

	public Date getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
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

	public String getAuditStatusType() {
		return auditStatusType;
	}

	public void setAuditStatusType(String auditStatusType) {
		this.auditStatusType = auditStatusType;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getEnterpriseStatus() {
		return enterpriseStatus;
	}

	public void setEnterpriseStatus(String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}

	public String getEnterpriseArea() {
		return enterpriseArea;
	}

	public void setEnterpriseArea(String enterpriseArea) {
		this.enterpriseArea = enterpriseArea;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	

	
}

	