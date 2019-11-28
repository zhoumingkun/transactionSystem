package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

/**
 * 还款计划表
 * @author liDongSheng
 *
 */
public class TransactionRepaymentplan {
	private int repaymentplanId;		//还款计划id
	private int applyId;				//申请id
	private Date repaymentplanStart;    //还款开始时间
	private Date repaymentplanEnd;    //还款开始时间
	private double repaymentplanMoneyall;    //还款总额
	private int repaymentplanPeriod;    //还款周期
	private double repaymentplanPeriodMoney;    //还款周期金额
	public TransactionRepaymentplan(int repaymentplanId, int applyId, Date repaymentplanStart, Date repaymentplanEnd,
			double repaymentplanMoneyall, int repaymentplanPeriod, double repaymentplanPeriodMoney) {
		super();
		this.repaymentplanId = repaymentplanId;
		this.applyId = applyId;
		this.repaymentplanStart = repaymentplanStart;
		this.repaymentplanEnd = repaymentplanEnd;
		this.repaymentplanMoneyall = repaymentplanMoneyall;
		this.repaymentplanPeriod = repaymentplanPeriod;
		this.repaymentplanPeriodMoney = repaymentplanPeriodMoney;
	}
	public TransactionRepaymentplan(int applyId, Date repaymentplanStart, Date repaymentplanEnd,
			double repaymentplanMoneyall, int repaymentplanPeriod, double repaymentplanPeriodMoney) {
		super();
		this.applyId = applyId;
		this.repaymentplanStart = repaymentplanStart;
		this.repaymentplanEnd = repaymentplanEnd;
		this.repaymentplanMoneyall = repaymentplanMoneyall;
		this.repaymentplanPeriod = repaymentplanPeriod;
		this.repaymentplanPeriodMoney = repaymentplanPeriodMoney;
	}
	public TransactionRepaymentplan() {
		super();
	}
	public int getRepaymentplanId() {
		return repaymentplanId;
	}
	public void setRepaymentplanId(int repaymentplanId) {
		this.repaymentplanId = repaymentplanId;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public Date getRepaymentplanStart() {
		return repaymentplanStart;
	}
	public void setRepaymentplanStart(Date repaymentplanStart) {
		this.repaymentplanStart = repaymentplanStart;
	}
	public Date getRepaymentplanEnd() {
		return repaymentplanEnd;
	}
	public void setRepaymentplanEnd(Date repaymentplanEnd) {
		this.repaymentplanEnd = repaymentplanEnd;
	}
	public double getRepaymentplanMoneyall() {
		return repaymentplanMoneyall;
	}
	public void setRepaymentplanMoneyall(double repaymentplanMoneyall) {
		this.repaymentplanMoneyall = repaymentplanMoneyall;
	}
	public int getRepaymentplanPeriod() {
		return repaymentplanPeriod;
	}
	public void setRepaymentplanPeriod(int repaymentplanPeriod) {
		this.repaymentplanPeriod = repaymentplanPeriod;
	}
	public double getRepaymentplanPeriodMoney() {
		return repaymentplanPeriodMoney;
	}
	public void setRepaymentplanPeriodMoney(double repaymentplanPeriodMoney) {
		this.repaymentplanPeriodMoney = repaymentplanPeriodMoney;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + applyId;
		result = prime * result + ((repaymentplanEnd == null) ? 0 : repaymentplanEnd.hashCode());
		result = prime * result + repaymentplanId;
		long temp;
		temp = Double.doubleToLongBits(repaymentplanMoneyall);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + repaymentplanPeriod;
		temp = Double.doubleToLongBits(repaymentplanPeriodMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((repaymentplanStart == null) ? 0 : repaymentplanStart.hashCode());
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
		TransactionRepaymentplan other = (TransactionRepaymentplan) obj;
		if (applyId != other.applyId)
			return false;
		if (repaymentplanEnd == null) {
			if (other.repaymentplanEnd != null)
				return false;
		} else if (!repaymentplanEnd.equals(other.repaymentplanEnd))
			return false;
		if (repaymentplanId != other.repaymentplanId)
			return false;
		if (Double.doubleToLongBits(repaymentplanMoneyall) != Double.doubleToLongBits(other.repaymentplanMoneyall))
			return false;
		if (repaymentplanPeriod != other.repaymentplanPeriod)
			return false;
		if (Double.doubleToLongBits(repaymentplanPeriodMoney) != Double
				.doubleToLongBits(other.repaymentplanPeriodMoney))
			return false;
		if (repaymentplanStart == null) {
			if (other.repaymentplanStart != null)
				return false;
		} else if (!repaymentplanStart.equals(other.repaymentplanStart))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionRepaymentplan [repaymentplanId=" + repaymentplanId + ", applyId=" + applyId
				+ ", repaymentplanStart=" + repaymentplanStart + ", repaymentplanEnd=" + repaymentplanEnd
				+ ", repaymentplanMoneyall=" + repaymentplanMoneyall + ", repaymentplanPeriod=" + repaymentplanPeriod
				+ ", repaymentplanPeriodMoney=" + repaymentplanPeriodMoney + "]";
	}
	
	
	
	
	
	
	
}
