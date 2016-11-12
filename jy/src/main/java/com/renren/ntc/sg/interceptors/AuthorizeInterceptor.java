package com.renren.ntc.sg.interceptors;

import com.renren.ntc.sg.annotations.AuthorizeCheck;
import com.renren.ntc.sg.bean.CatStaffPrivilege;
import com.renren.ntc.sg.bean.Privilege;
import com.renren.ntc.sg.bean.RegistUser;
import com.renren.ntc.sg.bean.Shop;
import com.renren.ntc.sg.biz.dao.CatStaffDAO;
import com.renren.ntc.sg.biz.dao.CatStaffPrivilegeDAO;
import com.renren.ntc.sg.biz.dao.PrivilegeDAO;
import com.renren.ntc.sg.biz.dao.ShopDAO;
import com.renren.ntc.sg.constant.CatStaffType;
import com.renren.ntc.sg.interceptors.access.RegistHostHolder;
import com.renren.ntc.sg.service.LoggerUtils;
import com.renren.ntc.sg.util.Constants;
import com.renren.ntc.sg.util.CookieManager;
import com.renren.ntc.sg.util.SUtils;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 标注:{@link com.renren.ntc.sg.interceptors.AuthorizeInterceptor}
 *
 * @author [yunming.zhu@opi-corp.com]
 * @date Mar 25, 2011 02:40:40 AM
 */

public class AuthorizeInterceptor extends ControllerInterceptorAdapter {

    @Autowired
    private RegistHostHolder hostHolder;


    @Autowired
    private ShopDAO shopDAO;

    @Autowired
    private CatStaffDAO catstaffDao;

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Autowired
    private CatStaffPrivilegeDAO catStaffPrivilegeDAO;


    private static final Logger logger = LoggerFactory.getLogger(AuthorizeInterceptor.class);


    public AuthorizeInterceptor() {
        setPriority(1000);
    }

    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return AuthorizeCheck.class;
    }


    @Override
    public Object before(Invocation inv) throws Exception {

        RegistUser user = hostHolder.getUser();
        if (user == null) {
            String origURL = SUtils.getResourceFullLocation(inv.getRequest());
            LoggerUtils.getInstance().log("the origURL is " + origURL);

            return "r:" + "/console/login?rf=s&domain="
                    + Constants.DOMAIN_URL + "&origURL="
                    + origURL;
        }

        String path = inv.getRequest().getRequestURI();
        String uuid = CookieManager.getInstance().getCookie(inv.getRequest(), Constants.COOKIE_KEY_REGISTUSER);
        if (null != uuid) {
            if (SUtils.isStaffKey(uuid)) {
                inv.addModel("staff", "staff");
                if (path.startsWith("/console/home")) {
                    return true;
                }
                long catstaff_id = SUtils.unwrapper(SUtils.unwrapperStaffKey(uuid));
                user = catstaffDao.getCatStaffbyId(catstaff_id);
                int type = user.getType();//角色

                if (CatStaffType.TYPE_ADMIN == type) {
                    return true;//管理员 直放行
                }
                List<CatStaffPrivilege> catStaffPrivilegeList = catStaffPrivilegeDAO.getAllCatStaffPrivileges(type);
                if (0 == catStaffPrivilegeList.size()) {
                    inv.addModel("msg", "还没有分配权限");
                    return "error";
                }
                List<Long> privilege_ids = new ArrayList<Long>(catStaffPrivilegeList.size());

                for (CatStaffPrivilege csp : catStaffPrivilegeList) {
                    privilege_ids.add(csp.getPrivilege_id());
                }

                List<Privilege> privilegeList = privilegeDAO.getPrivilegeByIds(privilege_ids);//权限

                for (Privilege p : privilegeList) {
                    String uri = p.getMenu_url();
                    if (path.startsWith(uri)) {
                        return true;
                    }
                }
                inv.addModel("msg", "您没有访问" + path + "的权限");
                return "error";
            } else {//不是喵喵员工
                if (!path.startsWith("/console/shop")){
                    inv.addModel("msg", "您没有访问" + path + "的权限");
                    return "error";
                }
                String shop_id = inv.getRequest().getParameter("shop_id");
                long shopId = 0;
                if (StringUtils.isBlank(shop_id)) {
                    Shop shop = shopDAO.getShopbyOwner_id(user.getId());
                    if (null == shop) {
                        inv.addModel("msg", "没有关联店铺");
                        return "error";
                    }
                } else {
                    try {
                        shopId = Long.valueOf(shop_id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LoggerUtils.getInstance().log("shop  id  " + shopId);
                    Shop shop = shopDAO.getShop(shopId);
                    if (null == shop) {
                        inv.addModel("msg", "未知错误，请重试");
                        return "error";
                    }
                    LoggerUtils.getInstance().log("shop owner id  " + shop.getOwner_user_id() + "user id  " + user.getId());
                    if (shop.getOwner_user_id() != user.getId()) {
                        inv.addModel("msg", "没有权限");
                        return "error";
                    }
                }
            }
        }
        return true;
    }
}
