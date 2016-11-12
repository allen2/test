package com.renren.ntc.sg.constant;

public enum QuerySummaryType {
	NOTSETTLE(0,"nosettle"),SETTLEED(1,"settled");
	private int code;
	private String desc;
	private QuerySummaryType(int code,String desc){
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
