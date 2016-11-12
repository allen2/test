package com.renren.ntc.sg.biz.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.ntc.sg.bean.UserPushToken;

/*
CREATE TABLE `user_pushtoken` (
  `sysid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `uid` varchar(50) NOT NULL COMMENT 'uid appleuid',
  `gid` varchar(50) NOT NULL COMMENT 'gid server id',
  `chn` varchar(10) NOT NULL DEFAULT ''  COMMENT 'adr ios ',
  `token` varchar(250) NOT NULL DEFAULT '' COMMENT 'device token',  
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`sysid`),
  UNIQUE KEY `idx_uid_chn` (`uid`,`chn`),
  KEY `token` (`token`(9))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 */


@DAO(catalog = "ABC")
public interface UserPushTokenDAO {
    static final String TABLE_NAME= "user_pushtoken";
    static final String FIELDS = "sysid, uid , chn, token,create_time,update_time" ;
    static final String INSERT_FIELDS = "uid , chn, token" ;

	@SQL("select " +  FIELDS +" from " + TABLE_NAME + " where token = :1 and chn = :2")
    public UserPushToken getPushTokenByTokenChn(String token,String chn);
	
	@SQL("select " +  FIELDS +" from " + TABLE_NAME + " where uid = :1 and chn = :2")
    public UserPushToken getPushTokenByUidChn(String gid,String chn);


    @SQL("insert  into " + TABLE_NAME +" (" +  INSERT_FIELDS +") " +   " values" +
            "(:1.uid,:1.chn,:1.token)")
    public Integer  insertUserPushToken (UserPushToken userPushToken);
    
    @SQL("update " + TABLE_NAME + " set  uid = :1.uid,chn = :1.chn,token =:1.token,update_time=now()  where sysid = :1.sysid")
    public Integer updateUserPushTokenBySysid(UserPushToken userPushToken);
}
