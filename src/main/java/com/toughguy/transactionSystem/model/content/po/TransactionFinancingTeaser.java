package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

/**
 * 融资信息实体类
 * @author liDongSheng
 *
 */
public class TransactionFinancingTeaser {
	private int id;      				    //融资信息id
	private String firm_name;				//企业名称
	private String business_address;	    //经营地址
	private String principal_name;			//负责人名字	
	private String phoneNum;				//电话
	private String manage_yearTime;			//经营年限
	private String turnover_year;				//年营业额
	private String predict_turnover;			//预计申请额度
	private String deadline;					//期限
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirm_name() {
		return firm_name;
	}
	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}
	public String getBusiness_address() {
		return business_address;
	}
	public void setBusiness_address(String business_address) {
		this.business_address = business_address;
	}
	public String getPrincipal_name() {
		return principal_name;
	}
	public void setPrincipal_name(String principal_name) {
		this.principal_name = principal_name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getManage_yearTime() {
		return manage_yearTime;
	}
	public void setManage_yearTime(String manage_yearTime) {
		this.manage_yearTime = manage_yearTime;
	}
	public String getTurnover_year() {
		return turnover_year;
	}
	public void setTurnover_year(String turnover_year) {
		this.turnover_year = turnover_year;
	}
	public String getPredict_turnover() {
		return predict_turnover;
	}
	public void setPredict_turnover(String predict_turnover) {
		this.predict_turnover = predict_turnover;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "TransactionFinancingTeaser [id=" + id + ", firm_name=" + firm_name + ", business_address="
				+ business_address + ", principal_name=" + principal_name + ", phoneNum=" + phoneNum
				+ ", manage_yearTime=" + manage_yearTime + ", turnover_year=" + turnover_year + ", predict_turnover="
				+ predict_turnover + ", deadline=" + deadline + "]";
	}
	
	
	
	
}	
