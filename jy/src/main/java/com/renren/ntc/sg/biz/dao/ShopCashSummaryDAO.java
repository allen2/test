package com.renren.ntc.sg.biz.dao;

import java.util.Date;
import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.ShopCashSummary;

/*
CREATE TABLE shop_summary (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL DEFAULT '0',  
  `order_count` int(11) NOT NULL DEFAULT '0',
  `order_price` int(11) NOT NULL DEFAULT '0',  
  `pay_status` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),  
  KEY create_time (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


 */


@DAO(catalog = "ABC")
public interface ShopCashSummaryDAO {
    static final String TABLE_NAME= "shop_cash_summary";
    static final String FIELDS = "id,price,create_time,update_time,status,shop_id,shop_cash_id";
    static final String INSERT_FIELDS = "price,create_time,update_time,status,shop_id,shop_cash_id" ;

    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where shop_id in(:1) order by create_time desc limit :2,:3")
    public List<ShopCashSummary> getShopSummaryByShopId(List<Long> ids, int start, int offset);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where create_time between :1 and :2 order by create_time desc limit :3,:4")
    public List<ShopCashSummary> getShopSummaryByDate(String beginTime,String endTime, int start, int offset);

    @ReturnGeneratedKeys
    @SQL("insert into  "  + TABLE_NAME + "(" + INSERT_FIELDS  +") values (:1.price,:2,:2,:1.status,:1.shop_id,:1.shop_cash_id)")
    public int  addShopSummary(ShopCashSummary shopSummary,String createTime);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where shop_id =:1 and create_time between :2 and :3 order by create_time asc limit 1")
    public ShopCashSummary getShopSummaryByCondition(long id,String beginTime,String endTime);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + " order by create_time desc,shop_id asc limit :1,:2")
    public List<ShopCashSummary> getShopSummaryByCondition(int start, int offset);
    
    @SQL("update " + TABLE_NAME + " set status=1 where id = :1")
    public int updateShopPayByCondition(long id);

    @SQL("select "+FIELDS+" from " + TABLE_NAME + " where status=0 and create_time between :1 and :2 ")
    public List<ShopCashSummary> getNotPayByDate(String beginTime,String endTime);

    @SQL("select "+FIELDS+" from " + TABLE_NAME + " where status=0 and create_time between :1 and :2 ")
    public List<ShopCashSummary> getNotPayByDate(Date beginTime,Date endTime);

    @SQL("update " + TABLE_NAME + " set status=1 where id in (:1)")
    public int updateShopPayByIds(List<Long> ids);
    
    @SQL("select "+FIELDS+" from " + TABLE_NAME + " where id = :1 ")
    public ShopCashSummary getShopCashSummaryById(long id);

}
