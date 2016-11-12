package com.renren.ntc.sg.bean;

import java.util.Date;

public class OrdersOperation {
    private long id;
    private long shop_id;
    private String order_id;
    private long user_id;//操作人员
    private Date order_time; //订单时间
    private Date confirm_deliver_time;//确认配送时间
    private Date order_done_time;//订单完成时间
    private String reminder_remark;//催单备注
    private Date reminder_time;
    private String cancel_remark;//取消订单备注
    private Date cancel_time;
    private String transfer_remark;//转单备注
    private Date transfer_time;
    private String complaint_remark;//投诉备注
    private Date complaint_time;

    public Date getOrder_done_time() {
        return order_done_time;
    }

    public void setOrder_done_time(Date order_done_time) {
        this.order_done_time = order_done_time;
    }

    public Date getConfirm_deliver_time() {
        return confirm_deliver_time;
    }

    public void setConfirm_deliver_time(Date confirm_deliver_time) {
        this.confirm_deliver_time = confirm_deliver_time;
    }

    public String getCancel_remark() {
        return cancel_remark;
    }

    public void setCancel_remark(String cancel_remark) {
        this.cancel_remark = cancel_remark;
    }

    public Date getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(Date cancel_time) {
        this.cancel_time = cancel_time;
    }

    public String getComplaint_remark() {
        return complaint_remark;
    }

    public void setComplaint_remark(String complaint_remark) {
        this.complaint_remark = complaint_remark;
    }

    public Date getComplaint_time() {
        return complaint_time;
    }

    public void setComplaint_time(Date complaint_time) {
        this.complaint_time = complaint_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getReminder_remark() {
        return reminder_remark;
    }

    public void setReminder_remark(String reminder_remark) {
        this.reminder_remark = reminder_remark;
    }

    public Date getReminder_time() {
        return reminder_time;
    }

    public void setReminder_time(Date reminder_time) {
        this.reminder_time = reminder_time;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getTransfer_remark() {
        return transfer_remark;
    }

    public void setTransfer_remark(String transfer_remark) {
        this.transfer_remark = transfer_remark;
    }

    public Date getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(Date transfer_time) {
        this.transfer_time = transfer_time;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
