package com.renren.ntc.sg.bean;
/**
 * 设备对象的地址
 * @author chunhai.li
 *
 */
public class DeviceAddress extends Address{
	private long user_device_id;

	public long getUser_device_id() {
		return user_device_id;
	}

	public void setUser_device_id(long user_device_id) {
		this.user_device_id = user_device_id;
	}
}
