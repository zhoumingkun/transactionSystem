package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 融资申请表和融资表和会员表和企业表联系实体类
 * @author liDongSheng
 *
 */
public class FinancingapplyFinancingMemberEnterpriseInfo {
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
	private String memberTel;			//会员的电话
	private String memberPwd;			//会员的密码
	private Date memberDate;			//会员的注册时间
	private String memberName;			//会员的姓名
	private String memberCard;			//会员的身份证号
	private int memberIntegral;			//会员积分
	private int memberRank;				//会员等级
	private int memberOnlineTimes;		//会员签到次数
	private Date memberOnlineTime;		//会员签到时间
	private int financingId;      				//融资信息id
	private String financingName;				//项目名称
	private String financingPeople;				//发起企业（人）
	private String financingContent;			//融资产品内容	
	private String financingImg;				//图片
	private Date financingStart;				//活动开始时间
	private Date financingEnd;					//活动结束时间
	private int financingRank;					//可报名等级
	private int financingPv;					//访问量
	private Date financingReleaseDate;			//发布时间
	private int addressId;						//区域id
	private int applyId;							//申请id
	private Date applyDate;							//申请时间
	private Boolean applyStatus;					//申请状态
	private Boolean financingCompleteStatus;		//融资完成状态
	public FinancingapplyFinancingMemberEnterpriseInfo(int enterpriseId, int memberId, String enterpriseName,
			String enterpriseCardType, String enterpriseCardId, int enterpriseTypeId, int enterpriseTradeId,
			int enterpriseAreaId, int enterpriseAddressId, String enterpriseTaxpayer, Date enterpriseValidityDateStart,
			Date enterpriseValidityDateEnd, String enterpriseCertificationUnit, String enterpriseRegAddress,
			int enterpriseStatusId, Date enterpriseRegDate, double enterpriseRegMoney, String enterpriseLegalPersonName,
			String enterpriseLegalPersonCard, int enterpriseAuditStatusId, String memberTel, String memberPwd,
			Date memberDate, String memberName, String memberCard, int memberIntegral, int memberRank,
			int memberOnlineTimes, Date memberOnlineTime, int financingId, String financingName, String financingPeople,
			String financingContent, String financingImg, Date financingStart, Date financingEnd, int financingRank,
			int financingPv, Date financingReleaseDate, int addressId, int applyId, Date applyDate, Boolean applyStatus,
			Boolean financingCompleteStatus) {
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
		this.memberTel = memberTel;
		this.memberPwd = memberPwd;
		this.memberDate = memberDate;
		this.memberName = memberName;
		this.memberCard = memberCard;
		this.memberIntegral = memberIntegral;
		this.memberRank = memberRank;
		this.memberOnlineTimes = memberOnlineTimes;
		this.memberOnlineTime = memberOnlineTime;
		this.financingId = financingId;
		this.financingName = financingName;
		this.financingPeople = financingPeople;
		this.financingContent = financingContent;
		this.financingImg = financingImg;
		this.financingStart = financingStart;
		this.financingEnd = financingEnd;
		this.financingRank = financingRank;
		this.financingPv = financingPv;
		this.financingReleaseDate = financingReleaseDate;
		this.addressId = addressId;
		this.applyId = applyId;
		this.applyDate = applyDate;
		this.applyStatus = applyStatus;
		this.financingCompleteStatus = financingCompleteStatus;
	}
	public FinancingapplyFinancingMemberEnterpriseInfo() {
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
	public int getFinancingId() {
		return financingId;
	}
	public void setFinancingId(int financingId) {
		this.financingId = financingId;
	}
	public String getFinancingName() {
		return financingName;
	}
	public void setFinancingName(String financingName) {
		this.financingName = financingName;
	}
	public String getFinancingPeople() {
		return financingPeople;
	}
	public void setFinancingPeople(String financingPeople) {
		this.financingPeople = financingPeople;
	}
	public String getFinancingContent() {
		return financingContent;
	}
	public void setFinancingContent(String financingContent) {
		this.financingContent = financingContent;
	}
	public String getFinancingImg() {
		return financingImg;
	}
	public void setFinancingImg(String financingImg) {
		this.financingImg = financingImg;
	}
	public Date getFinancingStart() {
		return financingStart;
	}
	public void setFinancingStart(Date financingStart) {
		this.financingStart = financingStart;
	}
	public Date getFinancingEnd() {
		return financingEnd;
	}
	public void setFinancingEnd(Date financingEnd) {
		this.financingEnd = financingEnd;
	}
	public int getFinancingRank() {
		return financingRank;
	}
	public void setFinancingRank(int financingRank) {
		this.financingRank = financingRank;
	}
	public int getFinancingPv() {
		return financingPv;
	}
	public void setFinancingPv(int financingPv) {
		this.financingPv = financingPv;
	}
	public Date getFinancingReleaseDate() {
		return financingReleaseDate;
	}
	public void setFinancingReleaseDate(Date financingReleaseDate) {
		this.financingReleaseDate = financingReleaseDate;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Boolean getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(Boolean applyStatus) {
		this.applyStatus = applyStatus;
	}
	public Boolean getFinancingCompleteStatus() {
		return financingCompleteStatus;
	}
	public void setFinancingCompleteStatus(Boolean financingCompleteStatus) {
		this.financingCompleteStatus = financingCompleteStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + applyId;
		result = prime * result + ((applyStatus == null) ? 0 : applyStatus.hashCode());
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
		result = prime * result + ((financingCompleteStatus == null) ? 0 : financingCompleteStatus.hashCode());
		result = prime * result + ((financingContent == null) ? 0 : financingContent.hashCode());
		result = prime * result + ((financingEnd == null) ? 0 : financingEnd.hashCode());
		result = prime * result + financingId;
		result = prime * result + ((financingImg == null) ? 0 : financingImg.hashCode());
		result = prime * result + ((financingName == null) ? 0 : financingName.hashCode());
		result = prime * result + ((financingPeople == null) ? 0 : financingPeople.hashCode());
		result = prime * result + financingPv;
		result = prime * result + financingRank;
		result = prime * result + ((financingReleaseDate == null) ? 0 : financingReleaseDate.hashCode());
		result = prime * result + ((financingStart == null) ? 0 : financingStart.hashCode());
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
		FinancingapplyFinancingMemberEnterpriseInfo other = (FinancingapplyFinancingMemberEnterpriseInfo) obj;
		if (addressId != other.addressId)
			return false;
		if (applyDate == null) {
			if (other.applyDate != null)
				return false;
		} else if (!applyDate.equals(other.applyDate))
			return false;
		if (applyId != other.applyId)
			return false;
		if (applyStatus == null) {
			if (other.applyStatus != null)
				return false;
		} else if (!applyStatus.equals(other.applyStatus))
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
		if (financingCompleteStatus == null) {
			if (other.financingCompleteStatus != null)
				return false;
		} else if (!financingCompleteStatus.equals(other.financingCompleteStatus))
			return false;
		if (financingContent == null) {
			if (other.financingContent != null)
				return false;
		} else if (!financingContent.equals(other.financingContent))
			return false;
		if (financingEnd == null) {
			if (other.financingEnd != null)
				return false;
		} else if (!financingEnd.equals(other.financingEnd))
			return false;
		if (financingId != other.financingId)
			return false;
		if (financingImg == null) {
			if (other.financingImg != null)
				return false;
		} else if (!financingImg.equals(other.financingImg))
			return false;
		if (financingName == null) {
			if (other.financingName != null)
				return false;
		} else if (!financingName.equals(other.financingName))
			return false;
		if (financingPeople == null) {
			if (other.financingPeople != null)
				return false;
		} else if (!financingPeople.equals(other.financingPeople))
			return false;
		if (financingPv != other.financingPv)
			return false;
		if (financingRank != other.financingRank)
			return false;
		if (financingReleaseDate == null) {
			if (other.financingReleaseDate != null)
				return false;
		} else if (!financingReleaseDate.equals(other.financingReleaseDate))
			return false;
		if (financingStart == null) {
			if (other.financingStart != null)
				return false;
		} else if (!financingStart.equals(other.financingStart))
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
		return true;
	}
	@Override
	public String toString() {
		return "FinancingapplyFinancingMemberEnterpriseInfo [enterpriseId=" + enterpriseId + ", memberId=" + memberId
				+ ", enterpriseName=" + enterpriseName + ", enterpriseCardType=" + enterpriseCardType
				+ ", enterpriseCardId=" + enterpriseCardId + ", enterpriseTypeId=" + enterpriseTypeId
				+ ", enterpriseTradeId=" + enterpriseTradeId + ", enterpriseAreaId=" + enterpriseAreaId
				+ ", enterpriseAddressId=" + enterpriseAddressId + ", enterpriseTaxpayer=" + enterpriseTaxpayer
				+ ", enterpriseValidityDateStart=" + enterpriseValidityDateStart + ", enterpriseValidityDateEnd="
				+ enterpriseValidityDateEnd + ", enterpriseCertificationUnit=" + enterpriseCertificationUnit
				+ ", enterpriseRegAddress=" + enterpriseRegAddress + ", enterpriseStatusId=" + enterpriseStatusId
				+ ", enterpriseRegDate=" + enterpriseRegDate + ", enterpriseRegMoney=" + enterpriseRegMoney
				+ ", enterpriseLegalPersonName=" + enterpriseLegalPersonName + ", enterpriseLegalPersonCard="
				+ enterpriseLegalPersonCard + ", enterpriseAuditStatusId=" + enterpriseAuditStatusId + ", memberTel="
				+ memberTel + ", memberPwd=" + memberPwd + ", memberDate=" + memberDate + ", memberName=" + memberName
				+ ", memberCard=" + memberCard + ", memberIntegral=" + memberIntegral + ", memberRank=" + memberRank
				+ ", memberOnlineTimes=" + memberOnlineTimes + ", memberOnlineTime=" + memberOnlineTime
				+ ", financingId=" + financingId + ", financingName=" + financingName + ", financingPeople="
				+ financingPeople + ", financingContent=" + financingContent + ", financingImg=" + financingImg
				+ ", financingStart=" + financingStart + ", financingEnd=" + financingEnd + ", financingRank="
				+ financingRank + ", financingPv=" + financingPv + ", financingReleaseDate=" + financingReleaseDate
				+ ", addressId=" + addressId + ", applyId=" + applyId + ", applyDate=" + applyDate + ", applyStatus="
				+ applyStatus + ", financingCompleteStatus=" + financingCompleteStatus + "]";
	}
	
}
