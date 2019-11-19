package com.toughguy.transactionSystem.model.content.po;

public class transactionMemberCompany {
	private int companyId;
	private int memberId;
	private String companyName;
	private String companyCardType;
	private String companyCardId;
	public transactionMemberCompany(int companyId, int memberId, String companyName, String companyCardType,
			String companyCardId) {
		super();
		this.companyId = companyId;
		this.memberId = memberId;
		this.companyName = companyName;
		this.companyCardType = companyCardType;
		this.companyCardId = companyCardId;
	}
	public transactionMemberCompany(int memberId, String companyName, String companyCardType, String companyCardId) {
		super();
		this.memberId = memberId;
		this.companyName = companyName;
		this.companyCardType = companyCardType;
		this.companyCardId = companyCardId;
	}
	public transactionMemberCompany() {
		super();
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCardType() {
		return companyCardType;
	}
	public void setCompanyCardType(String companyCardType) {
		this.companyCardType = companyCardType;
	}
	public String getCompanyCardId() {
		return companyCardId;
	}
	public void setCompanyCardId(String companyCardId) {
		this.companyCardId = companyCardId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCardId == null) ? 0 : companyCardId.hashCode());
		result = prime * result + ((companyCardType == null) ? 0 : companyCardType.hashCode());
		result = prime * result + companyId;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + memberId;
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
		transactionMemberCompany other = (transactionMemberCompany) obj;
		if (companyCardId == null) {
			if (other.companyCardId != null)
				return false;
		} else if (!companyCardId.equals(other.companyCardId))
			return false;
		if (companyCardType == null) {
			if (other.companyCardType != null)
				return false;
		} else if (!companyCardType.equals(other.companyCardType))
			return false;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (memberId != other.memberId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "transactionMemberCompany [companyId=" + companyId + ", memberId=" + memberId + ", companyName="
				+ companyName + ", companyCardType=" + companyCardType + ", companyCardId=" + companyCardId + "]";
	}
	
	
	
}
