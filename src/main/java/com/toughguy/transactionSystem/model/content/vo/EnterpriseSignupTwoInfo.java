package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;
/**
 * 企业表和报名表联系的实体类
 * @author liDongSheng
 *
 */
public class EnterpriseSignupTwoInfo {
	private String enterpriseName;				// 企业名称
	private Date signupDate;			//报名时间
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public Date getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
	public EnterpriseSignupTwoInfo(String enterpriseName, Date signupDate) {
		super();
		this.enterpriseName = enterpriseName;
		this.signupDate = signupDate;
	}
	public EnterpriseSignupTwoInfo() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enterpriseName == null) ? 0 : enterpriseName.hashCode());
		result = prime * result + ((signupDate == null) ? 0 : signupDate.hashCode());
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
		EnterpriseSignupTwoInfo other = (EnterpriseSignupTwoInfo) obj;
		if (enterpriseName == null) {
			if (other.enterpriseName != null)
				return false;
		} else if (!enterpriseName.equals(other.enterpriseName))
			return false;
		if (signupDate == null) {
			if (other.signupDate != null)
				return false;
		} else if (!signupDate.equals(other.signupDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EnterpriseSignupTwoInfo [enterpriseName=" + enterpriseName + ", signupDate=" + signupDate + "]";
	}
	
	
	
}
