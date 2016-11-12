package com.renren.ntc.sg.biz.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.renren.ntc.sg.bean.Order;

/*
CREATE TABLE `items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `shop_id` bigint(20) NOT NULL DEFAULT 0 ,
  `name` varchar(24) NOT NULL DEFAULT '' ,
  `count` int(11) NOT NULL DEFAULT 0 ,
  `head_url` varchar(256) NOT NULL DEFAULT '' ,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   KEY shop_id(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


 */


@DAO(catalog = "ABC")
public interface ProcessOrdersDAO {

	static final String TABLE_NAME= "process_order";
    static final String FIELDS = "id, order_id,readed,shop_id,user_id,address_id,remarks ,act,msg,info ,snapshot,status,price,create_time,update_time,order_status,order_info,user_confirm_time,receive_code,user_device_id" ;
    static final String INSERT_FIELDS = "order_id,readed,shop_id,user_id,address_id,remarks ,act,msg,info ,snapshot,status,price,create_time,update_time,order_status,order_info,user_confirm_time,receive_code,user_device_id" ;


    @SQL("insert into  " + TABLE_NAME +" (" + INSERT_FIELDS + ") values(:1.order_id,:1.readed,:1.shop_id," +
            ":1.user_id,:1.address_id,:1.remarks,:1.act ,:1.msg,:1.info,:1.snapshot,:1.status,:1.price,:1.create_time,:1.update_time,:1.order_status,:1.order_info,:1.user_confirm_time,:1.receive_code,:1.user_device_id)  ")
    public int insert(Order o);

    @SQL("update " + TABLE_NAME + " set order_info =:2 ,order_status =:3, update_time=now(),user_confirm_time =:4 where order_id = :1 ")
    public int updateOrderStatus(String order_id, String orderInfo, int orderStatus, String userConfirmTime, @SQLParam("tableName") String tableName);

    @SQL("update " + TABLE_NAME + " set order_info =:2 ,order_status =:3, update_time=now() where order_id = :1 ")
    public int updateOrderStatus(String order_id, String orderInfo, int orderStatus, @SQLParam("tableName") String tableName);

    @SQL("update " + TABLE_NAME + " set order_info =:2 ,update_time=now() where order_id = :1 ")
    public int updateOrderInfo(String order_id, String orderInfo, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "   where ( status =1 or status = 2) and order_status=0 and create_time <= date_sub(now(), interval 5 MINUTE) order by create_time asc limit :1,:2")
    public List<Order> getBossNotConfirmOrderyShop(int start, int offset, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where ( status =1 or status = 2) and order_status=1 and create_time <= date_sub(now(), interval 30 MINUTE) order by create_time desc limit :1,:2")
    public List<Order> getNotUserConfirmOrderyShop(int start, int offset, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "   where ( status =1 or status = 2) and (order_status=2 or order_status=3) and create_time between :1 and :2 order by create_time asc limit :3,:4")
    public List<Order> getCancelOrderyShop(String beginTime, String endTime, int start, int offset, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "   where  ( status =1 or status = 2) and (order_status =0 or order_status=1) and create_time between :1 and :2 order by create_time asc limit :3,:4")
    public List<Order> getRemindOrderyShop(String beginTime, String endTime, int start, int offset, @SQLParam("tableName") String tableName);

    @SQL("update " + TABLE_NAME + "  set status=:1 where order_id = :2 ")
    public void paydone(int status, String order_id);

    @SQL("update " + TABLE_NAME + "  set status=:1 where order_id = :2 ")
    public void updateStatus(int status, String order_id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "   where act = 'wx' and ( status =1 or status = 2) and order_status=1 and create_time between :1 and :2 order by create_time asc")
    public List<Order> getDeliverOrderyShop(String beginDate, String endDate);

    @SQL("update " + TABLE_NAME +"  set user_id =:2,user_device_id=-1 where user_device_id = :1 ")
    public int bindOrderToUser(long userDeviceId, long  userId);

    @SQL("update " + TABLE_NAME + " set order_status =:3, update_time=now() where order_id = :2 and shop_id = :1 ")
    public int updateOrderStatus(long shop_id, String order_id, int orderStatus);

    @SQL("SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE order_id =:1")
    Order getByOrderId(String order_id);

    //总订单
    @SQL("SELECT count(id)  FROM " + TABLE_NAME + " WHERE shop_id IN (:shop_ids) AND create_time between :2 AND :3")
    int getOrderCountByShopId(@SQLParam("shop_ids") List<Long> shop_ids, String startDate, String endDate);

    //有效订单
    @SQL("SELECT count(id)  FROM " + TABLE_NAME + " WHERE status IN(1,2) AND order_status NOT IN (2,3,5) AND shop_id IN (:shop_ids) AND create_time between :2 AND :3")
    int getValidOrderCountByShopId(@SQLParam("shop_ids") List<Long> shop_ids, String startDate, String endDate);

    //总用户数
    @SQL("SELECT COUNT(DISTINCT (user_id)) FROM " + TABLE_NAME + " WHERE shop_id IN (:shop_ids) AND create_time between :2 AND :3")
    int getUserCountByShopId(@SQLParam("shop_ids") List<Long> shop_ids, String startDate, String endDate);

    //有效订单
    @SQL("SELECT count(id)  FROM " + TABLE_NAME + " WHERE status IN(1,2) AND order_status NOT IN (2,3,5) AND create_time between :1 AND :1")
    int getValidOrderCount(String startDate, String endDate);
}
