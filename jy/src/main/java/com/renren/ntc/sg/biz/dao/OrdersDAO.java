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
public interface OrdersDAO {
    static final String FIELDS = "id, order_id,readed,shop_id,user_id,address_id,remarks ,act,msg,info ,snapshot,status,price,create_time,update_time,order_status,order_info,user_confirm_time,receive_code,user_device_id";
    static final String INSERT_FIELDS = " order_id,readed,shop_id,user_id,address_id,remarks ,act, info,snapshot,status,price,user_device_id";

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:1 and ( status =1 or status = 2) order by create_time desc limit :2,:3")
    public List<Order> getOrderByShop(long shop_id, int start, int offset, @SQLParam("tableName") String tableName);


    @SQL("insert into  ##(:tableName) (" + INSERT_FIELDS + ") values(:1.order_id,:1.readed,:1.shop_id," +
            ":1.user_id,:1.address_id,:1.remarks,:1.act ,:1.info,:1.snapshot,:1.status,:1.price,:1.user_device_id)  ")
    public int insertUpdate(Order o, @SQLParam("tableName") String tableName);


    @SQL("insert into  ##(:tableName) (" + INSERT_FIELDS  + ",order_status,order_info,user_confirm_time) values(:1.order_id,:1.readed,:1.shop_id," +
            ":1.user_id,:1.address_id,:1.remarks,:1.act ,:1.info,:1.snapshot,:1.status,:1.price,:1.user_device_id," +
            ":1.order_status,:1.order_info,:1.user_confirm_time)  ")
    public int insertFull(Order o, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)  where shop_id =:1 and status = 1 ")
    public List<Order> getOrder2Print(long shop_id, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)  where shop_id =:1 and (status =1 or status = 2) and order_status not in (2,3,5)")
    public List<Order> getFinalOrder(long shop_id, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)  where shop_id =:1 and ( status =1 or status = 2) order by create_time desc limit :2,:3 ")
    List<Order> get10Orders(long shop_id, int from, int offset, @SQLParam("tableName") String tableName);


    @SQL("update ##(:tableName)   set status=:1 where order_id = :2 ")
    int update(int i, String orderId, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)  where order_id =:1 ")
    public Order getOrder(String orderId, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)  where create_time >= :1 and create_time < :2 and (status =1 or status = 2) and order_status not in (2,3,5)")
    public List<Order> getOrder(String beginTime, String endTime, @SQLParam("tableName") String tableName);

    @SQL("update ##(:tableName)   set readed=1 where order_id=:2")
    public int read(@SQLParam("tableName") String tableName, String order_id);

    @SQL("update ##(:tableName)  set status=:1 where order_id = :2 ")
    public void paydone(int status, String order_id, @SQLParam("tableName") String tableName);

    @SQL("update ##(:tableName)  set pre_id =:2 , act =:3 where order_id = :1 ")
    public void updateWXPay(String order_id, String pre_id, String act, @SQLParam("tableName") String tableName);

