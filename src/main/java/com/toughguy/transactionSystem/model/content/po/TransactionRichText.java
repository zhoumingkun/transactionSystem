package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;
/**
 * 富文本编辑实体类
 * @author 张泽
 *
 */
public class TransactionRichText {
	private int titleId;		// 文章Id
	private String title;		// 标题
	private String content;		// 内容
	private Date createTime;	// 创建时间
	private Date updateTime;	// 修改时间
	private int titleStatus;	// 文章状态
	
	public TransactionRichText(int titleId, String title, String content, Date createTime, Date updateTime,
			int titleStatus) {
		super();
		this.titleId = titleId;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.titleStatus = titleStatus;
	}
	public TransactionRichText(String title, String content, Date createTime, Date updateTime,
			int titleStatus) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.titleStatus = titleStatus;
	}
	public TransactionRichText() {
		super();
	}
	
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getTitleStatus() {
		return titleStatus;
	}
	public void setTitleStatus(int titleStatus) {
		this.titleStatus = titleStatus;
	}
	@Override
	public String toString() {
		return "TransactionRichText [titleId=" + titleId +  ", title=" + title + ", content="
				+ content + ", createTime=" + createTime + ", updateTime=" + updateTime + ", titleStatus=" + titleStatus
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + titleId;
		result = prime * result + titleStatus;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
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
		TransactionRichText other = (TransactionRichText) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (titleId != other.titleId)
			return false;
		if (titleStatus != other.titleStatus)
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}
	
	
}
