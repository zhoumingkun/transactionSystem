package com.toughguy.transactionSystem.model.content.po;

/**
 * 企业地址
 * @author 张泽
 *
 */
public class TransactionEnterpriseAddress {
	private int addressId;			// id
	private String addressName;	// 地址名
	public TransactionEnterpriseAddress() {
		super();
	}
	public TransactionEnterpriseAddress(String addressName) {
		super();
		this.addressName = addressName;
	}
	public TransactionEnterpriseAddress(int addressId, String addressName) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
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
	
	
}
