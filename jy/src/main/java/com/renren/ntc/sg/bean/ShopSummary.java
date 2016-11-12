package com.renren.ntc.sg.bean;

import java.util.Date;

import com.renren.ntc.sg.util.Dateutils;

/**
 * CREATE TABLE shop_summary (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL DEFAULT '0',  
  `order_count` int(11) NOT NULL DEFAULT '0',
  `order_price` int(11) NOT NULL DEFAULT '0',  
  `pay_status` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),  
  KEY create_time (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 * @author chunhai.li
 *
 */
public class ShopSummary {
	private long id;
	private long shop_id;
	private int order_count;
	private int order_price;
	private int pay_status;
	private Date create_time;
	private String shop_name;
	private String dateStr;
	private String order_price_str;



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getPay_status() {
		return pay_status;
	}
	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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
		if(order_price == 0){
			return "0元";
		}
		order_price_str = (float)order_price/100+"元";
		return order_price_str;
	}
	public void setOrder_price_str(String order_price_str) {
		this.order_price_str = order_price_str;
	}
}
