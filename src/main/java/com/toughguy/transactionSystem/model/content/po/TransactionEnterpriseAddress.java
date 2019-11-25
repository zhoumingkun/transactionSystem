package com.toughguy.transactionSystem.model.content.po;

/**
 * 企业地址
 * @author 张泽
 *
 */
public class TransactionEnterpriseAddress {
	private int addressId;			// id
	private String addressName;		// 地址名
	private boolean status;			// 状态
	public TransactionEnterpriseAddress() {
		super();
	}
	public TransactionEnterpriseAddress(String addressName) {
		super();
		this.addressName = addressName;
	}
	
	
	public TransactionEnterpriseAddress(int addressId, boolean status) {
		super();
		this.addressId = addressId;
		this.status = status;
	}
	public TransactionEnterpriseAddress(int addressId, String addressName, boolean status) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
		this.status = status;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransactionEnterpriseAddress [addressId=" + addressId + ", addressName=" + addressName + ", status="
				+ status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((addressName == null) ? 0 : addressName.hashCode());
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
		TransactionEnterpriseAddress other = (TransactionEnterpriseAddress) obj;
		if (addressId != other.addressId)
			return false;
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
}
