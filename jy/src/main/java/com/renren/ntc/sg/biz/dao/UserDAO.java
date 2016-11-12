package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.User;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/*
CREATE TABLE `items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `shop_id` bigint(20) NOT NULL DEFAULT 0 ,
  `name` varchar(24) NOT NULL DEFAULT '' ,
  `count` int(11) NOT NULL DEFAULT 0 ,
  `head_url` varchar(256) NOT NULL DEFAULT '' ,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   KEY shop_id(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


 */


@DAO(catalog = "ABC")
public interface UserDAO {
    static final String TABLE_NAME= "user";
    static final String FIELDS = "id, name,phone,enable,type,pwd ,wx_open_id,create_time,update_time,user_token,is_login" ;
    static final String INSERT_FIELDS = "name,phone,enable,type,pwd,wx_open_id " ;
    static final String INSERT_APP_FIELDS = "name,phone,enable,type,pwd,user_token,is_login " ;

	@SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where id =:1")
	public User getUser(long user_id);

    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where wx_open_id =:1 order by create_time desc ")
    public List<User> getUserByOpenId(String  wx_open_id );

    @ReturnGeneratedKeys
    @SQL("insert into  "  + TABLE_NAME + " (" + INSERT_FIELDS  +") values (:1.name,:1.phone,:1.enable,:1.type,:1.pwd,:1.wx_open_id)")
    public long  createUser(User user);

    @SQL("update  " + TABLE_NAME + " set wx_open_id =:2 where id =:1")
    public int  updateOpenId(long id, String openId);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where user_token =:1")
	public User getUserByUserToken(String userToken);
    
    @ReturnGeneratedKeys
    @SQL("insert into  "  + TABLE_NAME + " (" + INSERT_APP_FIELDS  +") values (:1.name,:1.phone,:1.enable,:1.type,:1.pwd,:1.user_token,:1.is_login)")
    public long  createAppUser(User user);
    
    @SQL("select "+ FIELDS +" from " + TABLE_NAME + "  where phone =:1")
	public User getUserByPhone(String phone);
    
    @SQL("update  " + TABLE_NAME + " set is_login =0 where phone =:1")
	public Integer updateUserLogOut(String phone);
    
    @SQL("update  " + TABLE_NAME + " set user_token =:2 where id =:1")
	public Integer updateUserTokenById(long id,String userToken);
	
	    
    @SQL("select id from " + TABLE_NAME + "  where create_time < :1 order by id limit :2,:3")
    public List<Long> getUserByCreateTime(String  createTime ,int begin,int offset);
    
    @SQL("update  " + TABLE_NAME + " set user_token =:2,is_login=1 where id =:1")
   	public Integer updateUserTokenAndLoginById(long id,String userToken);
}
