package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

import com.toughguy.transactionSystem.model.AbstractModel;

/**
 * 融资信息实体类
 * @author ZMK
 *
 */
public class TransactionFinancingTeaser extends AbstractModel {
	private int id;      				    //融资信息id
	private String firmName;				//企业名称
	private String businessAddress;	    //经营地址
	private String principalName;			//负责人名字	
	private String phoneNum;				//电话
	private String manageYearTime;			//经营年限
	private String turnoverYear;				//年营业额
	private String predictTurnover;			//预计申请额度
	private String deadline;					//期限
	public TransactionFinancingTeaser() {
		super();
	}
	public TransactionFinancingTeaser(int id, String firmName, String businessAddress, String principalName,
			String phoneNum, String manageYearTime, String turnoverYear, String predictTurnover, String deadline) {
		super();
		this.id = id;
		this.firmName = firmName;
		this.businessAddress = businessAddress;
		this.principalName = principalName;
		this.phoneNum = phoneNum;
		this.manageYearTime = manageYearTime;
		this.turnoverYear = turnoverYear;
		this.predictTurnover = predictTurnover;
		this.deadline = deadline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getManageYearTime() {
		return manageYearTime;
	}
	public void setManageYearTime(String manageYearTime) {
		this.manageYearTime = manageYearTime;
	}
	public String getTurnoverYear() {
		return turnoverYear;
	}
	public void setTurnoverYear(String turnoverYear) {
		this.turnoverYear = turnoverYear;
	}
	public String getPredictTurnover() {
		return predictTurnover;
	}
	public void setPredictTurnover(String predictTurnover) {
		this.predictTurnover = predictTurnover;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "TransactionFinancingTeaser [id=" + id + ", firmName=" + firmName + ", businessAddress="
				+ businessAddress + ", principalName=" + principalName + ", phoneNum=" + phoneNum + ", manageYearTime="
				+ manageYearTime + ", turnoverYear=" + turnoverYear + ", predictTurnover=" + predictTurnover
				+ ", deadline=" + deadline + "]";
	}
	
}	
