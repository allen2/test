package com.renren.ntc.sg.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.renren.ntc.sg.bean.*;
import com.renren.ntc.sg.util.wx.MD5Util;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yunming.zhu
 * Date: 14-11-21
 * Time: 上午10:54
 * To change this template use File | Settings | File Templates.
 */
public class SUtils {

    private static String key = "210f760a89db30aa72ca258a3483cc7f";
    public  static String appId = "wx762f832959951212";
    private static Object today;





    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }



    public static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    public static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;
    }

    public static boolean online(long now, Shop shop) {
        Date open_time = shop.getOpen_time();
        Date close_time = shop.getClose_time();
        if (open_time == null || close_time == null) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(now));
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int t = hours * 60 + minutes;

        Calendar calendar_o = Calendar.getInstance();
        calendar_o.setTime(open_time);
        int open_hours = calendar_o.get(Calendar.HOUR_OF_DAY);
        int open_minutes = calendar_o.get(Calendar.MINUTE);
        int open_t = open_hours * 60 + open_minutes;

        Calendar calendar_c = Calendar.getInstance();
        calendar_c.setTime(close_time);
        int close_hours = calendar_c.get(Calendar.HOUR_OF_DAY);
        int close_minutes = calendar_c.get(Calendar.MINUTE);
        int close_t = close_hours * 60 + close_minutes;
        if (close_t < open_t) {
            if (t > open_t && t <= (24 * 60)) {
                return true;
            }
            if (t < close_t && t >= 0) {
                return true;
            }
        }
        if (close_t > open_t) {
            if (t > open_t && t < close_t) {
                return true;
            }
        }
        return false;
    }


    public static String toString(byte[] text) {
        try {
            return new String(text, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String span(String response) {
        if (null == response) {
            return null;
        }
        response = response.replaceAll("会所", "会_所");
        response = response.replaceAll("公寓", "公_寓");
        response = response.replaceAll("乡巴佬", "乡_巴_佬");
        response = response.replaceAll("测试", "测_试");
        return response;
    }

    public static boolean isOk(String response) {
        if (null == response) {
            return false;
        }
        JSONObject ob = JSON.parseObject(response);
        if ("0".equals(ob.getString("error_code"))) {
            return true;
        }
        return false;
    }


    public static int getShopId(String key) {
        String shop_id = CookieHepler.getInstance().getCookie(key);
        int id = 0;
        try {
            id = Integer.valueOf(shop_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;

    }

    public static String forURL(String url, String appkey, String tid, String mobile, String value) {
        return url + "?key=" + appkey + "&dtype=json&mobile=" + mobile + "&tpl_id=" + tid + "&tpl_value=" + value;

    }


    public static JSONArray from(List<OrderInfo> ls) {
        JSONArray jarry = new JSONArray();
        if (null == ls) {
            return jarry;
        }
        for (OrderInfo o : ls) {
            JSONObject jb = new JSONObject();
            jb.put("order_id", o.getOrder_id());
            jb.put("info", o.getInfo());
            jb.put("create_time", o.getCreate_time());
            jarry.add(jb);
        }
        return jarry;
    }


    public static String getOrderId() {

        StringBuffer sb = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowdate = sdf.format(new Date());
        Random r = new Random();
        int abc = r.nextInt(1000000);
        sb.append("C").append(nowdate).append(pad(abc + ""));
        return sb.toString();
    }

    private static String pad(String abc) {
        StringBuffer sb = new StringBuffer();
        int l = abc.length();
        for (int i = 0; i < 7 - l; i++) {
            sb.append("0");
        }
        sb.append(abc);
        return sb.toString();
    }

    public static boolean islegal(String order_id) {
        if (StringUtils.isBlank(order_id) || !order_id.startsWith("C") || order_id.length() != 22) {
            return false;
        }
        return true;
    }


    public static String generName() {
        StringBuffer sb = new StringBuffer();
        String ref = System.currentTimeMillis() + "";
        Random r = new Random();
        int abc = r.nextInt(10000);
        sb.append("cat_").append(ref).append(pad(abc + ""));
        return sb.toString();

    }

    public static String wrap(String key) {
        StringBuffer sb = new StringBuffer();
        sb.append("%");
        sb.append(key);
        sb.append("%");
        return sb.toString();
    }

    public static String getResourceFullLocation(HttpServletRequest request) {
        StringBuffer sb = request.getRequestURL();
        String url = sb.toString();
        String queryString = request.getQueryString();
        if (queryString != null) {
            url = url + "?" + queryString;
        }
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }

    public static long unwrapper(String uid) {
        String[] arr = uid.split("_");
        long id = 0;
        if (2 != arr.length) {
            return id;
        }
        String u = arr[1];
        try {
            id = Long.valueOf(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static boolean isStaffKey(String cookies) {
       if(-1 == cookies.indexOf(Constants.STAFFKEY)) {
                return false;
       }
        return true;
    }



    public static String wrapper(String uid) {

        StringBuffer sb = new StringBuffer();
        UUID uuid = UUID.randomUUID();
        String u = uuid.toString().replace("-", "");
        sb.append(u);
        sb.append("_");
        sb.append(uid);
        return sb.toString();
    }

    public static String generTableName(long shop_id) {
        StringBuffer sb = new StringBuffer("items_");
        long mod = shop_id % 1000;
        return sb.append(mod).toString();
    }


    public static String generOrderTableName(long shop_id) {
        StringBuffer sb = new StringBuffer("orders_");
        long mod = shop_id % 1000;
        return sb.append(mod).toString();
    }

    public static String generUserOrderTableName(long user_id) {
        StringBuffer sb = new StringBuffer("user_orders_");
        long mod = user_id % 1000;
        return sb.append(mod).toString();
    }



    public static JSONObject parse(Item item) {
        JSONObject jb = new JSONObject();
        jb = (JSONObject) JSON.toJSON(item);
        return jb;
    }

    public static void main(String[] args) {
        System.out.println(generToken("cat_1232"));
    }


    public static boolean Tokenislegal(String token) {
        return true;

    }

    public static String generToken(String token) {
        String[] tet = token.split("_");
        StringBuffer sb = new StringBuffer();
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        sb.append(tet[0]).append("_").append(uuid.substring(0, 8));
        return sb.toString();
    }


    public static  boolean ready(Shop shop) {
        if (shop.getAudit() != 1){
            return false;
        }
        if(shop.getStatus() == Constants.SHOP_OPEN_STATUS){
            if(SUtils.online(System.currentTimeMillis(),shop)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }


    public static  void forV(Shop shop,long time) {
        	if(shop.getStatus() == Constants.SHOP_OPEN_STATUS){
        		if(SUtils.online(time,shop)){
                    shop.setStatus4V("营业中");
                    shop.setStatus(0);
                }else {
                    shop.setStatus4V("打烊了");
                    shop.setStatus(1);
                }
        	}else {
        		shop.setStatus4V("打烊了");
                shop.setStatus(1);
			}
            
    }

    public static  void forV(List<Shop> shops,long time) {
        for (Shop s : shops){
            forV(s,time);
        }
    }

    public static boolean isOffline(Device device) {
         Date date = device.getUpdate_time();
        long now = System.currentTimeMillis();
        long last_time = date.getTime();
        return (now -last_time) > Constants.OFFLINEFLAG ;
    }

    public static String generSMSCacheKey(String message, String phone) {
        StringBuffer sb = new StringBuffer();
        sb.append(message);
        sb.append("#");
        sb.append(phone);
        return sb.toString();
    }

    public static String getStaffKey(long id ) {
        StringBuffer sb =   new StringBuffer();
        sb.append(Constants.STAFFKEY) ;
        sb.append(id) ;
        return sb.toString();
    }
    public static String unwrapperStaffKey(String uuid) {
        uuid = uuid.replace(Constants.STAFFKEY,"");
        return uuid;
    }

    public static boolean isDev() {
        String env = ConfigProperties.getInstance().getValue("env") ;
        return "dev".equals(env);
    }

    public static String getActionResult(int code,String message) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", message);
        return result.toJSONString();
    }

    public static String md5(long id, long id1, String nonceStr) {
        StringBuffer sb =  new StringBuffer() ;
        return MD5Utils.MD5(sb.append(id + "").append(id1 + "").append(nonceStr).toString());
    }

    public static String ticketKey(long coupon_id) {
        StringBuffer sb  = new StringBuffer();
        sb.append(Constants.TICKETPRE);
        sb.append(coupon_id);
        return sb.toString();
    }

    public static String generDaylimitTicketKey(long user_id) {
        StringBuffer sb  = new StringBuffer();
        new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        sb.append(Constants.DAYLIMIT);
        sb.append(user_id);
        sb.append(Constants.LUNDER);
        sb.append(date);
        return sb.toString();

    }

    public static String generOrders(String order_id,long shop_id) {
        long curr = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        sb.append(order_id);
        sb.append("_");
        sb.append(shop_id);
        sb.append("_");
        sb.append(curr);
        return sb.toString();

    }
    
    public static String generCouponRedisKey(String order_id,long shop_id) {
         StringBuffer sb = new StringBuffer();
         sb.append(order_id);
         sb.append("_");
         sb.append(shop_id);
         return sb.toString();

    }

    public static String createSign(SortedMap<String, String> packageParams) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        System.out.println("md5 sb:" + sb);
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8")
                .toUpperCase();
        return sign;
    }

    public static String  getToday() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
}
