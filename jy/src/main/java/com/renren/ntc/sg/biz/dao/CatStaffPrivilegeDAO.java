package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.CatStaffPrivilege;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

@DAO(catalog = "ABC")
public interface CatStaffPrivilegeDAO {

    static final String TABLE_NAME = "catstaff_privilege";
    static final String FIELDS = "id, catstaff_type, privilege_id ";
    static final String INSERT_FIELDS = "catstaff_type, privilege_id";

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where id =:1")
    public CatStaffPrivilege getCatStaffPrivilege(long id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where catstaff_type =:1 order by id desc  limit :2,:3")
    public List<CatStaffPrivilege> getCatStaffPrivileges(int catstaff_type, int start, int offset);

    @ReturnGeneratedKeys
    @SQL("insert into  " + TABLE_NAME + "(" + INSERT_FIELDS + ") values (:1.catstaff_type,:1.privilege_id)")
    public long addCatStaffPrivilege(CatStaffPrivilege catStaffPrivilege);

    @SQL("update  " + TABLE_NAME + " set catstaff_type=:1.catstaff_type,privilege_id= :1.privilege_id" + " where id = :1.id")
    public int updateCatStaffPrivilege(CatStaffPrivilege prcatStaffPrivilege);

    @SQL("del  " + TABLE_NAME + " where id = :1.id")
    public int delCatStaffPrivilege(long catStaffPrivilege_id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + "  where catstaff_type =:1 ")
    public List<CatStaffPrivilege> getAllCatStaffPrivileges(int catstaff_type);

    @SQL("delete from  " + TABLE_NAME + " where catstaff_type = :1 and privilege_id = :2")
    public int del(int catstaff_type, int privilege_id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + " where catstaff_type = :1 and privilege_id = :2")
    public CatStaffPrivilege get(int catstaff_type, int privilege_id);

    @SQL("select " + FIELDS + " from " + TABLE_NAME + " where  privilege_id = :1")
    public List<CatStaffPrivilege> getByPrivilegeId(long privilege_id);
}
