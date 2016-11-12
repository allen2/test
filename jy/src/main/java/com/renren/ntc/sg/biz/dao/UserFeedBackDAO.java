package com.renren.ntc.sg.biz.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.UserFeedBack;

/**
 * 
 * @author chunhai.li
 *
 */
@DAO(catalog = "ABC")
public interface UserFeedBackDAO {
    static final String TABLE_NAME= "user_feedback";
    static final String  FIELDS = "id,create_time,phone ,msg";
    static final String INSERT_FIELDS = "create_time,phone ,msg" ;
    
    @ReturnGeneratedKeys
    @SQL("insert into  "  + TABLE_NAME + "(" + INSERT_FIELDS  +") values (now(),:1.phone,:1.msg)")
    public int  addFeedBack(UserFeedBack userFeedBack);
}
