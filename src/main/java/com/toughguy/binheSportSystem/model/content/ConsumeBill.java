package com.toughguy.binheSportSystem.model.content;

/**
 * 消费账单实体类
 * @author 
 *
 */
public class ConsumeBill {
	private String 	cardno;				//卡号
	private String  mobile;				//手机号
	private String  addmoney;			//充值金额
	private String  billtime;			//订单时间
	
	private String  consumetype;		//场馆名
	private String  keyno;				//场馆号
	private String  intime;				//账单时间(预定开始时间)
	private String  timeminute;			//历时时间
	private String  paid;				//实际费用
	
	public ConsumeBill() {
		super();
	}

	public ConsumeBill(String cardno, String mobile, String addmoney, String billtime, String consumetype, String keyno,
			String intime, String timeminute, String paid) {
		super();
		this.cardno = cardno;
		this.mobile = mobile;
		this.addmoney = addmoney;
		this.billtime = billtime;
		this.consumetype = consumetype;
		this.keyno = keyno;
		this.intime = intime;
		this.timeminute = timeminute;
		this.paid = paid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddmoney() {
		return addmoney;
	}

	public void setAddmoney(String addmoney) {
		this.addmoney = addmoney;
	}

	public String getBilltime() {
		return billtime;
	}

	public void setBilltime(String billtime) {
		this.billtime = billtime;
	}

	public String getConsumetype() {
		return consumetype;
	}

	public void setConsumetype(String consumetype) {
		this.consumetype = consumetype;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getTimeminute() {
		return timeminute;
	}

	public void setTimeminute(String timeminute) {
		this.timeminute = timeminute;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "ConsumeBill [cardno=" + cardno + ", mobile=" + mobile + ", addmoney=" + addmoney + ", billtime="
				+ billtime + ", consumetype=" + consumetype + ", keyno=" + keyno + ", intime=" + intime
				+ ", timeminute=" + timeminute + ", paid=" + paid + "]";
	}

	
}
