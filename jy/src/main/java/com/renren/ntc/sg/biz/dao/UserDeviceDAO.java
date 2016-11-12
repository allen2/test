package com.renren.ntc.sg.biz.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.UserDevice;
/**
CREATE TABLE `user_device` (
  `sysid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `uid` varchar(50) NOT NULL COMMENT 'uid appleuid',
  `gid` varchar(50) NOT NULL COMMENT 'gid server id',
  `chn` varchar(10) NOT NULL DEFAULT ''  COMMENT 'adr ios ',  
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`sysid`),
  UNIQUE KEY `idx_uid_chn` (`uid`,`chn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author chunhai.li
 *
 */

@DAO(catalog = "ABC")
public interface UserDeviceDAO {
    static final String TABLE_NAME= "user_device";
    static final String  FIELDS = "sysid,uid , chn,create_time,last_login_time"  ;
    static final String  INSERT_FIELDS = "uid, chn,last_login_time"  ;
    
    @SQL("select * from " + TABLE_NAME +" where uid =:1 and chn =:2")
    public UserDevice getDev(String gid,String chn) ;

    @ReturnGeneratedKeys
    @SQL("insert into " + TABLE_NAME + "(" + INSERT_FIELDS +" ) values"  + " (:1.uid,:1.chn,now())")
    public long insert(UserDevice o);
    
    @SQL("update " + TABLE_NAME +" set last_login_time = now() where sysid =:1 ")
    public Integer updateLastLoginTime(long sysid) ;
}
