package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

/**
 * 融资申请实体类
 * @author liDongSheng
 *
 */
public class TransactionFinancingApply {
	private int applyId;							//申请id
	private int financingId;						//融资产品id
	private int memberId;						    //会员id
	private Date applyDate;							//申请时间
	private Boolean applyStatus;					//申请状态
	private Boolean financingCompleteStatus;		//融资完成状态
	/*
	private String applyEnterpriseName;				//企业名称
	private String enterpriseCode;				    //企业代码
	private double applyMoney;						//资金需求
	private Date listedTime;						//挂牌时间
	private String financingDo;						//融资用途
	private String whetherMortgage;					//是否有抵押
	private String complianceSituation;				//合规情况
	private Date enterpriseSetupTime;				//企业成立时间
	private String enterpriseRegProvince;			//企业注册省
	private String enterpriseRegCity;			    //企业注册市
	private String enterpriseRegCounties;			//企业注册区（省）
	private String applyPersonName ;			    //姓名
	private String applyPersonTel;			        //电话
	private String applyPersonPosition;			    //职务
	private String applyPersonEmail;			    //邮箱
	private double enterpriseRegMoney;				//注册资本
	private double lastYearIncome;				    //上一年收入
	private double lastYearSharp;				    //上一年营业利
	private double lastYearNetprofit;				//上一年净利润
	private double netassetSize;				    //净资产规模
	private double lastYearGrossProfit;				//上一年毛利润
	private double assetsDebtRatio;				    //资产负债率
	private double yearGrowthRate;				    //一年增长率
	private double halfYearSales;				    //半年销售
	private String competitiveAdvantageContent;        //竞争优势内容
	private String applyImg;						//图片
	*/
	public TransactionFinancingApply(int applyId, int financingId, int memberId, Date applyDate, Boolean applyStatus,
			Boolean financingCompleteStatus) {
		super();
		this.applyId = applyId;
		this.financingId = financingId;
		this.memberId = memberId;
		this.applyDate = applyDate;
		this.applyStatus = applyStatus;
		this.financingCompleteStatus = financingCompleteStatus;
	}
	public TransactionFinancingApply(int financingId, int memberId, Date applyDate, Boolean applyStatus,
			Boolean financingCompleteStatus) {
		super();
		this.financingId = financingId;
		this.memberId = memberId;
		this.applyDate = applyDate;
		this.applyStatus = applyStatus;
		this.financingCompleteStatus = financingCompleteStatus;
	}
	
	public TransactionFinancingApply() {
		super();
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public int getFinancingId() {
		return financingId;
	}
	public void setFinancingId(int financingId) {
		this.financingId = financingId;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + applyId;
		result = prime * result + ((applyStatus == null) ? 0 : applyStatus.hashCode());
		result = prime * result + ((financingCompleteStatus == null) ? 0 : financingCompleteStatus.hashCode());
		result = prime * result + financingId;
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
		TransactionFinancingApply other = (TransactionFinancingApply) obj;
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
		if (financingId != other.financingId)
			return false;
		if (memberId != other.memberId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionFinancingApply [applyId=" + applyId + ", financingId=" + financingId + ", memberId="
				+ memberId + ", applyDate=" + applyDate + ", applyStatus=" + applyStatus + ", financingCompleteStatus="
				+ financingCompleteStatus + "]";
	}
	
	
	
}
