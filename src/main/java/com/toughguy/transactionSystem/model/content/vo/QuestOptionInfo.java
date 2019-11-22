package com.toughguy.transactionSystem.model.content.vo;

import java.util.Date;

/**
 * 	问卷调查vo实体类
 * @author Guozhenze
 *
 */
public class QuestOptionInfo {
	private int questId;				// -id
	private String questContent;		// -问题的内容
	private int copiesId;				// -哪张调查问卷
	private String copiesTitle;			// -调查问卷题目
	private Date copiesStartTime;		// -调查问卷开始时间
	private Date copiesEndTime;			// -调查问卷结束时间
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
	public String getCopiesTitle() {
		return copiesTitle;
	}
	public void setCopiesTitle(String copiesTitle) {
		this.copiesTitle = copiesTitle;
	}
	public Date getCopiesStartTime() {
		return copiesStartTime;
	}
	public void setCopiesStarTime(Date copiesStartTime) {
		this.copiesStartTime = copiesStartTime;
	}
	public Date getCopiesEndTime() {
		return copiesEndTime;
	}
	public void setCopiesEndTime(Date copiesEndTime) {
		this.copiesEndTime = copiesEndTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copiesEndTime == null) ? 0 : copiesEndTime.hashCode());
		result = prime * result + copiesId;
		result = prime * result + ((copiesStartTime == null) ? 0 : copiesStartTime.hashCode());
		result = prime * result + ((copiesTitle == null) ? 0 : copiesTitle.hashCode());
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
		QuestOptionInfo other = (QuestOptionInfo) obj;
		if (copiesEndTime == null) {
			if (other.copiesEndTime != null)
				return false;
		} else if (!copiesEndTime.equals(other.copiesEndTime))
			return false;
		if (copiesId != other.copiesId)
			return false;
		if (copiesStartTime == null) {
			if (other.copiesStartTime != null)
				return false;
		} else if (!copiesStartTime.equals(other.copiesStartTime))
			return false;
		if (copiesTitle == null) {
			if (other.copiesTitle != null)
				return false;
		} else if (!copiesTitle.equals(other.copiesTitle))
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
		return "QuestOptionInfo [questId=" + questId + ", questContent=" + questContent + ", copiesId=" + copiesId
				+ ", copiesTitle=" + copiesTitle + ", copiesStarTime=" + copiesStartTime + ", copiesEndTime="
				+ copiesEndTime + "]";
	}
	public QuestOptionInfo(int questId, String questContent, int copiesId, String copiesTitle, Date copiesStartTime,
			Date copiesEndTime) {
		super();
		this.questId = questId;
		this.questContent = questContent;
		this.copiesId = copiesId;
		this.copiesTitle = copiesTitle;
		this.copiesStartTime = copiesStartTime;
		this.copiesEndTime = copiesEndTime;
	}
	public QuestOptionInfo(String questContent, int copiesId, String copiesTitle, Date copiesStartTime,
			Date copiesEndTime) {
		super();
		this.questContent = questContent;
		this.copiesId = copiesId;
		this.copiesTitle = copiesTitle;
		this.copiesStartTime = copiesStartTime;
		this.copiesEndTime = copiesEndTime;
	}
	public QuestOptionInfo() {
		super();
	}
	
}
