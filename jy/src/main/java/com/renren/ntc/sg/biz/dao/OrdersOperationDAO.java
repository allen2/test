package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.OrdersOperation;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import java.util.Date;

/**
 * Created by ZhaoXiuFei on 2015/5/27 11:50.
 */
@DAO(catalog = "ABC")
public interface OrdersOperationDAO {
    String TABLE_NAME = "orders_operation";
    String FIELDS = "id,shop_id,order_id,user_id,order_time,confirm_deliver_time,order_done_time,reminder_remark,reminder_time,cancel_remark,cancel_time,transfer_remark,transfer_time,complaint_remark,complaint_time";
    String INSERT_FIELDS = "shop_id,order_id,user_id,order_time,confirm_deliver_time,order_done_time,reminder_remark,reminder_time,cancel_remark,cancel_time,transfer_remark,transfer_time,complaint_remark,complaint_time";

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE_NAME + " (" + INSERT_FIELDS + " ) values (:1.shop_id,:1.order_id,:1.user_id,:1.order_time,:1.confirm_deliver_time,:1.order_done_time,:1.reminder_remark,:1.reminder_time,:1.cancel_remark,:1.cancel_time,:1.transfer_remark,:1.transfer_time,:1.complaint_remark,:1.complaint_time) ")
    long insert(OrdersOperation ordersOperation);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + " where shop_id = :1 and order_id = :2")
    OrdersOperation get(long shop_id, String order_id);

    @SQL("update " + TABLE_NAME + " set ##(:key) = now()  where shop_id = :2 and order_id=:3")
    int update(@SQLParam("key") String key, long shop_id, String order_id);

    @SQL("update " + TABLE_NAME + " set ##(:key) = now()  where shop_id = :2 and order_id=:3")
    int setDateTime(@SQLParam("key") String key, long shop_id, String order_id);

    @SQL("update " + TABLE_NAME + " set ##(:remark_key) = :2 , ##(:time_key) = now() where shop_id = :4 and order_id=:5")
    int updateMarkAndTime(@SQLParam("remark_key") String remark_key, String value, @SQLParam("time_key") String time_key, long shop_id, String order_id);

}
