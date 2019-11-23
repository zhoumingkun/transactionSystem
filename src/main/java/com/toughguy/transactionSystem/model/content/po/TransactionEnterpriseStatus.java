package com.toughguy.transactionSystem.model.content.po;

/**
 * 企业状态表
 * @author 张泽
 *
 */
public class TransactionEnterpriseStatus {
	private int enterpriseStatusId;	// ID
	private String enterpriseStatus;	// 企业状态
	public TransactionEnterpriseStatus(int enterpriseStatusId, String enterpriseStatus) {
		super();
		this.enterpriseStatusId = enterpriseStatusId;
		this.enterpriseStatus = enterpriseStatus;
	}
	public TransactionEnterpriseStatus(String enterpriseStatus) {
		super();
		this.enterpriseStatus = enterpriseStatus;
	}
	public TransactionEnterpriseStatus() {
		super();
	}
	public int getEnterpriseStatusId() {
		return enterpriseStatusId;
	}
	public void setEnterpriseStatusId(int enterpriseStatusId) {
		this.enterpriseStatusId = enterpriseStatusId;
	}
	public String getEnterpriseStatus() {
		return enterpriseStatus;
	}
	public void setEnterpriseStatus(String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseStatus == null) ? 0 : enterpriseStatus.hashCode());
		result = prime * result + enterpriseStatusId;
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
		TransactionEnterpriseStatus other = (TransactionEnterpriseStatus) obj;
		if (enterpriseStatus == null) {
			if (other.enterpriseStatus != null)
				return false;
		} else if (!enterpriseStatus.equals(other.enterpriseStatus))
			return false;
		if (enterpriseStatusId != other.enterpriseStatusId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionEnterpriseStatus [enterpriseStatusId=" + enterpriseStatusId + ", enterpriseStatus="
				+ enterpriseStatus + "]";
	}
	

}
