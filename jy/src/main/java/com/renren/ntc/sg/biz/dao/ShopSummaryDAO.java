package com.renren.ntc.sg.biz.dao;

import java.util.Date;
import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.Address;
import com.renren.ntc.sg.bean.ShopSummary;

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
public interface ShopSummaryDAO {
    static final String TABLE_NAME= "shop_summary";
    static final String FIELDS = "id,shop_id,order_count,order_price,pay_status,create_time" ;
    static final String INSERT_FIELDS = "shop_id,order_count,order_price,pay_status,create_time" ;

    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where shop_id in(:1) order by create_time desc limit :2,:3")
    public List<ShopSummary> getShopSummaryByShopId(List<Long> ids, int start, int offset);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where create_time between :1 and :2 order by create_time desc limit :3,:4")
    public List<ShopSummary> getShopSummaryByDate(String beginTime,String endTime, int start, int offset);

    @ReturnGeneratedKeys
    @SQL("insert into  "  + TABLE_NAME + "(" + INSERT_FIELDS  +") values (:1.shop_id,:1.order_count,:1.order_price,:1.pay_status,:2)")
    public int  addShopSummary(ShopSummary shopSummary,String createTime);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where shop_id =:1 and create_time between :2 and :3 order by create_time asc limit 1")
    public ShopSummary getShopSummaryByCondition(long id,String beginTime,String endTime);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + " order by create_time desc,shop_id asc limit :1,:2")
    public List<ShopSummary> getShopSummaryByCondition(int start, int offset);
    
    @SQL("update " + TABLE_NAME + " set pay_status=1 where id = :1")
    public int updateShopPayByCondition(long id);

    @SQL("select "+FIELDS+" from " + TABLE_NAME + " where pay_status=0 and create_time between :1 and :2 ")
    public List<ShopSummary> getNotPayByDate(String beginTime,String endTime);

    @SQL("select "+FIELDS+" from " + TABLE_NAME + " where pay_status=0 and create_time between :1 and :2 ")
    public List<ShopSummary> getNotPayByDate(Date beginTime,Date endTime);

    @SQL("update " + TABLE_NAME + " set pay_status=1 where id in (:1)")
    public int updateShopPayByIds(List<Long> ids);

}
