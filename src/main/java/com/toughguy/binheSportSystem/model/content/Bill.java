package com.toughguy.binheSportSystem.model.content;

/**
 * 查询用户消费账单   请求参数和返回参数实体类
 * @author qi
 *
 */
public class Bill {
	private String type;		//状态   1为充值   2为消费
	private String cardId;		//卡号
	private String money;		//消费金额
	private String time;		//时间
	
	public Bill() {
		super();
	}

	public Bill(String type, String cardId, String money, String time) {
		super();
		this.type = type;
		this.cardId = cardId;
		this.money = money;
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Bill [type=" + type + ", cardId=" + cardId + ", money=" + money + ", time=" + time + "]";
	}

	
	
}
