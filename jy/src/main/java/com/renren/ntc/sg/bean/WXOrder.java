package com.renren.ntc.sg.bean;

import com.alibaba.fastjson.JSONObject;

public class WXOrder {
	private long shop_id;
	private Order order;
	private long coupon_id;
	private String coupon_code;
	private int price;
	private JSONObject data;
	private User user;
	private String act;
	public WXOrder(){
		
	}
	public WXOrder(long shop_id, Order order, long coupon_id,
			String coupon_code, int price, JSONObject data, User user,String act) {
		super();
		this.shop_id = shop_id;
		this.order = order;
		this.coupon_id = coupon_id;
		this.coupon_code = coupon_code;
		this.price = price;
		this.data = data;
		this.user = user;
		this.act = act;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public long getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(long coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
}
