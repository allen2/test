package com.renren.ntc.sg.interceptors;

import com.renren.ntc.sg.annotations.DenyCommonAccess;
import com.renren.ntc.sg.bean.User;
import com.renren.ntc.sg.biz.dao.UserDAO;
import com.renren.ntc.sg.interceptors.access.NtcHostHolder;
import com.renren.ntc.sg.service.LoggerUtils;
import com.renren.ntc.sg.util.Constants;
import com.renren.ntc.sg.util.CookieManager;
import com.renren.ntc.sg.util.SUtils;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Interceptor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.util.List;

@Interceptor(oncePerRequest = true)
public class AccessCommonInterceptor extends ControllerInterceptorAdapter {

    @Autowired
    private NtcHostHolder hostHolder;


    @Autowired
    private UserDAO userDAO;


    private static final Logger logger = LoggerFactory.getLogger(AccessCommonInterceptor.class);

    public AccessCommonInterceptor(){
    	setPriority(10000);
    }
    
    protected Class<? extends Annotation> getDenyAnnotationClass() {
        return DenyCommonAccess.class;
    }

    @Override
    protected Object before(Invocation inv) throws Exception {
        String ua = inv.getRequest().getHeader("User-Agent") ;
        String path = inv.getRequest().getRequestURI() ;
        if (path.startsWith("/wx")|| path.startsWith("/console")|| path.startsWith("/app")) {
            return true;
        }

        if(ua == null ){
            LoggerUtils.getInstance().log(String.format(" ua  is null "));
            return "r:" + Constants.MBIANLI;

        }
        if( (-1 == ua.indexOf("MicroMessenger")&& !SUtils.isDev())){
           return "r:" + Constants.MBIANLI;
        }

        User u = null    ;
        String uuid  = CookieManager.getInstance().getCookie(inv.getRequest(), Constants.COOKIE_KEY_USER);
        if(null  != uuid) {
            u = userDAO.getUser(SUtils.unwrapper(uuid));
        }



        hostHolder.setUser(u);
        return true;
	}
    private final static int YEAR =  36000*24*365 ;
    private int year() {
        return  YEAR ;
    }


    protected Object after(Invocation inv, Object instruction) throws Exception {
        String path = inv.getRequest().getRequestURI() ;
        if(path.startsWith("/sg")){
            inv.getResponse().setHeader("Access-Control-Allow-Origin","*");
        }
        return instruction;
    }

}