    @SQL("update ##(:tableName)   set msg =:2 , update_time=now() where order_id = :1 ")
    public void confirm(String order_id, String msg, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and create_time between :3 and :4")
    List<Order> getShopPayDetail(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

    @SQL("select " + FIELDS + " from ##(:tableName)  where shop_id =:4 and (status = 1 or status =2) and create_time between :1 and :2 order by create_time")
    public List<Order> getRealOrder(String beginTime, String endTime, @SQLParam("tableName") String tableName, long shopId);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' order by create_time desc")
    List<Order> getAllWxOrders(@SQLParam("tableName") String tableName, long shopId);

    @SQL("select " + FIELDS + " from ##(:tableName)  where shop_id =:2 and (status !=1 and status !=2 ) order by create_time desc limit :3,:4 ")
    List<Order> getUnfinishedOrders(@SQLParam("tableName") String tableName, long shop_id, int from, int offset);

    @SQL("update ##(:tableName)  set order_status =:3 , order_info =:4 where id = :1 and shop_id=:2")
    public int updateWXRefund(long order_id, long shopId, int refundStatus, String refundInfo, @SQLParam("tableName") String tableName);

    @SQL("update ##(:tableName) set order_info =:2 ,order_status =:3, update_time=now() where order_id = :1 ")
    public int updateOrderStatus(String order_id, String orderInfo, int orderStatus, @SQLParam("tableName") String tableName);

    @SQL("update ##(:tableName) set order_status =:2, update_time=now() where order_id = :1 ")
    public int updateOrderStatus(String order_id, int orderStatus, @SQLParam("tableName") String tableName);

    @SQL("update ##(:tableName) set order_info =:2 ,update_time=now() where order_id = :1 ")
    public int updateOrderInfo(String order_id, String orderInfo, @SQLParam("tableName") String tableName);

    /**
     * @param tableName
     * @param phone
     * @return
     */
    @SQL("select " + FIELDS + " from ##(:tableName)   where address_id in ( SELECT id FROM address WHERE phone = :2) order by create_time desc")
    public List<Order> getByPhone(@SQLParam("tableName") String tableName, String phone);

    @SQL("select " + FIELDS + " from ##(:tableName)   where order_id = :2")
    public Order getByOrderId(@SQLParam("tableName") String tableName, String order_id);

    @SQL("select " + FIELDS + " from ##(:tableName) where (status = 1 or status= 2) and shop_id=:2 and create_time > date_sub(now(), interval 1 hour);")
    List<Order> getOrderbyTime(@SQLParam("tableName") String tableName, long shop_id);

    @SQL("update ##(:tableName) set order_info =:2 ,order_status =:3, update_time=now(),user_confirm_time =:4 where order_id = :1 ")
    public int updateOrderStatus(String order_id, String orderInfo, int orderStatus, String userConfirmTime, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and ((order_status = 4 and user_confirm_time between :3 and :4) or (order_status=5 and create_time between :3 and :4)) ")
    List<Order> getShopPayDetailByWXCondition(@SQLParam("tableName") String tableName, long shopId, String confirmBeginTime, String confirmEndTime);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and order_status = 4 and user_confirm_time between :3 and :4 ")
    List<Order> getUserConfirmShopDetailByWXCondition(@SQLParam("tableName") String tableName, long shopId, String confirmBeginTime, String confirmEndTime);

    @SQL("select " + FIELDS + " from ##(:tableName)  where shop_id =:2 and (status !=1 and status !=2 ) and act = 'wx' and create_time between :3 and :4")
    List<Order> getWxUnfinishedOrders(@SQLParam("tableName") String tableName, long shop_id, String beginTime, String endTime);

    @SQL("select " + FIELDS + " from ##(:tableName)  where order_status=:2 and shop_id =:1 and ( status =1 or status = 2) order by create_time desc limit :3,:4 ")
    List<Order> get10OrdersByType(long shop_id, int type, int from, int offset, @SQLParam("tableName") String tableName);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and ((create_time between :3 and :4) or (order_status = 4 and user_confirm_time between :3 and :4))")
    List<Order> getWXReportDetailByWXCondition(@SQLParam("tableName") String tableName, long shopId, String confirmBeginTime, String confirmEndTime);

    @SQL("select sum(price) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and create_time between  :3 and :4")
    Integer getWXReportTotalPriceByWXCondition(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and create_time between  :3 and :4")
    List<Order> getWXReportByWXCondition(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

    @SQL("select sum(price) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and order_status =4 and user_confirm_time between  :3 and :4")
    Integer getWXReportUConfirmTotalPriceByWXCondition(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

    @SQL("select sum(price) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and create_time between  :3 and :4 and order_status=5")
    Integer getWXReportCancelByWXCondition(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and create_time between  :3 and :4 and order_status=5")
    List<Order> getWXReportCancelDetailByWXCondition(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

    @SQL("select " + FIELDS + " from ##(:tableName)  where order_status in (2,3,5) and shop_id =:1 and ( status =1 or status = 2) order by create_time desc limit :3,:4 ")
    List<Order> get10OrdersByTypeCancel(long shop_id, int order_status, int from, int offset, @SQLParam("tableName") String tableName);
    
    @SQL("select sum(price) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and (order_status = 4 and user_confirm_time between :3 and :4)")
    Integer getBossDailySumPriceByWXCondition(@SQLParam("tableName") String tableName,long shopId,String confirmBeginTime,String confirmEndTime);
    
    @SQL("select count(1) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and (order_status = 4 and user_confirm_time between :3 and :4)")
    Integer getBossDailyOrderCountByWXCondition(@SQLParam("tableName") String tableName,long shopId,String confirmBeginTime,String confirmEndTime);
    
    @SQL("select sum(price) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and ((create_time between :3 and now()) and order_status in (0,1))")
    Integer getBossDailyNotSettleSumPriceByWXCondition(@SQLParam("tableName") String tableName,long shopId,String beginTime);
    
    @SQL("select count(1) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and ((create_time between :3 and now()) and order_status in (0,1))")
    Integer getBossDailyNotSettleCountByWXCondition(@SQLParam("tableName") String tableName,long shopId,String beginTime);
    
    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and ((create_time between :3 and now()) and order_status in (0,1)) order by create_time desc limit :4,:5")
    List<Order> getBossDailyNotSettlesByWXCondition(@SQLParam("tableName") String tableName,long shopId,String beginTime,int from,int offset);
    
    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and (order_status = 4 and user_confirm_time between :3 and :4) order by create_time desc limit :5,:6")
    List<Order> getBossDailyOrderDetailByWXCondition(@SQLParam("tableName") String tableName,long shopId,String confirmBeginTime,String confirmEndTime,int from,int offset);
    
    @SQL("select " + FIELDS + " from ##(:tableName) where shop_id =:2 and ( status =1 or status = 2) and create_time between :3 and :4 ") 

    List<Order> getAllByBeforeOneDate(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);
    
    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and (create_time between :3  and :4) and order_status =4")
    List<Order> getUserConfirmOrdersByWXCondition(@SQLParam("tableName") String tableName,long shopId,String confirmBeginTime,String confirmEndTime);
    
    @SQL("update ##(:tableName)  set user_confirm_time =:4 where shop_id=:2 and order_id=:3")
    int updateUserConfirmTimeByCondition(@SQLParam("tableName") String tableName,long shopId,String orderId,String confirmTime);
    
    @SQL("update ##(:tableName)  set pre_id =:2 , act =:3,receive_code =:4 where order_id = :1 ")
    public void updateWXPayDetail(String order_id, String pre_id, String act,String receiveCode, @SQLParam("tableName") String tableName);
    
    
    @SQL("select " + FIELDS + " from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and order_status = 5 and update_time between :3 and :4")
    List<Order> getWXCancelReportDetailByWXCondition(@SQLParam("tableName") String tableName, long shopId, String updateBeginTime, String updateEndTime);

    @SQL("update ##(:tableName) set user_id =:2,user_device_id=-1 where user_device_id = :1 ")
    public int bindOrderToUser(long userDeviceId, long  userId, @SQLParam("tableName") String tableName);
    
    @SQL("update ##(:tableName)   set act =:2,status=:3 where order_id = :1 ")
    public int updateActByOrderId(String order_id, String act,int status, @SQLParam("tableName") String tableName);

    @SQL("select sum(price) from ##(:tableName)   where shop_id =:2 and act = 'wx' and (status = 1 or status =2) and (order_status = 4 and user_confirm_time between :3 and :4)")
    Integer getShopWallet(@SQLParam("tableName") String tableName, long shopId, String beginTime, String endTime);

}
