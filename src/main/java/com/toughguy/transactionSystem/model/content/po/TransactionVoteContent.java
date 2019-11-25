package com.toughguy.transactionSystem.model.content.po;
/**
 * 投票：
 * 投票内容表
 * @author 张泽
 *
 */
public class TransactionVoteContent {
	private int voteContentId;
	private String voteContent;
	
	
	public TransactionVoteContent(int voteContentId) {
		super();
		this.voteContentId = voteContentId;
	}
	public TransactionVoteContent(String voteContent) {
		super();
		this.voteContent = voteContent;
	}
	public TransactionVoteContent(int voteContentId, String voteContent) {
		super();
		this.voteContentId = voteContentId;
		this.voteContent = voteContent;
	}
	public int getVoteContentId() {
		return voteContentId;
	}
	public void setVoteContentId(int voteContentId) {
		this.voteContentId = voteContentId;
	}
	public String getVoteConten() {
		return voteContent;
	}
	public void setVoteConten(String voteContent) {
		this.voteContent = voteContent;
	}
	@Override
	public String toString() {
		return "TransactionVoteContent [voteContentId=" + voteContentId + ", voteContent=" + voteContent + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voteContent == null) ? 0 : voteContent.hashCode());
		result = prime * result + voteContentId;
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
		TransactionVoteContent other = (TransactionVoteContent) obj;
		if (voteContent == null) {
			if (other.voteContent != null)
				return false;
		} else if (!voteContent.equals(other.voteContent))
			return false;
		if (voteContentId != other.voteContentId)
			return false;
		return true;
	}
	
	
}
