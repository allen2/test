package com.renren.ntc.sg.bean;

import java.util.Date;

/**
 * CREATE TABLE `user_pushtoken` (
  `sysid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `uid` varchar(50) NOT NULL COMMENT 'uid appleuid',
  `gid` varchar(50) NOT NULL COMMENT 'gid server id',
  `chn` varchar(10) NOT NULL DEFAULT ''  COMMENT 'adr ios ',
  `token` varchar(250) NOT NULL DEFAULT '' COMMENT 'device token',  
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`sysid`),
  UNIQUE KEY `idx_uid_chn` (`uid`,`chn`),
  KEY `token` (`token`(9))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author chunhai.li
 *
 */
public class UserPushToken {
	private long sysid;
	private String uid;
	private String chn;
	private String token;
	private Date create_time;
	private Date update_time;
	public UserPushToken(){
		
	}
	public UserPushToken(String uid, String chn, String token) {
		super();
		this.uid = uid;
		this.chn = chn;
		this.token = token;
	}
	public UserPushToken(long sysid, String uid, String chn, String token) {
		super();
		this.sysid = sysid;
		this.uid = uid;
		this.chn = chn;
		this.token = token;
	}
	public long getSysid() {
		return sysid;
	}
	public void setSysid(long sysid) {
		this.sysid = sysid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getChn() {
		return chn;
	}
	public void setChn(String chn) {
		this.chn = chn;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
}
