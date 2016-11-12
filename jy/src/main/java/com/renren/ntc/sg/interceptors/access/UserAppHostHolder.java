package com.renren.ntc.sg.interceptors.access;

import com.renren.ntc.sg.bean.UserDevice;


public interface UserAppHostHolder {
    /**
     * 返回当前访问者，如果没有登录的话返回null
     * 
     * @return
     */
    public UserDevice getUser();

    /**
     * 
     * @param user
     */
    public void setUser(UserDevice user);
}
