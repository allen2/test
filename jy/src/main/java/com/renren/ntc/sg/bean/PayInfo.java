package com.renren.ntc.sg.bean;

import java.util.Date;

/**
 * Created by ZhaoXiuFei on 2015/5/19 13:39.
 */
public class PayInfo {
    private long id;
    private long shop_id = 0;
    private String shop_name = "shop_name";
    private String wx_open_id = "wx_open_id";
    private String pay_id = "pay_id";
    private String re_user_name;
    private String payment_wx_no = "payment_wx_no";//default
    private String pay_info;
    private String op = "op";//default
    private int price;
    private int pay_status = 0;//default
    private Date create_time;

    public PayInfo() {
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public String getPayment_wx_no() {
        return payment_wx_no;
    }

    public void setPayment_wx_no(String payment_wx_no) {
        this.payment_wx_no = payment_wx_no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRe_user_name() {
        return re_user_name;
    }

    public void setRe_user_name(String re_user_name) {
        this.re_user_name = re_user_name;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getWx_open_id() {
        return wx_open_id;
    }

    public void setWx_open_id(String wx_open_id) {
        this.wx_open_id = wx_open_id;
    }
}
