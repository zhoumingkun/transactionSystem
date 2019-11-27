package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

/**
 * 登记托管实体类
 * 
 * @author liDongSheng
 *
 */
public class TransactionReghost {
	private int reghostId; // 登记托管id
	private int memberId; // 会员id
	private int serviceId; // 服务类型
	private Date reghostDate;//登记托管的时间
	/*
	 * private String reghostPerson; //联系人 private String reghostName; //登记企业名称
	 * private String reghostTel; //手机号 private String reghostServicePerson; //服务人员
	 * private String reghostNeed; //需求说明 private int enterpriseTypeId; //企业类型
	 */
	public TransactionReghost(int reghostId, int memberId, int serviceId, Date reghostDate) {
		super();
		this.reghostId = reghostId;
		this.memberId = memberId;
		this.serviceId = serviceId;
		this.reghostDate = reghostDate;
	}
	public TransactionReghost(int memberId, int serviceId, Date reghostDate) {
		super();
		this.memberId = memberId;
		this.serviceId = serviceId;
		this.reghostDate = reghostDate;
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
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public Date getReghostDate() {
		return reghostDate;
	}
	public void setReghostDate(Date reghostDate) {
		this.reghostDate = reghostDate;
	}
	@Override
	public String toString() {
		return "TransactionReghost [reghostId=" + reghostId + ", memberId=" + memberId + ", serviceId=" + serviceId
				+ ", reghostDate=" + reghostDate + "]";
	}
	

}
