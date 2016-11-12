package com.renren.ntc.sg.bean;

public class Boss {
    private long id = 0;
    private long shop_id = 0;
    private String name;
    private String wx_open_id;
    private String blank_name;
    private String blank_cnaps="";
    private String blank_account;
    private String blank_account_holder;

    public String getBlank_account() {
        return blank_account;
    }

    public void setBlank_account(String blank_account) {
        this.blank_account = blank_account;
    }

    public String getBlank_account_holder() {
        return blank_account_holder;
    }

    public void setBlank_account_holder(String blank_account_holder) {
        this.blank_account_holder = blank_account_holder;
    }

    public String getBlank_cnaps() {
        return blank_cnaps;
    }

    public void setBlank_cnaps(String blank_cnaps) {
        this.blank_cnaps = blank_cnaps;
    }

    public String getBlank_name() {
        return blank_name;
    }

    public void setBlank_name(String blank_name) {
        this.blank_name = blank_name;
    }

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
