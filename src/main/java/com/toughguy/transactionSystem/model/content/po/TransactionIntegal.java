package com.toughguy.transactionSystem.model.content.po;

/**
 * 		政策匹配对应积分实体类
 * @author Guozhenze
 *
 */
public class TransactionIntegal {
	private int id;								// -id
	private int enterpriseAddress;				// -所在区域 对应的匹配积分
	private int enterpriseType;					// -企业类型 对应的匹配积分
	private int enterpriseArea;					// -所属领域 对应的匹配积分
	private int enterpriseTrade;				// -所属行业 对应的匹配积分
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnterpriseAddress() {
		return enterpriseAddress;
	}
	public void setEnterpriseAddress(int enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}
	public int getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(int enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public int getEnterpriseArea() {
		return enterpriseArea;
	}
	public void setEnterpriseArea(int enterpriseArea) {
		this.enterpriseArea = enterpriseArea;
	}
	public int getEnterpriseTrade() {
		return enterpriseTrade;
	}
	public void setEnterpriseTrade(int enterpriseTrade) {
		this.enterpriseTrade = enterpriseTrade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enterpriseAddress;
		result = prime * result + enterpriseArea;
		result = prime * result + enterpriseTrade;
		result = prime * result + enterpriseType;
		result = prime * result + id;
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
		TransactionIntegal other = (TransactionIntegal) obj;
		if (enterpriseAddress != other.enterpriseAddress)
			return false;
		if (enterpriseArea != other.enterpriseArea)
			return false;
		if (enterpriseTrade != other.enterpriseTrade)
			return false;
		if (enterpriseType != other.enterpriseType)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionIntegal [id=" + id + ", enterpriseAddress=" + enterpriseAddress + ", enterpriseType="
				+ enterpriseType + ", enterpriseArea=" + enterpriseArea + ", enterpriseTrade=" + enterpriseTrade + "]";
	}
	public TransactionIntegal(int id, int enterpriseAddress, int enterpriseType, int enterpriseArea,
			int enterpriseTrade) {
		super();
		this.id = id;
		this.enterpriseAddress = enterpriseAddress;
		this.enterpriseType = enterpriseType;
		this.enterpriseArea = enterpriseArea;
		this.enterpriseTrade = enterpriseTrade;
	}
	public TransactionIntegal(int enterpriseAddress, int enterpriseType, int enterpriseArea, int enterpriseTrade) {
		super();
		this.enterpriseAddress = enterpriseAddress;
		this.enterpriseType = enterpriseType;
		this.enterpriseArea = enterpriseArea;
		this.enterpriseTrade = enterpriseTrade;
	}
	public TransactionIntegal() {
		super();
	}
	
	
}
