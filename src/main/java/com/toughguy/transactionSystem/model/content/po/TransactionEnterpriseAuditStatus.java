package com.toughguy.transactionSystem.model.content.po;

/**
 * 审批状态
 * @author 张泽
 */
public class TransactionEnterpriseAuditStatus {
	private int auditStatusId;			// 审批ID
	private String auditStatusType;		// 状态类型
	private boolean status;			// 状态
	
	
	public TransactionEnterpriseAuditStatus(int auditStatusId, boolean status) {
		super();
		this.auditStatusId = auditStatusId;
		this.status = status;
	}

	public TransactionEnterpriseAuditStatus(int auditStatusId, String auditStatusType, boolean status) {
		super();
		this.auditStatusId = auditStatusId;
		this.auditStatusType = auditStatusType;
		this.status = status;
	}

	public TransactionEnterpriseAuditStatus(String auditStatusType) {
		super();
		this.auditStatusType = auditStatusType;
	}

	public TransactionEnterpriseAuditStatus() {
		super();
	}

	public int getAuditStatusId() {
		return auditStatusId;
	}

	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}

	public String getAuditStatusType() {
		return auditStatusType;
	}

	public void setAuditStatusType(String auditStatusType) {
		this.auditStatusType = auditStatusType;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auditStatusId;
		result = prime * result + ((auditStatusType == null) ? 0 : auditStatusType.hashCode());
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
		TransactionEnterpriseAuditStatus other = (TransactionEnterpriseAuditStatus) obj;
		if (auditStatusId != other.auditStatusId)
			return false;
		if (auditStatusType == null) {
			if (other.auditStatusType != null)
				return false;
		} else if (!auditStatusType.equals(other.auditStatusType))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionEnterpriseAuditStatus [auditStatusId=" + auditStatusId + ", auditStatusType="
				+ auditStatusType + ", status=" + status + "]";
	}
	
	
}
