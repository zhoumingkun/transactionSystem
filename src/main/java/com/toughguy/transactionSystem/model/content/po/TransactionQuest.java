package com.toughguy.transactionSystem.model.content.po;
/**
 * 		问卷调差问题实体类
 * @author LENOVO
 *
 */
public class TransactionQuest {
	private int questId;				// -问题id
	private String questContent;		// -问题的内容
	private int copiesId;				// -问卷调差的id
	private double questStatus;         // - 单选还是多选
	
	
	public double getQuestStatus() {
		return questStatus;
	}
	public void setQuestStatus(double questStatus) {
		this.questStatus = questStatus;
	}
	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public String getQuestContent() {
		return questContent;
	}
	public void setQuestContent(String questContent) {
		this.questContent = questContent;
	}
	public int getCopiesId() {
		return copiesId;
	}
	public void setCopiesId(int copiesId) {
		this.copiesId = copiesId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copiesId;
		result = prime * result + ((questContent == null) ? 0 : questContent.hashCode());
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
		TransactionQuest other = (TransactionQuest) obj;
		if (copiesId != other.copiesId)
			return false;
		if (questContent == null) {
			if (other.questContent != null)
				return false;
		} else if (!questContent.equals(other.questContent))
			return false;
		if (questId != other.questId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionQuest [questId=" + questId + ", questContent=" + questContent + ", copiesId=" + copiesId
				+ "]";
	}
	public TransactionQuest(int questId, String questContent, int copiesId) {
		super();
		this.questId = questId;
		this.questContent = questContent;
		this.copiesId = copiesId;
	}
	public TransactionQuest(String questContent, int copiesId) {
		super();
		this.questContent = questContent;
		this.copiesId = copiesId;
	}
	public TransactionQuest() {
		super();
	}
	
	
}
