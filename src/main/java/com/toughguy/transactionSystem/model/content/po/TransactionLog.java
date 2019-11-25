package com.toughguy.transactionSystem.model.content.po;
/**
 * 
 * 	日志表实体类
 * @author Guozhenze
 *
 */

import java.util.Date;

public class TransactionLog {
	private int logId;				// -日志Id
	private String logContent;		// -日志内容
	private Date logTime;			// -日志发表时间
	private int rootId;		// -发表人
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logContent == null) ? 0 : logContent.hashCode());
		result = prime * result + logId;
		result = prime * result + ((logTime == null) ? 0 : logTime.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionLog other = (TransactionLog) obj;
		if (logContent == null) {
			if (other.logContent != null)
				return false;
		} else if (!logContent.equals(other.logContent))
			return false;
		if (logId != other.logId)
			return false;
		if (logTime == null) {
			if (other.logTime != null)
				return false;
		} else if (!logTime.equals(other.logTime))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "TransactionLog [logId=" + logId + ", logContent=" + logContent + ", logTime=" + logTime + ", rootId="
				+ rootId + "]";
	}
	public TransactionLog(int logId, String logContent, Date logTime, int rootId) {
		super();
		this.logId = logId;
		this.logContent = logContent;
		this.logTime = logTime;
		this.rootId = rootId;
	}
	
	public TransactionLog(String logContent, Date logTime, int rootId) {
		super();
		this.logContent = logContent;
		this.logTime = logTime;
		this.rootId = rootId;
	}
	public TransactionLog() {
		super();
	}
	
	
}
