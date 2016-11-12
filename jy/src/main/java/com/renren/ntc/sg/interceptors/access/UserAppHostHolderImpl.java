package com.renren.ntc.sg.interceptors.access;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.InvocationLocal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renren.ntc.sg.bean.UserDevice;



@Service
public class UserAppHostHolderImpl implements UserAppHostHolder {

    private static final String KEY_CUR_USER = "__current_app_user__";

    @Autowired
    InvocationLocal             inv;

    @Override
    public UserDevice getUser() {
        Invocation inv = this.inv.getCurrent(false);
        if (inv != null) {
            return (UserDevice) inv.getRequest().getAttribute(KEY_CUR_USER);
        } else {
            return null;
        }
    }

    public void setUser(UserDevice user) {
        inv.getRequest().setAttribute(KEY_CUR_USER, user);
    }

}
