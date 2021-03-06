package com.renren.ntc.sg.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yunming.zhu
 * Date: 14-10-15
 * Time: 下午2:13
 * To change this template use File | Settings | File Templates.
*/
public class Shop implements Comparable<Shop>{


    private  long id ;



    private  String shop_address = "";
    private long owner_user_id = 0;
    private  String name = "";

    private  String tel = "";
    private  String  shop_url  = "";

    private int status = 0;
    private int base_price = 2000;

    private String  status4V = "" ;
    private Date open_time ;
    private Date close_time ;
    private Date create_time ;
    private  Date  updatetime;
    private  String  owner_phone   = "";
    private  String  head_url   = "";
    private String remark;//备注
    private String ext;//扩展字段json

    public String getShop_info() {
        return shop_info;
    }

    public void setShop_info(String shop_info) {
        this.shop_info = shop_info;
    }

    private String shop_info = "";//服务范围



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBase_price() {
        return base_price;
    }

    public void setBase_price(int base_price) {
        this.base_price = base_price;
    }

    public String getStatus4V() {
        return status4V;
    }

    public void setStatus4V(String status4V) {
        this.status4V = status4V;
    }

    public Date getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Date open_time) {
        this.open_time = open_time;
    }

    public Date getClose_time() {
        return close_time;
    }

    public void setClose_time(Date close_time) {
        this.close_time = close_time;
    }


    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    private int audit = 0 ;
    /**
     * 
     */
    private  double  lng = 0;

    public long getOwner_user_id() {
        return owner_user_id;
    }

    public void setOwner_user_id(long owner_user_id) {
        this.owner_user_id = owner_user_id;
    }


    public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	private  double  lat = 0;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private  String owner   = "";

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreate_time() {

        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getShop_url() {

        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public String getOwner_phone() {

        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Override
	public int compareTo(Shop o) {
		 if(o!=null){
	            if(this.getStatus()<o.getStatus()){
	               return 1;
	            }else if(this.getStatus()==o.getStatus()){
	               return 0;
	            }
	       }
	       return -1;
	    }
	}
