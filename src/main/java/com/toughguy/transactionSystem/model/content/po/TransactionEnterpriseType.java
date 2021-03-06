package com.toughguy.transactionSystem.model.content.po;
/**
 * 企业类型表
 * @author 张泽
 *
 */
public class TransactionEnterpriseType {
	private int enterpriseTypeId;	// ID
	private String enterpriseType;  // 企业类型
	private boolean status;			// 状态
	
	public TransactionEnterpriseType(int enterpriseTypeId, String enterpriseType, boolean status) {
		super();
		this.enterpriseTypeId = enterpriseTypeId;
		this.enterpriseType = enterpriseType;
		this.status = status;
	}


	
	public TransactionEnterpriseType(int enterpriseTypeId, boolean status) {
		super();
		this.enterpriseTypeId = enterpriseTypeId;
		this.status = status;
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
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseType == null) ? 0 : enterpriseType.hashCode());
		result = prime * result + enterpriseTypeId;
		result = prime * result + (status ? 1231 : 1237);
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
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionEnterpriseType [enterpriseTypeId=" + enterpriseTypeId + ", enterpriseType=" + enterpriseType
				+ ", status=" + status + "]";
	}
	
	
}
