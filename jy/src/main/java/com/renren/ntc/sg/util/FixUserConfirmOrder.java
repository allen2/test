package com.renren.ntc.sg.util;

import java.util.Date;
import java.util.List;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renren.ntc.sg.bean.Order;
import com.renren.ntc.sg.bean.Shop;
import com.renren.ntc.sg.biz.dao.OrdersDAO;
import com.renren.ntc.sg.biz.dao.ShopDAO;
import com.renren.ntc.sg.biz.dao.UserOrdersDAO;

public class FixUserConfirmOrder {
	public static void main(String[] args) {
		RoseAppContext rose = new RoseAppContext();
		ShopDAO shopDAO = rose.getBean(ShopDAO.class);
		OrdersDAO orderDao = rose.getBean(OrdersDAO.class);
		UserOrdersDAO userOrdersDAO = rose.getBean(UserOrdersDAO.class);
		List<Shop> shops = shopDAO.getAllShopsByAudit(1);
		for(Shop shop : shops){
			List<Order> orders = orderDao.getUserConfirmOrdersByWXCondition(SUtils.generOrderTableName(shop.getId()), shop.getId(), "2015-04-24 00:00:00", "2015-04-24 23:59:59");
			for(Order order : orders){
			Date userConfirmTime = order.getUser_confirm_time();
			long userId = order.getUser_id();
			if(userConfirmTime == null){
				String orderInfo = order.getOrder_info();
				if(StringUtils.isBlank(orderInfo)){
					continue;
				}
				JSONObject json = (JSONObject)JSON.parse(orderInfo);
				if(json == null){
					continue;
				}
				String operator_time = json.getString("operator_time");
				if(StringUtils.isBlank(operator_time)){
					continue;
				}
			    int flag = orderDao.updateUserConfirmTimeByCondition(SUtils.generOrderTableName(shop.getId()), shop.getId(), order.getOrder_id(), operator_time);
			    int uflag = userOrdersDAO.updateUserConfirmTimeByCondition(SUtils.generUserOrderTableName(userId), shop.getId(), order.getOrder_id(), operator_time);
			    if(flag == 1){
			    	System.out.println("update flag suc,shop_id="+shop.getId()+",orderId="+order.getOrder_id()+",operator_time="+operator_time+",uflag="+uflag);
			    }else {
			    	System.out.println("update flag failed,shop_id="+shop.getId()+",orderId="+order.getOrder_id()+",uflag="+uflag);
				}
			}
			
		  }
		}
		
	}
}
