package com.toughguy.transactionSystem.model.content;

import java.util.Date;
import java.util.Map;

public class QuestOption {
	private Date copiesEndTime;			// -问卷调差开始时间
	private Date copiesStartTime;		// -问卷调查结束时间
	private String copiesTitle;			// -问卷调差的题目
	private int copiesId;				// -问卷调查的id
	private int optionCount;			// -问卷调差总投票数
	private Map<String,Object> map;		// -问卷调查的问题集合
	private int questCount;				// -题目的总数
	
	public int getQuestCount() {
		return questCount;
	}
	public void setQuestCount(int questCount) {
		this.questCount = questCount;
	}

	public Date getCopiesEndTime() {
		return copiesEndTime;
	}
	public void setCopiesEndTime(Date copiesEndTime) {
		this.copiesEndTime = copiesEndTime;
	}
	public Date getCopiesStartTime() {
		return copiesStartTime;
	}
	public void setCopiesStartTime(Date copiesStartTime) {
		this.copiesStartTime = copiesStartTime;
	}
	public String getCopiesTitle() {
		return copiesTitle;
	}
	public void setCopiesTitle(String copiesTitle) {
		this.copiesTitle = copiesTitle;
	}
	public int getCopiesId() {
		return copiesId;
	}
	public void setCopiesId(int copiesId) {
		this.copiesId = copiesId;
	}
	public int getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public QuestOption(Date copiesEndTime, Date copiesStartTime, String copiesTitle, int copiesId, int optionCount,
			Map<String, Object> map) {
		super();
		this.copiesEndTime = copiesEndTime;
		this.copiesStartTime = copiesStartTime;
		this.copiesTitle = copiesTitle;
		this.copiesId = copiesId;
		this.optionCount = optionCount;
		this.map = map;
	}
	public QuestOption(Date copiesEndTime, Date copiesStartTime, String copiesTitle, int optionCount,
			Map<String, Object> map) {
		super();
		this.copiesEndTime = copiesEndTime;
		this.copiesStartTime = copiesStartTime;
		this.copiesTitle = copiesTitle;
		this.optionCount = optionCount;
		this.map = map;
	}
	
	
	public QuestOption() {
		super();
	}
	@Override
	public String toString() {
		return "QuestOption [copiesEndTime=" + copiesEndTime + ", copiesStartTime=" + copiesStartTime + ", copiesTitle="
				+ copiesTitle + ", copiesId=" + copiesId + ", optionCount=" + optionCount + ", map=" + map + "]";
	}

	
}
