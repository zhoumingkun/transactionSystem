package com.toughguy.transactionSystem.model.content.po;
/**
 * 登记托管的服务类型实体类
 * @author liDongSheng
 *
 */
public class TransactionService {
	private int serviceId;				//服务类型的编号
	private String serviceType;			//服务类型
	public TransactionService(int serviceId, String serviceType) {
		super();
		this.serviceId = serviceId;
		this.serviceType = serviceType;
	}
	public TransactionService() {
		super();
	}
	public TransactionService(String serviceType) {
		super();
		this.serviceType = serviceType;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serviceId;
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
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
		TransactionService other = (TransactionService) obj;
		if (serviceId != other.serviceId)
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionService [serviceId=" + serviceId + ", serviceType=" + serviceType + "]";
	}
	
}
