package com.renren.ntc.sg.bean;

import java.util.Date;

/**
 * 用户app 设备表
 * @author chunhai.li
 *
 */
public class UserDevice extends User{
	private long sysid;
	private String uid;
	private String gid;
	private String chn;
	private Date create_time;
	private Date last_login_time;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getChn() {
		return chn;
	}
	public void setChn(String chn) {
		this.chn = chn;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public long getSysid() {
		return sysid;
	}
	public void setSysid(long sysid) {
		this.sysid = sysid;
	}
}
