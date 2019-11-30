package com.toughguy.transactionSystem.model.content.po;

import java.util.Date;

/**
 * 融资信息实体类
 * @author liDongSheng
 *
 */
public class TransactionFinancing {
	private int financingId;      				//融资信息id
	private String financingName;				//项目名称
	private String financingPeople;				//发起企业（人）
	private String financingContent;			//融资产品内容	
	private String financingImg;				//图片
	private Date financingStart;				//活动开始时间
	private Date financingEnd;					//活动结束时间
	private int financingRank;					//可报名等级
	private int financingPv;					//访问量
	private Date financingReleaseDate;			//发布时间
	private int addressId;						//区域id
	private	int enterpriseTypeId;						//企业类型	
	public TransactionFinancing(String financingName, String financingPeople, String financingContent,
			String financingImg, Date financingStart, Date financingEnd, int financingRank, int financingPv,
			Date financingReleaseDate, int addressId, int enterpriseTypeId) {
		super();
		this.financingName = financingName;
		this.financingPeople = financingPeople;
		this.financingContent = financingContent;
		this.financingImg = financingImg;
		this.financingStart = financingStart;
		this.financingEnd = financingEnd;
		this.financingRank = financingRank;
		this.financingPv = financingPv;
		this.financingReleaseDate = financingReleaseDate;
		this.addressId = addressId;
		this.enterpriseTypeId = enterpriseTypeId;
	}

	public TransactionFinancing(int financingId, String financingName, String financingPeople, String financingContent,
			String financingImg, Date financingStart, Date financingEnd, int financingRank, int financingPv,
			Date financingReleaseDate, int addressId, int enterpriseTypeId) {
		super();
		this.financingId = financingId;
		this.financingName = financingName;
		this.financingPeople = financingPeople;
		this.financingContent = financingContent;
		this.financingImg = financingImg;
		this.financingStart = financingStart;
		this.financingEnd = financingEnd;
		this.financingRank = financingRank;
		this.financingPv = financingPv;
		this.financingReleaseDate = financingReleaseDate;
		this.addressId = addressId;
		this.enterpriseTypeId = enterpriseTypeId;
	}

	public TransactionFinancing() {
		super();
	}
	public int getFinancingId() {
		return financingId;
	}
	public void setFinancingId(int financingId) {
		this.financingId = financingId;
	}
	public String getFinancingName() {
		return financingName;
	}
	public void setFinancingName(String financingName) {
		this.financingName = financingName;
	}
	public String getFinancingPeople() {
		return financingPeople;
	}
	public void setFinancingPeople(String financingPeople) {
		this.financingPeople = financingPeople;
	}
	public String getFinancingContent() {
		return financingContent;
	}
	public void setFinancingContent(String financingContent) {
		this.financingContent = financingContent;
	}
	public String getFinancingImg() {
		return financingImg;
	}
	public void setFinancingImg(String financingImg) {
		this.financingImg = financingImg;
	}
	public Date getFinancingStart() {
		return financingStart;
	}
	public void setFinancingStart(Date financingStart) {
		this.financingStart = financingStart;
	}
	public Date getFinancingEnd() {
		return financingEnd;
	}
	public void setFinancingEnd(Date financingEnd) {
		this.financingEnd = financingEnd;
	}
	public int getFinancingRank() {
		return financingRank;
	}
	public void setFinancingRank(int financingRank) {
		this.financingRank = financingRank;
	}
	public int getFinancingPv() {
		return financingPv;
	}
	public void setFinancingPv(int financingPv) {
		this.financingPv = financingPv;
	}
	public Date getFinancingReleaseDate() {
		return financingReleaseDate;
	}
	public void setFinancingReleaseDate(Date financingReleaseDate) {
		this.financingReleaseDate = financingReleaseDate;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getEnterpriseTypeId() {
		return enterpriseTypeId;
	}
	public void setEnterpriseTypeId(int enterpriseTypeId) {
		this.enterpriseTypeId = enterpriseTypeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + enterpriseTypeId;
		result = prime * result + ((financingContent == null) ? 0 : financingContent.hashCode());
		result = prime * result + ((financingEnd == null) ? 0 : financingEnd.hashCode());
		result = prime * result + financingId;
		result = prime * result + ((financingImg == null) ? 0 : financingImg.hashCode());
		result = prime * result + ((financingName == null) ? 0 : financingName.hashCode());
		result = prime * result + ((financingPeople == null) ? 0 : financingPeople.hashCode());
		result = prime * result + financingPv;
		result = prime * result + financingRank;
		result = prime * result + ((financingReleaseDate == null) ? 0 : financingReleaseDate.hashCode());
		result = prime * result + ((financingStart == null) ? 0 : financingStart.hashCode());
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
		TransactionFinancing other = (TransactionFinancing) obj;
		if (addressId != other.addressId)
			return false;
		if (enterpriseTypeId != other.enterpriseTypeId)
			return false;
		if (financingContent == null) {
			if (other.financingContent != null)
				return false;
		} else if (!financingContent.equals(other.financingContent))
			return false;
		if (financingEnd == null) {
			if (other.financingEnd != null)
				return false;
		} else if (!financingEnd.equals(other.financingEnd))
			return false;
		if (financingId != other.financingId)
			return false;
		if (financingImg == null) {
			if (other.financingImg != null)
				return false;
		} else if (!financingImg.equals(other.financingImg))
			return false;
		if (financingName == null) {
			if (other.financingName != null)
				return false;
		} else if (!financingName.equals(other.financingName))
			return false;
		if (financingPeople == null) {
			if (other.financingPeople != null)
				return false;
		} else if (!financingPeople.equals(other.financingPeople))
			return false;
		if (financingPv != other.financingPv)
			return false;
		if (financingRank != other.financingRank)
			return false;
		if (financingReleaseDate == null) {
			if (other.financingReleaseDate != null)
				return false;
		} else if (!financingReleaseDate.equals(other.financingReleaseDate))
			return false;
		if (financingStart == null) {
			if (other.financingStart != null)
				return false;
		} else if (!financingStart.equals(other.financingStart))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionFinancing [financingId=" + financingId + ", financingName=" + financingName
				+ ", financingPeople=" + financingPeople + ", financingContent=" + financingContent + ", financingImg="
				+ financingImg + ", financingStart=" + financingStart + ", financingEnd=" + financingEnd
				+ ", financingRank=" + financingRank + ", financingPv=" + financingPv + ", financingReleaseDate="
				+ financingReleaseDate + ", addressId=" + addressId + ", enterpriseTypeId=" + enterpriseTypeId + "]";
	}
	
	
	
}	
