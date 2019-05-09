package com.toughguy.binheSportSystem.model.content;

/**
 * 场地预定时间类
 * @author 
 *
 */
public class Reserve {
	private String fieldtype;	//场馆名
	private int fieldno;		//场地号
	private String starttime;	//开始时间
	private String endtime;		//结束时间
	private int  state;			//使用状态   0：预订；1：在场计时；2：定时；3：已结账；4：已作废
	
	public Reserve() {
		super();
	}
	
	public Reserve(String fieldtype, int fieldno, String starttime, String endtime, int state) {
		super();
		this.fieldtype = fieldtype;
		this.fieldno = fieldno;
		this.starttime = starttime;
		this.endtime = endtime;
		this.state = state;
	}

	public String getFieldtype() {
		return fieldtype;
	}
	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}
	public int getFieldno() {
		return fieldno;
	}
	public void setFieldno(int fieldno) {
		this.fieldno = fieldno;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "Reserve [fieldtype=" + fieldtype + ", fieldno=" + fieldno + ", starttime=" + starttime + ", endtime="
				+ endtime + ", state=" + state + "]";
	}
	
	
	

}

