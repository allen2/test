package com.renren.ntc.sg.biz.dao;

import java.util.List;

import com.renren.ntc.sg.bean.Query;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.renren.ntc.sg.bean.Item;
import com.renren.ntc.sg.bean.Shop;

@DAO(catalog = "ABC")
public interface ShopDAO {
    static final String TABLE_NAME = "shop";
    static final String FIELDS = "id,owner, owner_user_id,base_price, name,open_time,close_time,shop_address,tel,owner_phone,head_url,shop_url,lng,lat,create_time,audit,status,shop_info,remark,ext";
    static final String INSERT_FIELDS = "owner_user_id,base_price,open_time,close_time,name,shop_address,tel,owner_phone,head_url,shop_url,shop_info,lng,lat";
    static final String SHOP_NAME_FIELDS = "id,name";
    static final int SHOP_NOT_ONLINE = 0;

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  lat < :1 and lat > :2 and lng < :3 and lng > :4")
    public List<Shop> getShop(double lat2, double lng1, double lng2);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  id = :1 ")
    public Shop getShop(long id);


    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  owner_user_id = :1 ")
    public Shop getShopbyOwner_id(long id);

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE_NAME + "(" + INSERT_FIELDS + " ) values" + " (:1.owner_user_id,:1.base_price," +
            ":1.open_time,:1.close_time,:1.name," +
            ":1.shop_address,:1.tel,:1.owner_phone,:1.head_url,:1.shop_url,:1.shop_info,:1.lng,:1.lat)")
    public int insert(Shop o);


    @SQL("update " + TABLE_NAME + "set  audit =1 where id = :1")
    public int audit(long shop_id);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where audit = 1  limit :1,:2")
    public List<Shop> getAuditedShops(int from, int offset);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where audit = 1 and id in (:1)")
    public List<Shop> getAuditedShops(List<Long> ids);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " limit :1,:2")
    public List<Shop> getAllShops(int from, int offset);

    @SQL("select " + SHOP_NAME_FIELDS + "  from " + TABLE_NAME + " where audit = :1 order by name")
    public List<Shop> getAllShopsByAudit(int audit);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where audit = :1")
    public List<Shop> getAllShopsAllFieldsByAudit(int audit);

    @SQL("update " + TABLE_NAME + " set ##(:key) = :3  where id =:1")
    public int update(long id, @SQLParam("key") String key, String value);

    @SQL("update " + TABLE_NAME + " set name = :2,tel = :3,open_time = :4" +
            ",close_time = :5" +
            ",shop_address = :6," +
            "shop_info = :7,status = :8,base_price = :9,owner_phone = :10 where id =:1")
    public int updateShopDetail(long id, String name, String tel, String open_time, String close_time,
                                String shop_address, String shopInfo, int status, int basePrice, String ownerPhone);


    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where id in (:shop_ids)")
    public List<Shop> getShops(@SQLParam("shop_ids") List<Long> shop_ids);


    /**
     * 获取未上线的商店 id name
     * zhaoxiufei
     *
     * @return
     */
    @SQL("select " + SHOP_NAME_FIELDS + "  from " + TABLE_NAME + " where audit =" + SHOP_NOT_ONLINE)
    public List<Shop> getAllShopsByNotOnline();
    /**
     * 获取未上线的商店 id name
     * zhaoxiufei
     *
     * @return
     */
    @SQL("select " + SHOP_NAME_FIELDS + "  from " + TABLE_NAME + " where audit =" + SHOP_NOT_ONLINE +" and id = :1")
    public Shop getShopByNotOnline(long shop_id);

    /**
     * 获取商店 id name
     * zhaoxiufei
     *
     * @return
     */
    @SQL("select " + SHOP_NAME_FIELDS + "  from " + TABLE_NAME + " where id = :1")
    public Shop getShopById(long shop_id);

    /**
     * advQuery
     * zhaoxiufei
     *
     * @return
     */
    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  name like :1  or tel like :1")
    public List<Shop> getShops(String text);

    /**
     * zhaoxiufei
     * @return
     */
    @SQL("select " + FIELDS + "  from " + TABLE_NAME)
    public List<Shop> getAllShops();

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where audit = :1")
    public List<Shop> getAllShopsInfoByAudit(int audit);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  name like :1 and audit = :2")
    public List<Shop> getShopsByName(String name,int audit);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + " where name like :1 order by name asc limit :2 , :3")
    public List<Shop> getShopByQuery(String key, int from, int offset);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  id = :1 ")
    public Query getShopToQuery(long id);

    @SQL("select " + FIELDS + "  from " + TABLE_NAME + " where  id in (:1)")
    public List<Shop> getShopsbyids(List<Long> shop_ids);
    @SQL("SELECT name FROM " + TABLE_NAME + " WHERE id=:1")
    String getName(long id);

    @SQL("SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE audit =1 AND (lng between :1 and :2) and (lat between :3 and :4)")
    List<Shop> getShopByPoint(String bssw_lng, String bsne_lng, String bssw_lat, String bsne_lat);
}
