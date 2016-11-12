package com.renren.ntc.sg.bean;

public class Settlement {
	public Settlement(){
		
	}
	public Settlement(String date, int orderCount, int orderPrice) {
		super();
		this.date = date;
		this.orderCount = orderCount;
		this.orderPrice = orderPrice;
	}
	
	public Settlement(String date, int orderCount, int orderPrice,int payStatus) {
		super();
		this.date = date;
		this.orderCount = orderCount;
		this.orderPrice = orderPrice;
		this.payStatus = payStatus;
	}
	private String date;
	private int orderCount;
	private int orderPrice;
	private int payStatus;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
}