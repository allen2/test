package com.renren.ntc.sg.bean;

import java.util.Date;

public class AreaSummary {
    private long id = 0;
    private String area;



    private int wx_order_count;
    private int wx_order_sum;
    private int cash_order_count;
    private int cash_order_sum;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getWx_order_count() {
        return wx_order_count;
    }

    public void setWx_order_count(int wx_order_count) {
        this.wx_order_count = wx_order_count;
    }

    public int getWx_order_sum() {
        return wx_order_sum;
    }

    public void setWx_order_sum(int wx_order_sum) {
        this.wx_order_sum = wx_order_sum;
    }

    public int getCash_order_count() {
        return cash_order_count;
    }

    public void setCash_order_count(int cash_order_count) {
        this.cash_order_count = cash_order_count;
    }

    public int getCash_order_sum() {
        return cash_order_sum;
    }

    public void setCash_order_sum(int cash_order_sum) {
        this.cash_order_sum = cash_order_sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    private Date create_time;




}
