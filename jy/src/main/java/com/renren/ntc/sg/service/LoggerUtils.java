package com.renren.ntc.sg.service;

import com.renren.ntc.sg.bean.User;
import com.renren.ntc.sg.bean.UserDevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yunming.zhu
 * Date: 14-12-2
 * Time: 下午1:48
 * To change this template use File | Settings | File Templates.
 */
public class LoggerUtils {

    private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    private static LoggerUtils instance = new  LoggerUtils();

    private LoggerUtils(){


    }
    public static LoggerUtils getInstance (){
        return instance;
    }

    public void log (String message, User u){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd EE HH:mm:ss");
        if(u!= null){
        System.out.println(String.format("%s %s,user %d ,%s" ,df.format(new Date()) , message,u.getId(),u.getWx_open_id()));
        }else{
        System.out.println(String.format("%s %s,user %d ,%s" ,df.format(new Date()) , message,0,""));
        }
    }
    
    public void logUserApp (String message, UserDevice u){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd EE HH:mm:ss");
        if(u!= null){
        System.out.println(String.format("%s %s,user %d" ,df.format(new Date()) , message,u.getSysid()));
        }else{
        System.out.println(String.format("%s %s,user %d" ,df.format(new Date()) , message,0));
        }
    }

    public void log (String message){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd EE HH:mm:ss");
        System.out.println(df.format(new Date())+ " " + message);
    }
}
