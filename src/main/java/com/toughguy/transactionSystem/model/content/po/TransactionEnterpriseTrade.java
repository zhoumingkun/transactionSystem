package com.toughguy.transactionSystem.model.content.po;

/**
 * 行业表
 * @author 张泽
 *
 */
public class TransactionEnterpriseTrade {
	private int tradeId;		//行业ID
	private String tradeType;	//行业类型
	private boolean status;			// 状态
	
	public TransactionEnterpriseTrade(int tradeId, String tradeType, boolean status) {
		super();
		this.tradeId = tradeId;
		this.tradeType = tradeType;
		this.status = status;
	}
	
	public TransactionEnterpriseTrade(int tradeId, boolean status) {
		super();
		this.tradeId = tradeId;
		this.status = status;
	}

	public TransactionEnterpriseTrade(String tradeType) {
		super();
		this.tradeType = tradeType;
	}
	public TransactionEnterpriseTrade() {
		super();
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransactionEnterpriseTrade [tradeId=" + tradeId + ", tradeType=" + tradeType + ", status=" + status
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + tradeId;
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
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
		TransactionEnterpriseTrade other = (TransactionEnterpriseTrade) obj;
		if (status != other.status)
			return false;
		if (tradeId != other.tradeId)
			return false;
		if (tradeType == null) {
			if (other.tradeType != null)
				return false;
		} else if (!tradeType.equals(other.tradeType))
			return false;
		return true;
	}
	
	
	
}
