package com.toughguy.transactionSystem.model.content.po;
/**
 * 	 判断用户是否投票
 * @author Guozhenze
 *
 */
public class TransactionStatistics {
	
	private int statisticsId;
	private int copiesId;
	private int memberId;
	public int getStatisticsId() {
		return statisticsId;
	}
	public void setStatisticsId(int statisticsId) {
		this.statisticsId = statisticsId;
	}
	public int getCopiesId() {
		return copiesId;
	}
	public void setCopiesId(int copiesId) {
		this.copiesId = copiesId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public TransactionStatistics(int statisticsId, int copiesId, int memberId) {
		super();
		this.statisticsId = statisticsId;
		this.copiesId = copiesId;
		this.memberId = memberId;
	}
	public TransactionStatistics(int copiesId, int memberId) {
		super();
		this.copiesId = copiesId;
		this.memberId = memberId;
	}
	public TransactionStatistics() {
		super();
	}
	
	
		
}
