package com.renren.ntc.sg.bean;

import java.util.List;

/**
 * 每天每单订单我需要知道这些东西，每天给我和陆子禹发个报表
 * 用户下单时间
 * 确认配送
 * 商家确认 or 客服确认 （Y：商家确认；N：客服确认）
 * 确认收货
 * 用户确认 or 客服确认（Y：用户确认；N：客服确认）
 * 确认配送时长 ＝ 确认配送时间 - 下单时间
 * 到货时长 ＝ 确认收货时间 - 用户下单时间
 * 商家送货时长 ＝ 确认收货时间 - 确认配送时间
 * 店家名字
 * 店家编号
 * 店家区域
 * 店家电话
 * 店家座机
 * 店家责任BD
 * 订单编号
 * 订单价钱
 * 订单支付方式（W：微信支付；H：货到付款）
 * 订单代金券（10：使用10元代金券；5：使用5元代金券；0：未使用代金券）
 * 取消方式 Y商家取消 N客服取消
 * 订单是否取消(Y/N)
 * <p/>
 * <p/>
 * Created by ZhaoXiuFei on 2015/4/23 14:34.
 */
public class CatBossShopReportV2 {

    private long shopId; // shop_id店家编号
    private String shopName;//店家名称
    private String shopArea;//店家所属区域
    private String shopBossPhone;//店家手机
    private String shopTel;//店家座机
    private String dutyBD;//责任BD
    private List<Order> orders;//订单

    public CatBossShopReportV2() {
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getShopTel() {
        return shopTel;
    }


    public String getDutyBD() {
        return dutyBD;
    }

    public void setDutyBD(String dutyBD) {
        this.dutyBD = dutyBD;
    }

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getShopBossPhone() {
        return shopBossPhone;
    }

    public void setShopBossPhone(String shopBossPhone) {
        this.shopBossPhone = shopBossPhone;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
