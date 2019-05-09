package com.toughguy.binheSportSystem.model.content;

/**
 * 节假日类
 * @author 
 *
 */
public class Holiday {
	
	private int id;
	private String holiday;
	private int hbflag;
	
	public Holiday() {
		super();
	}
	
	public Holiday(int id, String holiday, int hbflag) {
		super();
		this.id = id;
		this.holiday = holiday;
		this.hbflag = hbflag;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public int getHbflag() {
		return hbflag;
	}
	public void setHbflag(int hbflag) {
		this.hbflag = hbflag;
	}

	@Override
	public String toString() {
		return "Holiday [id=" + id + ", holiday=" + holiday + ", hbflag=" + hbflag + "]";
	}
	

}
