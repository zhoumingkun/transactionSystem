package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 融资表和融资申请表和计划表的联系实体类
 * @author liDongSheng
 *
 */
public class TransactionFinancingApplyRepaymentplanInfo {
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
	private	int tradeId;						//企业类型
	private int applyId;							//申请id
	private int memberId;						    //会员id
	private Date applyDate;							//申请时间
	private Boolean applyStatus;					//申请状态
	private Boolean financingCompleteStatus;		//融资完成状态
	private int repaymentplanId;		//还款计划id
	private Date repaymentplanStart;    //还款开始时间
	private Date repaymentplanEnd;    //还款开始时间
	private double repaymentplanMoneyall;    //还款总额
	private int repaymentplanPeriod;    //还款周期
	private double repaymentplanPeriodMoney;    //还款周期金额
	private Date repaymentplanDay;			//还款日期
	private Date promptDay;					//还款的提示日期
	public TransactionFinancingApplyRepaymentplanInfo(int financingId, String financingName, String financingPeople,
			String financingContent, String financingImg, Date financingStart, Date financingEnd, int financingRank,
			int financingPv, Date financingReleaseDate, int addressId, int tradeId, int applyId, int memberId,
			Date applyDate, Boolean applyStatus, Boolean financingCompleteStatus, int repaymentplanId,
			Date repaymentplanStart, Date repaymentplanEnd, double repaymentplanMoneyall, int repaymentplanPeriod,
			double repaymentplanPeriodMoney, Date repaymentplanDay, Date promptDay) {
		super();
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
		this.tradeId = tradeId;
		this.applyId = applyId;
		this.memberId = memberId;
		this.applyDate = applyDate;
		this.applyStatus = applyStatus;
		this.financingCompleteStatus = financingCompleteStatus;
		this.repaymentplanId = repaymentplanId;
		this.repaymentplanStart = repaymentplanStart;
		this.repaymentplanEnd = repaymentplanEnd;
		this.repaymentplanMoneyall = repaymentplanMoneyall;
		this.repaymentplanPeriod = repaymentplanPeriod;
		this.repaymentplanPeriodMoney = repaymentplanPeriodMoney;
		this.repaymentplanDay = repaymentplanDay;
		this.promptDay = promptDay;
	}
	public TransactionFinancingApplyRepaymentplanInfo() {
		super();
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
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	public int getRepaymentplanId() {
		return repaymentplanId;
	}
	public void setRepaymentplanId(int repaymentplanId) {
		this.repaymentplanId = repaymentplanId;
	}
	public Date getRepaymentplanStart() {
		return repaymentplanStart;
	}
	public void setRepaymentplanStart(Date repaymentplanStart) {
		this.repaymentplanStart = repaymentplanStart;
	}
	public Date getRepaymentplanEnd() {
		return repaymentplanEnd;
	}
	public void setRepaymentplanEnd(Date repaymentplanEnd) {
		this.repaymentplanEnd = repaymentplanEnd;
	}
	public double getRepaymentplanMoneyall() {
		return repaymentplanMoneyall;
	}
	public void setRepaymentplanMoneyall(double repaymentplanMoneyall) {
		this.repaymentplanMoneyall = repaymentplanMoneyall;
	}
	public int getRepaymentplanPeriod() {
		return repaymentplanPeriod;
	}
	public void setRepaymentplanPeriod(int repaymentplanPeriod) {
		this.repaymentplanPeriod = repaymentplanPeriod;
	}
	public double getRepaymentplanPeriodMoney() {
		return repaymentplanPeriodMoney;
	}
	public void setRepaymentplanPeriodMoney(double repaymentplanPeriodMoney) {
		this.repaymentplanPeriodMoney = repaymentplanPeriodMoney;
	}
	public Date getRepaymentplanDay() {
		return repaymentplanDay;
	}
	public void setRepaymentplanDay(Date repaymentplanDay) {
		this.repaymentplanDay = repaymentplanDay;
	}
	public Date getPromptDay() {
		return promptDay;
	}
	public void setPromptDay(Date promptDay) {
		this.promptDay = promptDay;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + applyId;
		result = prime * result + ((applyStatus == null) ? 0 : applyStatus.hashCode());
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
		result = prime * result + memberId;
		result = prime * result + ((promptDay == null) ? 0 : promptDay.hashCode());
		result = prime * result + ((repaymentplanDay == null) ? 0 : repaymentplanDay.hashCode());
		result = prime * result + ((repaymentplanEnd == null) ? 0 : repaymentplanEnd.hashCode());
		result = prime * result + repaymentplanId;
		long temp;
		temp = Double.doubleToLongBits(repaymentplanMoneyall);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + repaymentplanPeriod;
		temp = Double.doubleToLongBits(repaymentplanPeriodMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((repaymentplanStart == null) ? 0 : repaymentplanStart.hashCode());
		result = prime * result + tradeId;
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
		TransactionFinancingApplyRepaymentplanInfo other = (TransactionFinancingApplyRepaymentplanInfo) obj;
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
		if (memberId != other.memberId)
			return false;
		if (promptDay == null) {
			if (other.promptDay != null)
				return false;
		} else if (!promptDay.equals(other.promptDay))
			return false;
		if (repaymentplanDay == null) {
			if (other.repaymentplanDay != null)
				return false;
		} else if (!repaymentplanDay.equals(other.repaymentplanDay))
			return false;
		if (repaymentplanEnd == null) {
			if (other.repaymentplanEnd != null)
				return false;
		} else if (!repaymentplanEnd.equals(other.repaymentplanEnd))
			return false;
		if (repaymentplanId != other.repaymentplanId)
			return false;
		if (Double.doubleToLongBits(repaymentplanMoneyall) != Double.doubleToLongBits(other.repaymentplanMoneyall))
			return false;
		if (repaymentplanPeriod != other.repaymentplanPeriod)
			return false;
		if (Double.doubleToLongBits(repaymentplanPeriodMoney) != Double
				.doubleToLongBits(other.repaymentplanPeriodMoney))
			return false;
		if (repaymentplanStart == null) {
			if (other.repaymentplanStart != null)
				return false;
		} else if (!repaymentplanStart.equals(other.repaymentplanStart))
			return false;
		if (tradeId != other.tradeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionFinancingApplyRepaymentplanInfo [financingId=" + financingId + ", financingName="
				+ financingName + ", financingPeople=" + financingPeople + ", financingContent=" + financingContent
				+ ", financingImg=" + financingImg + ", financingStart=" + financingStart + ", financingEnd="
				+ financingEnd + ", financingRank=" + financingRank + ", financingPv=" + financingPv
				+ ", financingReleaseDate=" + financingReleaseDate + ", addressId=" + addressId + ", tradeId=" + tradeId
				+ ", applyId=" + applyId + ", memberId=" + memberId + ", applyDate=" + applyDate + ", applyStatus="
				+ applyStatus + ", financingCompleteStatus=" + financingCompleteStatus + ", repaymentplanId="
				+ repaymentplanId + ", repaymentplanStart=" + repaymentplanStart + ", repaymentplanEnd="
				+ repaymentplanEnd + ", repaymentplanMoneyall=" + repaymentplanMoneyall + ", repaymentplanPeriod="
				+ repaymentplanPeriod + ", repaymentplanPeriodMoney=" + repaymentplanPeriodMoney + ", repaymentplanDay="
				+ repaymentplanDay + ", promptDay=" + promptDay + "]";
	}
}
