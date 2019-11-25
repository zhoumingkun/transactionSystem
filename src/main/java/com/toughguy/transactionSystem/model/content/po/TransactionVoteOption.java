package com.toughguy.transactionSystem.model.content.po;

/**
 * 投票：
 *  选项信息表
 * @author 张泽
 *
 */
public class TransactionVoteOption {
	private int voteOptionId;
	private int voteContentId;
	private String voteOption;
	private int voteCount;
		
	/**
	 * 删除 查看
	 * @param voteOptionId
	 */
	public TransactionVoteOption(int voteOptionId) {
		super();
		this.voteOptionId = voteOptionId;
	}
	

	public TransactionVoteOption(int voteOptionId, int voteCount) {
		super();
		this.voteOptionId = voteOptionId;
		this.voteCount = voteCount;
	}


	/**
	 * 添加信息 查看所有
	 * @param voteContentId
	 * @param voteOption
	 */
	public TransactionVoteOption(int voteContentId, String voteOption, int voteCount) {
		super();
		this.voteContentId = voteContentId;
		this.voteOption = voteOption;
		this.voteCount = voteCount;
	}
	
	public TransactionVoteOption(int voteContentId, String voteOption) {
		super();
		this.voteContentId = voteContentId;
		this.voteOption = voteOption;
	}


	/**
	 * 更改
	 * @param voteOptionId
	 * @param voteContentId
	 * @param voteOption
	 * @param voteCount
	 */
	public TransactionVoteOption(int voteOptionId, int voteContentId, String voteOption, int voteCount) {
		super();
		this.voteOptionId = voteOptionId;
		this.voteContentId = voteContentId;
		this.voteOption = voteOption;
		this.voteCount = voteCount;
	}




	public int getVoteCount() {
		return voteCount;
	}


	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}


	public int getVoteOptionId() {
		return voteOptionId;
	}

	public void setVoteOptionId(int voteOptionId) {
		this.voteOptionId = voteOptionId;
	}

	public int getVoteContentId() {
		return voteContentId;
	}

	public void setVoteContentId(int voteContentId) {
		this.voteContentId = voteContentId;
	}

	public String getVoteOption() {
		return voteOption;
	}

	public void setVoteOption(String voteOption) {
		this.voteOption = voteOption;
	}

	@Override
	public String toString() {
		return "TransactionVoteOption [voteOptionId=" + voteOptionId + ", voteContentId=" + voteContentId
				+ ", voteOption=" + voteOption + ", voteCount=" + voteCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + voteContentId;
		result = prime * result + voteCount;
		result = prime * result + ((voteOption == null) ? 0 : voteOption.hashCode());
		result = prime * result + voteOptionId;
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
		TransactionVoteOption other = (TransactionVoteOption) obj;
		if (voteContentId != other.voteContentId)
			return false;
		if (voteCount != other.voteCount)
			return false;
		if (voteOption == null) {
			if (other.voteOption != null)
				return false;
		} else if (!voteOption.equals(other.voteOption))
			return false;
		if (voteOptionId != other.voteOptionId)
			return false;
		return true;
	}
	
	
}
