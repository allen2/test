package com.renren.ntc.sg.util;

import com.renren.ntc.sg.bean.Boss;
import com.renren.ntc.sg.bean.Shop;
import com.renren.ntc.sg.biz.dao.BossDAO;
import com.renren.ntc.sg.biz.dao.ShopDAO;
import com.renren.ntc.sg.service.LoggerUtils;
import net.paoding.rose.app.RoseAppContext;
//向Boss表添加记录
/**
 * Created by ZhaoXiuFei on 2015/5/15 15:56.
 */
public class PhilTest {
    public static void main(String[] args) {
        RoseAppContext rose = new RoseAppContext();
        ShopDAO shopDAO = rose.getBean(ShopDAO.class);
        BossDAO bossDAO = rose.getBean(BossDAO.class);

        for (int i = 10019; i < 10236; i++) {
            Shop shop = shopDAO.getShop(i);
            if (null == shop) {
                continue;
            }
            Boss boss = bossDAO.getBoss(shop.getId());
            if (null == boss) {
                boss = new Boss();
                boss.setShop_id(shop.getId());
                boss.setName("请录入");
                bossDAO.addBoss(boss);
                LoggerUtils.getInstance().log("com.renren.ntc.sg.util.Test.main----------OK---------->" + shop.getId() + "shop_id 新加入");
            } else {
                shopDAO.update(shop.getId(), "owner", boss.getName());
                LoggerUtils.getInstance().log("com.renren.ntc.sg.util.Test.main-------" + shop.getId() + "---OK----------更新shop表");
            }
        }
    }
}
