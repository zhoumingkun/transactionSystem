package com.toughguy.transactionSystem.model.content.po;

/**
 * 企业所在领域
 * @author 张泽
 *
 */
public class TransactionEnterpriseArea {
	private int enterpriseAreaId;	// ID
	private String enterpriseArea;	// 领域
	public TransactionEnterpriseArea(int enterpriseAreaId, String enterpriseArea) {
		super();
		this.enterpriseAreaId = enterpriseAreaId;
		this.enterpriseArea = enterpriseArea;
	}
	public TransactionEnterpriseArea(String enterpriseArea) {
		super();
		this.enterpriseArea = enterpriseArea;
	}
	public TransactionEnterpriseArea() {
		super();
	}
	public int getEnterpriseAreaId() {
		return enterpriseAreaId;
	}
	public void setEnterpriseAreaId(int enterpriseAreaId) {
		this.enterpriseAreaId = enterpriseAreaId;
	}
	public String getEnterpriseArea() {
		return enterpriseArea;
	}
	public void setEnterpriseArea(String enterpriseArea) {
		this.enterpriseArea = enterpriseArea;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseArea == null) ? 0 : enterpriseArea.hashCode());
		result = prime * result + enterpriseAreaId;
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
		TransactionEnterpriseArea other = (TransactionEnterpriseArea) obj;
		if (enterpriseArea == null) {
			if (other.enterpriseArea != null)
				return false;
		} else if (!enterpriseArea.equals(other.enterpriseArea))
			return false;
		if (enterpriseAreaId != other.enterpriseAreaId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionEnterpriseArea [enterpriseAreaId=" + enterpriseAreaId + ", enterpriseArea=" + enterpriseArea
				+ "]";
	}
	
	
	
}
