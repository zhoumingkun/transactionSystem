package com.toughguy.binheSportSystem.model.content;

/**
 * 微信与会员的绑定类
 * @author qi
 *
 */
public class WXBind {
	private String openid;			//用户公众号的openid
	private String username;		//姓名
	private String cardno;			//卡号
	private String usermobile;		//手机号
	private String cashleft;		//账户余额
	private String state;			//为 200绑定成功   400绑定失败
	
	public WXBind() {
		super();
	}

	public WXBind(String openid, String username, String cardno, String usermobile, String cashleft, String state) {
		super();
		this.openid = openid;
		this.username = username;
		this.cardno = cardno;
		this.usermobile = usermobile;
		this.cashleft = cashleft;
		this.state = state;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getCashleft() {
		return cashleft;
	}

	public void setCashleft(String cashleft) {
		this.cashleft = cashleft;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "WXBind [openid=" + openid + ", username=" + username + ", cardno=" + cardno + ", usermobile="
				+ usermobile + ", cashleft=" + cashleft + ", state=" + state + "]";
	}

	
}
