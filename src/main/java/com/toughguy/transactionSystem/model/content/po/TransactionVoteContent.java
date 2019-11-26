package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

/**
 * 投票：
 * 投票内容表
 * @author 张泽
 *
 */
public class TransactionVoteContent {
	private int voteContentId;		// 投票内容id
	private String voteContent;		// 投票内容
	private String voteOptionOne;	// 选项一
	private int oneCount;			// 选项一投票人数
	private String voteOptionTwo;	// 选项二
	private int twoCount;			// 选项二投票人数
	private Date startTime;			// 开始时间
	private Date endTime;			// 结束时间
	
	public TransactionVoteContent() {
		super();
	}

	public TransactionVoteContent(int voteContentId) {
		super();
		this.voteContentId = voteContentId;
	}
	
	
	public TransactionVoteContent(int voteContentId, int oneCount, int twoCount) {
		super();
		this.voteContentId = voteContentId;
		this.oneCount = oneCount;
		this.twoCount = twoCount;
	}

	public TransactionVoteContent(String voteContent, String voteOptionOne, String voteOptionTwo, Date startTime,
			Date endTime) {
		super();
		this.voteContent = voteContent;
		this.voteOptionOne = voteOptionOne;
		this.voteOptionTwo = voteOptionTwo;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public TransactionVoteContent(String voteContent, String voteOptionOne, int oneCount, String voteOptionTwo,
			int twoCount, Date startTime, Date endTime) {
		super();
		this.voteContent = voteContent;
		this.voteOptionOne = voteOptionOne;
		this.oneCount = oneCount;
		this.voteOptionTwo = voteOptionTwo;
		this.twoCount = twoCount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public TransactionVoteContent(int voteContentId, String voteContent, String voteOptionOne, int oneCount,
			String voteOptionTwo, int twoCount, Date startTime, Date endTime) {
		super();
		this.voteContentId = voteContentId;
		this.voteContent = voteContent;
		this.voteOptionOne = voteOptionOne;
		this.oneCount = oneCount;
		this.voteOptionTwo = voteOptionTwo;
		this.twoCount = twoCount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getVoteContentId() {
		return voteContentId;
	}

	public void setVoteContentId(int voteContentId) {
		this.voteContentId = voteContentId;
	}

	public String getVoteContent() {
		return voteContent;
	}

	public void setVoteContent(String voteContent) {
		this.voteContent = voteContent;
	}

	public String getVoteOptionOne() {
		return voteOptionOne;
	}

	public void setVoteOptionOne(String voteOptionOne) {
		this.voteOptionOne = voteOptionOne;
	}

	public int getOneCount() {
		return oneCount;
	}

	public void setOneCount(int oneCount) {
		this.oneCount = oneCount;
	}

	public String getVoteOptionTwo() {
		return voteOptionTwo;
	}

	public void setVoteOptionTwo(String voteOptionTwo) {
		this.voteOptionTwo = voteOptionTwo;
	}

	public int getTwoCount() {
		return twoCount;
	}

	public void setTwoCount(int twoCount) {
		this.twoCount = twoCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + oneCount;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + twoCount;
		result = prime * result + ((voteContent == null) ? 0 : voteContent.hashCode());
		result = prime * result + voteContentId;
		result = prime * result + ((voteOptionOne == null) ? 0 : voteOptionOne.hashCode());
		result = prime * result + ((voteOptionTwo == null) ? 0 : voteOptionTwo.hashCode());
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
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (oneCount != other.oneCount)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (twoCount != other.twoCount)
			return false;
		if (voteContent == null) {
			if (other.voteContent != null)
				return false;
		} else if (!voteContent.equals(other.voteContent))
			return false;
		if (voteContentId != other.voteContentId)
			return false;
		if (voteOptionOne == null) {
			if (other.voteOptionOne != null)
				return false;
		} else if (!voteOptionOne.equals(other.voteOptionOne))
			return false;
		if (voteOptionTwo == null) {
			if (other.voteOptionTwo != null)
				return false;
		} else if (!voteOptionTwo.equals(other.voteOptionTwo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionVoteContent [voteContentId=" + voteContentId + ", voteContent=" + voteContent
				+ ", voteOptionOne=" + voteOptionOne + ", oneCount=" + oneCount + ", voteOptionTwo=" + voteOptionTwo
				+ ", twoCount=" + twoCount + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
