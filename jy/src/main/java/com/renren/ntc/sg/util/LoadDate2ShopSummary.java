package com.renren.ntc.sg.util;

import java.util.List;

import net.paoding.rose.scanning.context.RoseAppContext;

import com.alibaba.fastjson.JSON;
import com.renren.ntc.sg.bean.Shop;
import com.renren.ntc.sg.bean.ShopSummary;
import com.renren.ntc.sg.biz.dao.OrdersDAO;
import com.renren.ntc.sg.biz.dao.ShopDAO;
import com.renren.ntc.sg.biz.dao.ShopSummaryDAO;
import com.renren.ntc.sg.service.LoggerUtils;

public class LoadDate2ShopSummary {
	public static void main(String[] args) {
		RoseAppContext rose = new RoseAppContext();
		ShopDAO shopDAO = rose.getBean(ShopDAO.class);
		OrdersDAO ordersDAO = rose.getBean(OrdersDAO.class);
	    ShopSummaryDAO shopSummaryDAO = rose.getBean(ShopSummaryDAO.class);
		String dateStr = args[0];
		int dateInt = Integer.parseInt(dateStr);
		List<Shop> shops = shopDAO.getAllShopsByAudit(1);
		for(Shop shop : shops){
			LoggerUtils.getInstance().log("LoadDate2ShopSummary begin shopid="+shop.getId());
			long shop_id = shop.getId();
			String shopname = shop.getName();
        	String beginTime = Dateutils.tranferDate2Str(Dateutils.getDateByCondition(dateInt, 0, 0, 0, 0));
        	String endTime = Dateutils.tranferDate2Str(Dateutils.getDateByCondition(dateInt, 23, 59, 59, 59));
        	Integer dailyUserConfirmOrderPrice = ordersDAO.getBossDailySumPriceByWXCondition(SUtils.generOrderTableName(shop_id), shop_id, beginTime, endTime);
        	Integer dailyUserConfirmOrderCount = ordersDAO.getBossDailyOrderCountByWXCondition(SUtils.generOrderTableName(shop_id), shop_id, beginTime, endTime);
        	dailyUserConfirmOrderPrice = dailyUserConfirmOrderPrice==null ? 0:dailyUserConfirmOrderPrice;
        	dailyUserConfirmOrderCount = dailyUserConfirmOrderCount==null ? 0:dailyUserConfirmOrderCount;
        	ShopSummary shopSummary = new ShopSummary();
        	shopSummary.setShop_id(shop_id);
        	shopSummary.setShop_name(shopname);
        	shopSummary.setOrder_count(dailyUserConfirmOrderCount);
        	shopSummary.setOrder_price(dailyUserConfirmOrderPrice);
        	shopSummaryDAO.addShopSummary(shopSummary, beginTime);
        	String shopSumJson = JSON.toJSONString(shopSummary);
        	LoggerUtils.getInstance().log("LoadDate2ShopSummary beginTime ="+beginTime+",endTime="+endTime+",end ="+shopSumJson);
		}
		
	}
}
