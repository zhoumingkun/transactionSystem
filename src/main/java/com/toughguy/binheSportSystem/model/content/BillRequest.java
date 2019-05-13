package com.toughguy.binheSportSystem.model.content;

/**
 * 查询用户账单请求参数封装类
 * @author qi
 *
 */
public class BillRequest {
	private String cardId;		//卡号
	private String mobile;		//手机号
	private String starttime;	//查询账单的起始时间
	private String endtime;		//查询账单的结束时间
	
	public BillRequest() {
		super();
	}

	public BillRequest(String cardId, String mobile, String starttime, String endtime) {
		super();
		this.cardId = cardId;
		this.mobile = mobile;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "BillRequest [cardId=" + cardId + ", mobile=" + mobile + ", starttime=" + starttime + ", endtime="
				+ endtime + "]";
	}
	
}
