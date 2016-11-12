package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.Query;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by ZhaoXiuFei on 2015/5/7 9:57.
 */
@DAO(catalog = "ABC")
public interface QueryDAO {

        /**
         * 查询商店详细信息(商店ID	  区域	状态	责任BD	BD电话	商店名称	 商店电话	商店老板	 老板电话	服务范围 	商店地址)
         * @param value
         * @param from
         * @param offset
         * @return
         */
    @SQL("SELECT " +
            "s.id AS sField0, " +
            "s.name AS sField1, " +
            "b.name AS sField2, " +
            "s.owner_phone AS sField3, " +
            "s.tel AS sField4, " +
            "s.shop_address AS sField5, " +
            "s.audit AS sField6, " +
            "csc.name AS sField7, " +
            "csc.phone AS sField8, " +
            "csc.shop_area AS sField9, " +
            "s.shop_info AS sField10 " +
            "FROM " +
            "shop AS s " +
            "JOIN boss AS b ON b.shop_id = s.id " +
            "JOIN catstaff_commit AS csc ON csc.shop_id = s.id " +
            "WHERE " +
            "s.name LIKE :1  " +
            "OR csc.name LIKE :1  " +
            "OR csc.shop_area LIKE :1  " +
            "OR s.shop_info LIKE :1  " +
            "ORDER BY " +
            "sField10 ASC, " +
            "sField7 ASC " +
            "LIMIT :2, :3")
    public List<Query> getShopInfoByQuery(String value, int from, int offset);



    @SQL("SELECT " +
            "oo.id AS sField0, " +
            "s.name AS sField1, " +
            "c.name AS sField2, " +
            "oo.order_id AS sField3, " +
            "oo.order_time AS sField4, " +
            "oo.confirm_deliver_time AS sField5, " +
            "oo.order_done_time AS sField6, " +
            "oo.reminder_remark AS sField7, " +
            "oo.reminder_time AS sField8, " +
            "oo.cancel_remark AS sField9, " +
            "oo.cancel_time AS sField10, " +
            "oo.transfer_remark AS sField11, " +
            "oo.transfer_time AS sField12, " +
            "oo.complaint_remark AS sField13, " +
            "oo.complaint_time AS sField14 " +
            "FROM orders_operation AS oo " +
            "JOIN shop AS s ON s.id = oo.shop_id " +
            "JOIN catstaff AS c ON c.id = oo.user_id " +
            "ORDER BY sField0 DESC " +
            "LIMIT :1, :2")
    List<Query> getOrdersOperation(int from, int offset);
    @SQL("SELECT " +
            "oo.id AS sField0, " +
            "s.name AS sField1, " +
            "c.name AS sField2, " +
            "oo.order_id AS sField3, " +
            "oo.order_time AS sField4, " +
            "oo.confirm_deliver_time AS sField5, " +
            "oo.order_done_time AS sField6, " +
            "oo.reminder_remark AS sField7, " +
            "oo.reminder_time AS sField8, " +
            "oo.cancel_remark AS sField9, " +
            "oo.cancel_time AS sField10, " +
            "oo.transfer_remark AS sField11, " +
            "oo.transfer_time AS sField12, " +
            "oo.complaint_remark AS sField13, " +
            "oo.complaint_time AS sField14 " +
            "FROM orders_operation AS oo " +
            "JOIN shop AS s ON s.id = oo.shop_id " +
            "JOIN catstaff AS c ON c.id = oo.user_id " +
            "WHERE s.name Like :1 " +
            "ORDER BY sField1 ASC " +
            "LIMIT :2, :3")
    List<Query> getOrdersOperationByShop(String value, int from, int offset);

    String INSERT_FIELDS = "shop_id,,user_id,,,,,,,,,,,";
    @SQL("SELECT " +
            "oo.id AS sField0, " +
            "s.name AS sField1, " +
            "c.name AS sField2, " +
            "oo.order_id AS sField3, " +
            "oo.order_time AS sField4, " +
            "oo.confirm_deliver_time AS sField5, " +
            "oo.order_done_time AS sField6, " +
            "oo.reminder_remark AS sField7, " +
            "oo.reminder_time AS sField8, " +
            "oo.cancel_remark AS sField9, " +
            "oo.cancel_time AS sField10, " +
            "oo.transfer_remark AS sField11, " +
            "oo.transfer_time AS sField12, " +
            "oo.complaint_remark AS sField13, " +
            "oo.complaint_time AS sField14 " +
            "FROM orders_operation AS oo " +
            "JOIN shop AS s ON s.id = oo.shop_id " +
            "JOIN catstaff AS c ON c.id = oo.user_id " +
            "WHERE c.name Like :1 " +
            "ORDER BY sField2 ASC " +
            "LIMIT :2, :3")
    List<Query> getOrdersOperationByCatStaff(String value, int from, int offset);
}
