package com.toughguy.binheSportSystem.model.content;


import java.util.List;


/**
 * 场馆预定详情类
 * @author 
 *
 */
public class Scheduled {
	private String venue;		//场馆名
	private String date;		//时间
	private List<FieldList> fieldList;
	
	
	
	public Scheduled() {
		super();
	}



	public Scheduled(String venue, String date, List<FieldList> fieldList) {
		super();
		this.venue = venue;
		this.date = date;
		this.fieldList = fieldList;
	}



	public String getVenue() {
		return venue;
	}



	public void setVenue(String venue) {
		this.venue = venue;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public List<FieldList> getFieldList() {
		return fieldList;
	}



	public void setFieldList(List<FieldList> fieldList) {
		this.fieldList = fieldList;
	}



	@Override
	public String toString() {
		return "Scheduled [venue=" + venue + ", date=" + date + ", fieldList=" + fieldList + "]";
	}
	
	
	
	
}
