package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.Privilege;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import java.util.Date;
import java.util.List;

@DAO(catalog = "ABC")
public interface PrivilegeDAO {

    static final String TABLE_NAME = "privilege";
    static final String FIELDS = "id, name, menu_url, create_time, update_time, mark";
    static final String INSERT_FIELDS = "name, menu_url,create_time,update_time, mark";


    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where id =:1")
    public Privilege getPrivilege(long id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  order by menu_url desc  limit :1,:2")
    public List<Privilege> getPrivileges(int start, int offset);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  order by menu_url ")
    public List<Privilege> getAll();

    @ReturnGeneratedKeys
    @SQL("insert into  " + TABLE_NAME + "(" + INSERT_FIELDS + ") values (:1.name,:1.menu_url,:1.create_time,:1.update_time,:1.mark )")
    public long addPrivilege(Privilege privilege);

    @SQL("update  " + TABLE_NAME + " set name=:1.name,menu_url= :1.menu_url,update_time =:1.update_time, desc = :1.desc" + " where id = :1.id")
    public int updatePrivilege(Privilege privilege);

    @SQL("delete from " + TABLE_NAME + " where id = :1 ")
    public int delPrivilege(long privilege_id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where id in(:privilege_ids) order by menu_url ")
    public List<Privilege> getPrivilegeByIds(@SQLParam("privilege_ids") List<Long> privilege_ids);

    /**
     * 查询列表 可以携带查询参数( area_name  shop_id)
     *
     * @param value
     * @param from
     * @param offset
     * @return
     */
    @SQL("SELECT " + FIELDS + " FROM  " + TABLE_NAME + " WHERE name like :1  or menu_url like :1 limit :2,:3")
    public List<Privilege> getByQuery(String value, int from, int offset);

    /**
     * @param key
     * @param value
     * @param date
     * @param id
     * @return
     */
    @SQL("update " + TABLE_NAME + " set ##(:key) = :2, update_time = :3 where id =:4")
    public int update(@SQLParam("key") String key, String value, Date date, long id);

    @SQL("SELECT " + FIELDS + " FROM  " + TABLE_NAME + " WHERE menu_url =:1")
    public List<Privilege> getByName(String s);
}
