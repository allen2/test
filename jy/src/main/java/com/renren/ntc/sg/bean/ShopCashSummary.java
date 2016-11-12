package com.renren.ntc.sg.bean;

import java.util.Date;

import com.renren.ntc.sg.util.Dateutils;

public class ShopCashSummary {
	private long id;
	private int price;
	private Date create_time;
	private Date update_time;
	private int status;
	private long shop_id;
	private Boss boss;
	private String shop_name;
	private String dateStr;
	private String order_price_str;
	private long shop_cash_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public Boss getBoss() {
		return boss;
	}
	public void setBoss(Boss boss) {
		this.boss = boss;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getDateStr() {
		if(create_time == null){
			return "";
		}
		dateStr = Dateutils.tranferDefaultDate2Str(create_time);
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getOrder_price_str() {
		if(price == 0){
			return "0元";
		}
		order_price_str = (float)price/100+"元";
		return order_price_str;
	}
	public void setOrder_price_str(String order_price_str) {
		this.order_price_str = order_price_str;
	}
	public long getShop_cash_id() {
		return shop_cash_id;
	}
	public void setShop_cash_id(long shop_cash_id) {
		this.shop_cash_id = shop_cash_id;
	}
}
