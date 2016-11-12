package com.renren.ntc.sg.bean;

/**
 * Created by ZhaoXiuFei on 2015/5/8 11:36.
 */
public class CatStaffPrivilege {

    private long id;
    private int catstaff_type;
    private long privilege_id;

    public int getCatstaff_type() {
        return catstaff_type;
    }

    public void setCatstaff_type(int catstaff_type) {
        this.catstaff_type = catstaff_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(long privilege_id) {
        this.privilege_id = privilege_id;
    }
}
