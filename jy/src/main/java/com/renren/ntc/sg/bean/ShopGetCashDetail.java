package com.renren.ntc.sg.bean;

import java.util.Date;

public class ShopGetCashDetail {
	private long id;
	private Date create_time;
	private Date operate_time;
	private int cash_type;
	private int price;
	private long shop_id;
	private int status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}
	public int getCash_type() {
		return cash_type;
	}
	public void setCash_type(int cash_type) {
		this.cash_type = cash_type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
