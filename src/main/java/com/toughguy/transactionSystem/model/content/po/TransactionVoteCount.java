package com.toughguy.transactionSystem.model.content.po;

/**
 * 投票：
 *  投票信息记录表
 * @author 张泽
 *
 */
public class TransactionVoteCount {
	private int voteCountId;		// id
	private int memberId;			// 会员id
	private int voteContentId;		// 投票id
	
	public TransactionVoteCount() {
		super();
	}
	public TransactionVoteCount(int voteCountId) {
		super();
		this.voteCountId = voteCountId;
	}
	public TransactionVoteCount(int memberId, int voteContentId) {
		super();
		this.memberId = memberId;
		this.voteContentId = voteContentId;
	}
	public TransactionVoteCount(int voteCountId, int memberId, int voteContentId) {
		super();
		this.voteCountId = voteCountId;
		this.memberId = memberId;
		this.voteContentId = voteContentId;
	}
	public int getVoteCountId() {
		return voteCountId;
	}
	public void setVoteCountId(int voteCountId) {
		this.voteCountId = voteCountId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getVoteContentId() {
		return voteContentId;
	}
	public void setVoteContentId(int voteContentId) {
		this.voteContentId = voteContentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberId;
		result = prime * result + voteContentId;
		result = prime * result + voteCountId;
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
		TransactionVoteCount other = (TransactionVoteCount) obj;
		if (memberId != other.memberId)
			return false;
		if (voteContentId != other.voteContentId)
			return false;
		if (voteCountId != other.voteCountId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionVoteCount [voteCountId=" + voteCountId + ", memberId=" + memberId + ", voteContentId="
				+ voteContentId + "]";
	}
	
	
	
	
}
