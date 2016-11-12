package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.PayInfo;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import java.util.List;

/**
 * Created by ZhaoXiuFei on 2015/5/19 13:45.
 */
@DAO(catalog = "ABC")
public interface PayInfoDAO {

    String TABLE_NAME = "pay_info";
    String FIELDS = "id, shop_id,shop_name, wx_open_id, pay_id, re_user_name, payment_wx_no, pay_info, op, price, pay_status, create_time";
    String INSERT_FIELDS = "shop_id,shop_name,wx_open_id, pay_id, re_user_name, payment_wx_no, pay_info, op, price, pay_status";

    @ReturnGeneratedKeys
    @SQL("insert into  " + TABLE_NAME + "(" + INSERT_FIELDS + ") values (:1.shop_id,:1.shop_name,:1.wx_open_id,:1.pay_id,:1.re_user_name,:1.payment_wx_no,:1.pay_info,:1.op,:1.price,:1.pay_status)")
    public long insert(PayInfo payInfo);

    @SQL("SELECT " + FIELDS + " from " + TABLE_NAME + " where shop_name like :1 or re_user_name like :1 or pay_id like :1 or create_time like :1 or pay_status like :1 or wx_open_id like :1 or payment_wx_no like :1  ORDER BY id LIMIT :2,:3 ")
    List<PayInfo> getPayInfo(String value, int from, int offset);

    @SQL("delete from " + TABLE_NAME + " where create_time like :1")
    public int delByCreateTime(String create_time);

}
