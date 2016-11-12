package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.ShopArea;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import java.util.Date;
import java.util.List;

@DAO(catalog = "ABC")
public interface ShopAreaDAO {
    static final String TABLE_NAME = "shop_area";
    static final String FIELDS = "id, shop_id,area_name,max_lat, min_lat,max_lng,min_lng,create_time,update_time";
    static final String INSERT_FIELDS = "shop_id,area_name,max_lat, min_lat,max_lng,min_lng";


    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where shop_id=:1")
    public List<ShopArea> getShopArea(long shop_id);

    @SQL("insert into " + TABLE_NAME + "(" + INSERT_FIELDS + ") values  " +
            "(:1.shop_id,:1.area_name,:1.max_lat, :1.min_lat,:1.max_lng,:1.min_lng) ")
    public int insert(ShopArea shopArea);

    @SQL("update " + TABLE_NAME + " set ##(:key) = :2, update_time = :3 where id =:4")
    public int update(@SQLParam("key") String key, String value, Date date, long id);

    @SQL("DELETE FROM  " + TABLE_NAME + "  WHERE id=:1")
    public int del(long sa_id);
    /**
     * 根据 坐标查找所在区域
     *
     * @param lat
     * @param lng
     * @return
     */
    @SQL("SELECT " + FIELDS + " FROM  shop_area WHERE ( :1 BETWEEN min_lat AND max_lat)  AND ( :2 BETWEEN min_lng AND max_lng)")
    public ShopArea getByLatAndLng(double lat, double lng);

    /**
     * 查询列表 可以携带查询参数( area_name  shop_id)
     *
     * @param value
     * @param from
     * @param offset
     * @return
     */
    @SQL("SELECT " + FIELDS + " FROM  shop_area WHERE area_name like :1 or shop_id =:1 limit :2,:3")
    public List<ShopArea> getByQuery(String value, int from, int offset);


}
