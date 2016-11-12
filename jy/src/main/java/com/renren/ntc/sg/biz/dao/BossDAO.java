package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.Query;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.Boss;
import net.paoding.rose.jade.annotation.SQLParam;

import java.util.List;

@DAO(catalog = "ABC")
public interface BossDAO {
    static final String TABLE_NAME = "boss";
    static final String FIELDS = "id,shop_id,name,wx_open_id,blank_name,blank_account,blank_account_holder,blank_cnaps";
    static final String INSERT_FIELDS = "shop_id,name";

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where shop_id =:1")
    public Boss getBoss(long shop_id);

    @SQL("update " + TABLE_NAME + " set ##(:key) = :3  where shop_id =:1")
    public int update(long id, @SQLParam("key") String key, String value);

    @ReturnGeneratedKeys
    @SQL("insert into  " + TABLE_NAME + "(" + INSERT_FIELDS + ") values (:1.shop_id,:1.name)")
    public int addBoss(Boss boss);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where name =:1")
    public Boss getBossByName(String name);//有可能重复 暂时不考虑

    //@SQL("select " + FIELDS + " from " + TABLE_NAME + " where  name like :1 or blank_name like :1 or blank_account like :1 or blank_account_holder like :1 or blank_cnaps like :1 or wx_open_id like :1 order by id asc limit :2 , :3")
    @SQL("SELECT " +
            "b.id AS sField0, " +
            "b.shop_id AS sField1, " +
            "s.name AS sField2, " +
            "b.name AS sField3, " +
            "b.wx_open_id AS sField4, " +
            "b.blank_name AS sField5, " +
            "b.blank_account AS sField6, " +
            "b.blank_account_holder AS sField7, " +
            "b.blank_cnaps AS sField8 " +
            "FROM " +
            "boss AS b " +
            "JOIN shop AS s ON b.shop_id = s.id " +
            "WHERE " +
            "s.name LIKE :1  " +
            "OR b.name LIKE :1  " +
            "OR b.wx_open_id LIKE :1  " +
            "OR b.blank_name LIKE :1  " +
            "OR b.blank_account LIKE :1  " +
            "OR b.blank_account_holder LIKE :1  " +
            "OR b.blank_cnaps LIKE :1  " +
            "ORDER BY " +
            "sField2 ASC " +
            "LIMIT :2, :3")
    public List<Query> getBoss(String value, int start, int offset);

    @SQL("update " + TABLE_NAME + " set ##(:key) = :2  where id =:3")
    public int updateById(@SQLParam("key") String key, String value, long id);
}
