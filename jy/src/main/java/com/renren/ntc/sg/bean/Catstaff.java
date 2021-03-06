package com.renren.ntc.sg.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yunming.zhu
 * Date: 15-1-9
 * Time: 下午6:35
 * To change this template use File | Settings | File Templates.
 */
public class Catstaff extends RegistUser {

    private long id;
    private String name;
    private String phone;
    private String email = "";

    private int type;
    private String pwd;
    private Date create_time ;
    private Date update_time ;

    public Catstaff() {
    }

    public long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Catstaff(String name, String phone, String pwd, int type) {
        this.name = name;
        this.phone = phone;
        this.pwd = pwd;
        this.type = type;
    }
}
