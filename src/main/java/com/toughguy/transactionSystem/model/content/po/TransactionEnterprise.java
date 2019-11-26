package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;
/**
 * 企业信息表
 * @author 张泽
 */
public class TransactionEnterprise {
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
	
	
	// 注册基本信息1
	public TransactionEnterprise(int memberId, String enterpriseName, String enterpriseCardType,
			String enterpriseCardId) {
		super();
		this.memberId = memberId;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
		this.enterpriseCardId = enterpriseCardId;
	}
	// 注册基本信息2 没有企业证件号
	public TransactionEnterprise(int memberId, String enterpriseName, String enterpriseCardType) {
		super();
		this.memberId = memberId;
		this.enterpriseName = enterpriseName;
		this.enterpriseCardType = enterpriseCardType;
	}

	// 判断公司名是否存在
	public TransactionEnterprise(String enterpriseName) {
		super();
		this.enterpriseName = enterpriseName;
	}
	//完善资料
	public TransactionEnterprise(int memberId, String enterpriseName, String enterpriseCardType,
			String enterpriseCardId, int enterpriseTypeId, int enterpriseTradeId, int enterpriseAreaId,
			int enterpriseAddressId, String enterpriseTaxpayer, Date enterpriseValidityDateStart,
			Date enterpriseValidityDateEnd, String enterpriseCertificationUnit, String enterpriseRegAddress,
			int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney, String enterpriseLegalPersonName,
			String enterpriseLegalPersonCard) {
		super();
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
	}

	public TransactionEnterprise(int memberId) {
		super();
		this.memberId = memberId;
	}
	public TransactionEnterprise(int enterpriseId, int memberId, String enterpriseName, String enterpriseCardType,
			String enterpriseCardId, int enterpriseTypeId, int enterpriseTradeId, int enterpriseAreaId,
			int enterpriseAddressId, String enterpriseTaxpayer, Date enterpriseValidityDateStart,
			Date enterpriseValidityDateEnd, String enterpriseCertificationUnit, String enterpriseRegAddress,
			int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney, String enterpriseLegalPersonName,
			String enterpriseLegalPersonCard, int enterpriseAuditStatusId) {
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
	}

	
	public TransactionEnterprise() {
		super();
	}


	public TransactionEnterprise(int memberId, String enterpriseName, String enterpriseCardType,
			String enterpriseCardId, int enterpriseTypeId, int enterpriseTradeId, int enterpriseAreaId,
			int enterpriseAddressId, String enterpriseTaxpayer, Date enterpriseValidityDateStart,
			Date enterpriseValidityDateEnd, String enterpriseCertificationUnit, String enterpriseRegAddress,
			int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney, String enterpriseLegalPersonName,
			String enterpriseLegalPersonCard, int enterpriseAuditStatusId) {
		super();
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TransactionEnterprise other = (TransactionEnterprise) obj;
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
		return true;
	}


	@Override
	public String toString() {
		return "TransactionEnterprise [enterpriseId=" + enterpriseId + ", memberId=" + memberId + ", enterpriseName="
				+ enterpriseName + ", enterpriseCardType=" + enterpriseCardType + ", enterpriseCardId="
				+ enterpriseCardId + ", enterpriseTypeId=" + enterpriseTypeId + ", enterpriseTradeId="
				+ enterpriseTradeId + ", enterpriseAreaId=" + enterpriseAreaId + ", enterpriseAddressId="
				+ enterpriseAddressId + ", enterpriseTaxpayer=" + enterpriseTaxpayer + ", enterpriseValidityDateStart="
				+ enterpriseValidityDateStart + ", enterpriseValidityDateEnd=" + enterpriseValidityDateEnd
				+ ", enterpriseCertificationUnit=" + enterpriseCertificationUnit + ", enterpriseRegAddress="
				+ enterpriseRegAddress + ", enterpriseStatusId=" + enterpriseStatusId + ", enterpriseRegDate="
				+ enterpriseRegDate + ", enterpriseRegMoney=" + enterpriseRegMoney + ", enterpriseLegalPersonName="
				+ enterpriseLegalPersonName + ", enterpriseLegalPersonCard=" + enterpriseLegalPersonCard
				+ ", enterpriseAuditStatusId=" + enterpriseAuditStatusId + "]";
	}

	
	
}
