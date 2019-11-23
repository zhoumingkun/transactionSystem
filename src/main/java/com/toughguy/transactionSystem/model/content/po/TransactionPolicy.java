package com.toughguy.transactionSystem.model.content.po;

public class TransactionPolicy {
	private int policyId;				// -id
	private int enterpriseAreaId;		// -所属领域
	private int enterpriseTradeId;		// -所属行业
	private String policyName;			// -政策名称
	private String policyUnit;			// -发布单位
	private String policyContent;		// -政策内容
	private String policyTime;			// -发布时间
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getEnterpriseAreaId() {
		return enterpriseAreaId;
	}
	public void setEnterpriseAreaId(int enterpriseAreaId) {
		this.enterpriseAreaId = enterpriseAreaId;
	}
	public int getEnterpriseTradeId() {
		return enterpriseTradeId;
	}
	public void setEnterpriseTradeId(int enterpriseTradeId) {
		this.enterpriseTradeId = enterpriseTradeId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyUnit() {
		return policyUnit;
	}
	public void setPolicyUnit(String policyUnit) {
		this.policyUnit = policyUnit;
	}
	public String getPolicyContent() {
		return policyContent;
	}
	public void setPolicyContent(String policyContent) {
		this.policyContent = policyContent;
	}
	public String getPolicyTime() {
		return policyTime;
	}
	public void setPolicyTime(String policyTime) {
		this.policyTime = policyTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enterpriseAreaId;
		result = prime * result + enterpriseTradeId;
		result = prime * result + ((policyContent == null) ? 0 : policyContent.hashCode());
		result = prime * result + policyId;
		result = prime * result + ((policyName == null) ? 0 : policyName.hashCode());
		result = prime * result + ((policyTime == null) ? 0 : policyTime.hashCode());
		result = prime * result + ((policyUnit == null) ? 0 : policyUnit.hashCode());
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
		TransactionPolicy other = (TransactionPolicy) obj;
		if (enterpriseAreaId != other.enterpriseAreaId)
			return false;
		if (enterpriseTradeId != other.enterpriseTradeId)
			return false;
		if (policyContent == null) {
			if (other.policyContent != null)
				return false;
		} else if (!policyContent.equals(other.policyContent))
			return false;
		if (policyId != other.policyId)
			return false;
		if (policyName == null) {
			if (other.policyName != null)
				return false;
		} else if (!policyName.equals(other.policyName))
			return false;
		if (policyTime == null) {
			if (other.policyTime != null)
				return false;
		} else if (!policyTime.equals(other.policyTime))
			return false;
		if (policyUnit == null) {
			if (other.policyUnit != null)
				return false;
		} else if (!policyUnit.equals(other.policyUnit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionPolicy [policyId=" + policyId + ", enterpriseAreaId=" + enterpriseAreaId
				+ ", enterpriseTradeId=" + enterpriseTradeId + ", policyName=" + policyName + ", policyUnit="
				+ policyUnit + ", policyContent=" + policyContent + ", policyTime=" + policyTime + "]";
	}
	public TransactionPolicy(int policyId, int enterpriseAreaId, int enterpriseTradeId, String policyName,
			String policyUnit, String policyContent, String policyTime) {
		super();
		this.policyId = policyId;
		this.enterpriseAreaId = enterpriseAreaId;
		this.enterpriseTradeId = enterpriseTradeId;
		this.policyName = policyName;
		this.policyUnit = policyUnit;
		this.policyContent = policyContent;
		this.policyTime = policyTime;
	}
	
	public TransactionPolicy(int enterpriseAreaId, int enterpriseTradeId, String policyName, String policyUnit,
			String policyContent, String policyTime) {
		super();
		this.enterpriseAreaId = enterpriseAreaId;
		this.enterpriseTradeId = enterpriseTradeId;
		this.policyName = policyName;
		this.policyUnit = policyUnit;
		this.policyContent = policyContent;
		this.policyTime = policyTime;
	}
	public TransactionPolicy() {
		super();
	}
	
	
}
