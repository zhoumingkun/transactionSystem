package com.toughguy.transactionSystem.model.content.po;
/**
 * 
 *   问卷调差选项实体类
 * @author Guozhenze
 *
 */
public class TransactionOption {
	private int optionId;				// -id
	private int questId;				// -问题id
	private String optionContent;		// -选项内容
	private int optionCount;			// -选择的人数的统计
	

	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public String getOptionContent() {
		return optionContent;
	}
	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}
	public int getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((optionContent == null) ? 0 : optionContent.hashCode());
		result = prime * result + optionCount;
		result = prime * result + optionId;
		result = prime * result + questId;
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
		TransactionOption other = (TransactionOption) obj;
		if (optionContent == null) {
			if (other.optionContent != null)
				return false;
		} else if (!optionContent.equals(other.optionContent))
			return false;
		if (optionCount != other.optionCount)
			return false;
		if (optionId != other.optionId)
			return false;
		if (questId != other.questId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionOption [optionId=" + optionId + ", questId=" + questId + ", optionContent=" + optionContent
				+ ", optionCount=" + optionCount + "]";
	}
	public TransactionOption(int optionId, int questId, String optionContent, int optionCount) {
		super();
		this.optionId = optionId;
		this.questId = questId;
		this.optionContent = optionContent;
		this.optionCount = optionCount;
	}
	public TransactionOption(int questId, String optionContent, int optionCount) {
		super();
		this.questId = questId;
		this.optionContent = optionContent;
		this.optionCount = optionCount;
	}
	public TransactionOption() {
		super();
	}
	
	
}
