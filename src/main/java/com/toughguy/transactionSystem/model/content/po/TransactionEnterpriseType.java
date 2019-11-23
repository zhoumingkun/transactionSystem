package com.toughguy.transactionSystem.model.content.po;
/**
 * 企业类型表
 * @author 张泽
 *
 */
public class TransactionEnterpriseType {
	private int enterpriseTypeId;	// ID
	private String enterpriseType;  // 企业类型
	
	public TransactionEnterpriseType(int enterpriseTypeId, String enterpriseType) {
		super();
		this.enterpriseTypeId = enterpriseTypeId;
		this.enterpriseType = enterpriseType;
	}
	
	public TransactionEnterpriseType(String enterpriseType) {
		super();
		this.enterpriseType = enterpriseType;
	}
	
	public TransactionEnterpriseType() {
		super();
	}
	public int getEnterpriseTypeId() {
		return enterpriseTypeId;
	}
	
	public void setEnterpriseTypeId(int enterpriseTypeId) {
		this.enterpriseTypeId = enterpriseTypeId;
	}
	
	public String getEnterpriseType() {
		return enterpriseType;
	}
	
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseType == null) ? 0 : enterpriseType.hashCode());
		result = prime * result + enterpriseTypeId;
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
		TransactionEnterpriseType other = (TransactionEnterpriseType) obj;
		if (enterpriseType == null) {
			if (other.enterpriseType != null)
				return false;
		} else if (!enterpriseType.equals(other.enterpriseType))
			return false;
		if (enterpriseTypeId != other.enterpriseTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionEnterpriseType [enterpriseTypeId=" + enterpriseTypeId + ", enterpriseType=" + enterpriseType
				+ "]";
	}
	
	
}
