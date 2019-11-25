package com.toughguy.transactionSystem.model.content.po;
/**
 * 登记托管实体类
 * @author liDongSheng
 *
 */
public class TransactionReghost {
	private int reghostId;					//登记托管id
	private String reghostName;				//登记企业名称
	private String reghostPerson;			//联系人
	private String reghostTel;				//手机号
	private int serviceId;					//服务类型
	private String reghostServicePerson;	//服务人员
	private String reghostNeed;				//需求说明
	private int enterpriseTypeId;			//企业类型
	public TransactionReghost(int reghostId, String reghostName, String reghostPerson, String reghostTel, int serviceId,
			String reghostServicePerson, String reghostNeed, int enterpriseTypeId) {
		super();
		this.reghostId = reghostId;
		this.reghostName = reghostName;
		this.reghostPerson = reghostPerson;
		this.reghostTel = reghostTel;
		this.serviceId = serviceId;
		this.reghostServicePerson = reghostServicePerson;
		this.reghostNeed = reghostNeed;
		this.enterpriseTypeId = enterpriseTypeId;
	}
	public TransactionReghost(String reghostName, String reghostPerson, String reghostTel, int serviceId,
			String reghostServicePerson, String reghostNeed, int enterpriseTypeId) {
		super();
		this.reghostName = reghostName;
		this.reghostPerson = reghostPerson;
		this.reghostTel = reghostTel;
		this.serviceId = serviceId;
		this.reghostServicePerson = reghostServicePerson;
		this.reghostNeed = reghostNeed;
		this.enterpriseTypeId = enterpriseTypeId;
	}
	
	
	public TransactionReghost() {
		super();
	}
	public int getReghostId() {
		return reghostId;
	}
	public void setReghostId(int reghostId) {
		this.reghostId = reghostId;
	}
	public String getReghostName() {
		return reghostName;
	}
	public void setReghostName(String reghostName) {
		this.reghostName = reghostName;
	}
	public String getReghostPerson() {
		return reghostPerson;
	}
	public void setReghostPerson(String reghostPerson) {
		this.reghostPerson = reghostPerson;
	}
	public String getReghostTel() {
		return reghostTel;
	}
	public void setReghostTel(String reghostTel) {
		this.reghostTel = reghostTel;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getReghostServicePerson() {
		return reghostServicePerson;
	}
	public void setReghostServicePerson(String reghostServicePerson) {
		this.reghostServicePerson = reghostServicePerson;
	}
	public String getReghostNeed() {
		return reghostNeed;
	}
	public void setReghostNeed(String reghostNeed) {
		this.reghostNeed = reghostNeed;
	}
	public int getEnterpriseTypeId() {
		return enterpriseTypeId;
	}
	public void setEnterpriseTypeId(int enterpriseTypeId) {
		this.enterpriseTypeId = enterpriseTypeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enterpriseTypeId;
		result = prime * result + reghostId;
		result = prime * result + ((reghostName == null) ? 0 : reghostName.hashCode());
		result = prime * result + ((reghostNeed == null) ? 0 : reghostNeed.hashCode());
		result = prime * result + ((reghostPerson == null) ? 0 : reghostPerson.hashCode());
		result = prime * result + ((reghostServicePerson == null) ? 0 : reghostServicePerson.hashCode());
		result = prime * result + ((reghostTel == null) ? 0 : reghostTel.hashCode());
		result = prime * result + serviceId;
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
		TransactionReghost other = (TransactionReghost) obj;
		if (enterpriseTypeId != other.enterpriseTypeId)
			return false;
		if (reghostId != other.reghostId)
			return false;
		if (reghostName == null) {
			if (other.reghostName != null)
				return false;
		} else if (!reghostName.equals(other.reghostName))
			return false;
		if (reghostNeed == null) {
			if (other.reghostNeed != null)
				return false;
		} else if (!reghostNeed.equals(other.reghostNeed))
			return false;
		if (reghostPerson == null) {
			if (other.reghostPerson != null)
				return false;
		} else if (!reghostPerson.equals(other.reghostPerson))
			return false;
		if (reghostServicePerson == null) {
			if (other.reghostServicePerson != null)
				return false;
		} else if (!reghostServicePerson.equals(other.reghostServicePerson))
			return false;
		if (reghostTel == null) {
			if (other.reghostTel != null)
				return false;
		} else if (!reghostTel.equals(other.reghostTel))
			return false;
		if (serviceId != other.serviceId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionReghost [reghostId=" + reghostId + ", reghostName=" + reghostName + ", reghostPerson="
				+ reghostPerson + ", reghostTel=" + reghostTel + ", serviceId=" + serviceId + ", reghostServicePerson="
				+ reghostServicePerson + ", reghostNeed=" + reghostNeed + ", enterpriseTypeId=" + enterpriseTypeId
				+ "]";
	}
	
	
	
}
