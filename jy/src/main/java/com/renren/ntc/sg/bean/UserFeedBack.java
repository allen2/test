package com.renren.ntc.sg.bean;

import java.util.Date;

/**
 * 用户反馈
 * @author chunhai.li
 *
 */
public class UserFeedBack {
	private long id;
	private Date create_time;
	private String phone;
	private String msg;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
