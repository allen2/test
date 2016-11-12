package com.renren.ntc.sg.biz.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.ShopGetCashDetail;

@DAO(catalog = "ABC")
public interface ShopCashDAO {
		static final String TABLE_NAME= "shop_cash";
	    static final String FIELDS = "id,create_time,operate_time,cash_type,price,shop_id,status" ;
	    static final String INSERT_FIELDS = "create_time,operate_time,cash_type,price,shop_id,status" ;

	    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where shop_id = :1 and create_time between :2 and :3 order by create_time desc")
	    public List<ShopGetCashDetail> getShopCashList(long id,String beginDate,String endDate);
	    
	    @SQL("insert into  " + TABLE_NAME + " (" + INSERT_FIELDS +") values(now(),now(),:1.cash_type," +
	            ":1.price,:1.shop_id,:1.status)  ")
	    public Integer insert(ShopGetCashDetail shopGetCashDetail);
	    
	    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where shop_id = :1 and create_time between :2 and :3 and cash_type=:4")
	    public List<ShopGetCashDetail> getShopCashList(long id,String beginDate,String endDate,int cashType);
	    
	    @SQL("select sum(price) from " + TABLE_NAME + "  where shop_id = :1 and cash_type=:2")
	    public Integer getAllShopCashPrice(long id,int cashType);
	    
	    @SQL("update " + TABLE_NAME + " set status = 1 where status = 0 and create_time between :2 and :3")
	    public Integer updateShopCashPayStatus(int status,String beginTime,String endTime);
	    
	    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where create_time between :1 and :2 and cash_type=0")
	    public List<ShopGetCashDetail> getCashListByTake(String beginDate,String endDate);
	    
	    @SQL("insert into  " + TABLE_NAME + " (" + INSERT_FIELDS +") values(:2,:2,:1.cash_type," +
	            ":1.price,:1.shop_id,:1.status)  ")
	    public Integer insert(ShopGetCashDetail shopGetCashDetail,String createTime);
	    
	    @SQL("update " + TABLE_NAME + " set status = 1 where status = 0 and id in (:1)")
	    public Integer updateShopCashPayStatus(List<Long> ids);
	    
	    @SQL("update " + TABLE_NAME + " set status = 1 where status = 0 and id = :1")
	    public Integer updateShopCashPayStatus(Long id);

}
