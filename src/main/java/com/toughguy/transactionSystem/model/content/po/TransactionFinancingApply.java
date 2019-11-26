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
	private Date applyDate;							//申请时间
	public TransactionFinancingApply(int applyId, int financingId, int memberId, String applyEnterpriseName,
			String enterpriseCode, double applyMoney, Date listedTime, String financingDo, String whetherMortgage,
			String complianceSituation, Date enterpriseSetupTime, String enterpriseRegProvince,
			String enterpriseRegCity, String enterpriseRegCounties, String applyPersonName, String applyPersonTel,
			String applyPersonPosition, String applyPersonEmail, double enterpriseRegMoney, double lastYearIncome,
			double lastYearSharp, double lastYearNetprofit, double netassetSize, double lastYearGrossProfit,
			double assetsDebtRatio, double yearGrowthRate, double halfYearSales, String competitiveAdvantageContent,
			String applyImg, Date applyDate) {
		super();
		this.applyId = applyId;
		this.financingId = financingId;
		this.memberId = memberId;
		this.applyEnterpriseName = applyEnterpriseName;
		this.enterpriseCode = enterpriseCode;
		this.applyMoney = applyMoney;
		this.listedTime = listedTime;
		this.financingDo = financingDo;
		this.whetherMortgage = whetherMortgage;
		this.complianceSituation = complianceSituation;
		this.enterpriseSetupTime = enterpriseSetupTime;
		this.enterpriseRegProvince = enterpriseRegProvince;
		this.enterpriseRegCity = enterpriseRegCity;
		this.enterpriseRegCounties = enterpriseRegCounties;
		this.applyPersonName = applyPersonName;
		this.applyPersonTel = applyPersonTel;
		this.applyPersonPosition = applyPersonPosition;
		this.applyPersonEmail = applyPersonEmail;
		this.enterpriseRegMoney = enterpriseRegMoney;
		this.lastYearIncome = lastYearIncome;
		this.lastYearSharp = lastYearSharp;
		this.lastYearNetprofit = lastYearNetprofit;
		this.netassetSize = netassetSize;
		this.lastYearGrossProfit = lastYearGrossProfit;
		this.assetsDebtRatio = assetsDebtRatio;
		this.yearGrowthRate = yearGrowthRate;
		this.halfYearSales = halfYearSales;
		this.competitiveAdvantageContent = competitiveAdvantageContent;
		this.applyImg = applyImg;
		this.applyDate = applyDate;
	}
	public TransactionFinancingApply(int financingId, int memberId, String applyEnterpriseName, String enterpriseCode,
			double applyMoney, Date listedTime, String financingDo, String whetherMortgage, String complianceSituation,
			Date enterpriseSetupTime, String enterpriseRegProvince, String enterpriseRegCity,
			String enterpriseRegCounties, String applyPersonName, String applyPersonTel, String applyPersonPosition,
			String applyPersonEmail, double enterpriseRegMoney, double lastYearIncome, double lastYearSharp,
			double lastYearNetprofit, double netassetSize, double lastYearGrossProfit, double assetsDebtRatio,
			double yearGrowthRate, double halfYearSales, String competitiveAdvantageContent, String applyImg,
			Date applyDate) {
		super();
		this.financingId = financingId;
		this.memberId = memberId;
		this.applyEnterpriseName = applyEnterpriseName;
		this.enterpriseCode = enterpriseCode;
		this.applyMoney = applyMoney;
		this.listedTime = listedTime;
		this.financingDo = financingDo;
		this.whetherMortgage = whetherMortgage;
		this.complianceSituation = complianceSituation;
		this.enterpriseSetupTime = enterpriseSetupTime;
		this.enterpriseRegProvince = enterpriseRegProvince;
		this.enterpriseRegCity = enterpriseRegCity;
		this.enterpriseRegCounties = enterpriseRegCounties;
		this.applyPersonName = applyPersonName;
		this.applyPersonTel = applyPersonTel;
		this.applyPersonPosition = applyPersonPosition;
		this.applyPersonEmail = applyPersonEmail;
		this.enterpriseRegMoney = enterpriseRegMoney;
		this.lastYearIncome = lastYearIncome;
		this.lastYearSharp = lastYearSharp;
		this.lastYearNetprofit = lastYearNetprofit;
		this.netassetSize = netassetSize;
		this.lastYearGrossProfit = lastYearGrossProfit;
		this.assetsDebtRatio = assetsDebtRatio;
		this.yearGrowthRate = yearGrowthRate;
		this.halfYearSales = halfYearSales;
		this.competitiveAdvantageContent = competitiveAdvantageContent;
		this.applyImg = applyImg;
		this.applyDate = applyDate;
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
	public String getApplyEnterpriseName() {
		return applyEnterpriseName;
	}
	public void setApplyEnterpriseName(String applyEnterpriseName) {
		this.applyEnterpriseName = applyEnterpriseName;
	}
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	public double getApplyMoney() {
		return applyMoney;
	}
	public void setApplyMoney(double applyMoney) {
		this.applyMoney = applyMoney;
	}
	public Date getListedTime() {
		return listedTime;
	}
	public void setListedTime(Date listedTime) {
		this.listedTime = listedTime;
	}
	public String getFinancingDo() {
		return financingDo;
	}
	public void setFinancingDo(String financingDo) {
		this.financingDo = financingDo;
	}
	public String getWhetherMortgage() {
		return whetherMortgage;
	}
	public void setWhetherMortgage(String whetherMortgage) {
		this.whetherMortgage = whetherMortgage;
	}
	public String getComplianceSituation() {
		return complianceSituation;
	}
	public void setComplianceSituation(String complianceSituation) {
		this.complianceSituation = complianceSituation;
	}
	public Date getEnterpriseSetupTime() {
		return enterpriseSetupTime;
	}
	public void setEnterpriseSetupTime(Date enterpriseSetupTime) {
		this.enterpriseSetupTime = enterpriseSetupTime;
	}
	public String getEnterpriseRegProvince() {
		return enterpriseRegProvince;
	}
	public void setEnterpriseRegProvince(String enterpriseRegProvince) {
		this.enterpriseRegProvince = enterpriseRegProvince;
	}
	public String getEnterpriseRegCity() {
		return enterpriseRegCity;
	}
	public void setEnterpriseRegCity(String enterpriseRegCity) {
		this.enterpriseRegCity = enterpriseRegCity;
	}
	public String getEnterpriseRegCounties() {
		return enterpriseRegCounties;
	}
	public void setEnterpriseRegCounties(String enterpriseRegCounties) {
		this.enterpriseRegCounties = enterpriseRegCounties;
	}
	public String getApplyPersonName() {
		return applyPersonName;
	}
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	public String getApplyPersonTel() {
		return applyPersonTel;
	}
	public void setApplyPersonTel(String applyPersonTel) {
		this.applyPersonTel = applyPersonTel;
	}
	public String getApplyPersonPosition() {
		return applyPersonPosition;
	}
	public void setApplyPersonPosition(String applyPersonPosition) {
		this.applyPersonPosition = applyPersonPosition;
	}
	public String getApplyPersonEmail() {
		return applyPersonEmail;
	}
	public void setApplyPersonEmail(String applyPersonEmail) {
		this.applyPersonEmail = applyPersonEmail;
	}
	public double getEnterpriseRegMoney() {
		return enterpriseRegMoney;
	}
	public void setEnterpriseRegMoney(double enterpriseRegMoney) {
		this.enterpriseRegMoney = enterpriseRegMoney;
	}
	public double getLastYearIncome() {
		return lastYearIncome;
	}
	public void setLastYearIncome(double lastYearIncome) {
		this.lastYearIncome = lastYearIncome;
	}
	public double getLastYearSharp() {
		return lastYearSharp;
	}
	public void setLastYearSharp(double lastYearSharp) {
		this.lastYearSharp = lastYearSharp;
	}
	public double getLastYearNetprofit() {
		return lastYearNetprofit;
	}
	public void setLastYearNetprofit(double lastYearNetprofit) {
		this.lastYearNetprofit = lastYearNetprofit;
	}
	public double getNetassetSize() {
		return netassetSize;
	}
	public void setNetassetSize(double netassetSize) {
		this.netassetSize = netassetSize;
	}
	public double getLastYearGrossProfit() {
		return lastYearGrossProfit;
	}
	public void setLastYearGrossProfit(double lastYearGrossProfit) {
		this.lastYearGrossProfit = lastYearGrossProfit;
	}
	public double getAssetsDebtRatio() {
		return assetsDebtRatio;
	}
	public void setAssetsDebtRatio(double assetsDebtRatio) {
		this.assetsDebtRatio = assetsDebtRatio;
	}
	public double getYearGrowthRate() {
		return yearGrowthRate;
	}
	public void setYearGrowthRate(double yearGrowthRate) {
		this.yearGrowthRate = yearGrowthRate;
	}
	public double getHalfYearSales() {
		return halfYearSales;
	}
	public void setHalfYearSales(double halfYearSales) {
		this.halfYearSales = halfYearSales;
	}
	public String getCompetitiveAdvantageContent() {
		return competitiveAdvantageContent;
	}
	public void setCompetitiveAdvantageContent(String competitiveAdvantageContent) {
		this.competitiveAdvantageContent = competitiveAdvantageContent;
	}
	public String getApplyImg() {
		return applyImg;
	}
	public void setApplyImg(String applyImg) {
		this.applyImg = applyImg;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + ((applyEnterpriseName == null) ? 0 : applyEnterpriseName.hashCode());
		result = prime * result + applyId;
		result = prime * result + ((applyImg == null) ? 0 : applyImg.hashCode());
		long temp;
		temp = Double.doubleToLongBits(applyMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((applyPersonEmail == null) ? 0 : applyPersonEmail.hashCode());
		result = prime * result + ((applyPersonName == null) ? 0 : applyPersonName.hashCode());
		result = prime * result + ((applyPersonPosition == null) ? 0 : applyPersonPosition.hashCode());
		result = prime * result + ((applyPersonTel == null) ? 0 : applyPersonTel.hashCode());
		temp = Double.doubleToLongBits(assetsDebtRatio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((competitiveAdvantageContent == null) ? 0 : competitiveAdvantageContent.hashCode());
		result = prime * result + ((complianceSituation == null) ? 0 : complianceSituation.hashCode());
		result = prime * result + ((enterpriseCode == null) ? 0 : enterpriseCode.hashCode());
		result = prime * result + ((enterpriseRegCity == null) ? 0 : enterpriseRegCity.hashCode());
		result = prime * result + ((enterpriseRegCounties == null) ? 0 : enterpriseRegCounties.hashCode());
		temp = Double.doubleToLongBits(enterpriseRegMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((enterpriseRegProvince == null) ? 0 : enterpriseRegProvince.hashCode());
		result = prime * result + ((enterpriseSetupTime == null) ? 0 : enterpriseSetupTime.hashCode());
		result = prime * result + ((financingDo == null) ? 0 : financingDo.hashCode());
		result = prime * result + financingId;
		temp = Double.doubleToLongBits(halfYearSales);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lastYearGrossProfit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lastYearIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lastYearNetprofit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lastYearSharp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((listedTime == null) ? 0 : listedTime.hashCode());
		result = prime * result + memberId;
		temp = Double.doubleToLongBits(netassetSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((whetherMortgage == null) ? 0 : whetherMortgage.hashCode());
		temp = Double.doubleToLongBits(yearGrowthRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (applyEnterpriseName == null) {
			if (other.applyEnterpriseName != null)
				return false;
		} else if (!applyEnterpriseName.equals(other.applyEnterpriseName))
			return false;
		if (applyId != other.applyId)
			return false;
		if (applyImg == null) {
			if (other.applyImg != null)
				return false;
		} else if (!applyImg.equals(other.applyImg))
			return false;
		if (Double.doubleToLongBits(applyMoney) != Double.doubleToLongBits(other.applyMoney))
			return false;
		if (applyPersonEmail == null) {
			if (other.applyPersonEmail != null)
				return false;
		} else if (!applyPersonEmail.equals(other.applyPersonEmail))
			return false;
		if (applyPersonName == null) {
			if (other.applyPersonName != null)
				return false;
		} else if (!applyPersonName.equals(other.applyPersonName))
			return false;
		if (applyPersonPosition == null) {
			if (other.applyPersonPosition != null)
				return false;
		} else if (!applyPersonPosition.equals(other.applyPersonPosition))
			return false;
		if (applyPersonTel == null) {
			if (other.applyPersonTel != null)
				return false;
		} else if (!applyPersonTel.equals(other.applyPersonTel))
			return false;
		if (Double.doubleToLongBits(assetsDebtRatio) != Double.doubleToLongBits(other.assetsDebtRatio))
			return false;
		if (competitiveAdvantageContent == null) {
			if (other.competitiveAdvantageContent != null)
				return false;
		} else if (!competitiveAdvantageContent.equals(other.competitiveAdvantageContent))
			return false;
		if (complianceSituation == null) {
			if (other.complianceSituation != null)
				return false;
		} else if (!complianceSituation.equals(other.complianceSituation))
			return false;
		if (enterpriseCode == null) {
			if (other.enterpriseCode != null)
				return false;
		} else if (!enterpriseCode.equals(other.enterpriseCode))
			return false;
		if (enterpriseRegCity == null) {
			if (other.enterpriseRegCity != null)
				return false;
		} else if (!enterpriseRegCity.equals(other.enterpriseRegCity))
			return false;
		if (enterpriseRegCounties == null) {
			if (other.enterpriseRegCounties != null)
				return false;
		} else if (!enterpriseRegCounties.equals(other.enterpriseRegCounties))
			return false;
		if (Double.doubleToLongBits(enterpriseRegMoney) != Double.doubleToLongBits(other.enterpriseRegMoney))
			return false;
		if (enterpriseRegProvince == null) {
			if (other.enterpriseRegProvince != null)
				return false;
		} else if (!enterpriseRegProvince.equals(other.enterpriseRegProvince))
			return false;
		if (enterpriseSetupTime == null) {
			if (other.enterpriseSetupTime != null)
				return false;
		} else if (!enterpriseSetupTime.equals(other.enterpriseSetupTime))
			return false;
		if (financingDo == null) {
			if (other.financingDo != null)
				return false;
		} else if (!financingDo.equals(other.financingDo))
			return false;
		if (financingId != other.financingId)
			return false;
		if (Double.doubleToLongBits(halfYearSales) != Double.doubleToLongBits(other.halfYearSales))
			return false;
		if (Double.doubleToLongBits(lastYearGrossProfit) != Double.doubleToLongBits(other.lastYearGrossProfit))
			return false;
		if (Double.doubleToLongBits(lastYearIncome) != Double.doubleToLongBits(other.lastYearIncome))
			return false;
		if (Double.doubleToLongBits(lastYearNetprofit) != Double.doubleToLongBits(other.lastYearNetprofit))
			return false;
		if (Double.doubleToLongBits(lastYearSharp) != Double.doubleToLongBits(other.lastYearSharp))
			return false;
		if (listedTime == null) {
			if (other.listedTime != null)
				return false;
		} else if (!listedTime.equals(other.listedTime))
			return false;
		if (memberId != other.memberId)
			return false;
		if (Double.doubleToLongBits(netassetSize) != Double.doubleToLongBits(other.netassetSize))
			return false;
		if (whetherMortgage == null) {
			if (other.whetherMortgage != null)
				return false;
		} else if (!whetherMortgage.equals(other.whetherMortgage))
			return false;
		if (Double.doubleToLongBits(yearGrowthRate) != Double.doubleToLongBits(other.yearGrowthRate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionFinancingApply [applyId=" + applyId + ", financingId=" + financingId + ", memberId="
				+ memberId + ", applyEnterpriseName=" + applyEnterpriseName + ", enterpriseCode=" + enterpriseCode
				+ ", applyMoney=" + applyMoney + ", listedTime=" + listedTime + ", financingDo=" + financingDo
				+ ", whetherMortgage=" + whetherMortgage + ", complianceSituation=" + complianceSituation
				+ ", enterpriseSetupTime=" + enterpriseSetupTime + ", enterpriseRegProvince=" + enterpriseRegProvince
				+ ", enterpriseRegCity=" + enterpriseRegCity + ", enterpriseRegCounties=" + enterpriseRegCounties
				+ ", applyPersonName=" + applyPersonName + ", applyPersonTel=" + applyPersonTel
				+ ", applyPersonPosition=" + applyPersonPosition + ", applyPersonEmail=" + applyPersonEmail
				+ ", enterpriseRegMoney=" + enterpriseRegMoney + ", lastYearIncome=" + lastYearIncome
				+ ", lastYearSharp=" + lastYearSharp + ", lastYearNetprofit=" + lastYearNetprofit + ", netassetSize="
				+ netassetSize + ", lastYearGrossProfit=" + lastYearGrossProfit + ", assetsDebtRatio=" + assetsDebtRatio
				+ ", yearGrowthRate=" + yearGrowthRate + ", halfYearSales=" + halfYearSales
				+ ", competitiveAdvantageContent=" + competitiveAdvantageContent + ", applyImg=" + applyImg
				+ ", applyDate=" + applyDate + "]";
	}
	
}
