package com.renren.ntc.sg.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 11/9/14.
 */
public class Constants {
    public static  final int  SHOP_ID = 10010;
    public static  final String HEADER ="^F1";
    public static  final String TITLE ="^H2";
    public static  final String BR ="\n";
    public static  final String SPILT  ="********************************";
    public static  final String SPILT2 ="================================";

    public static  final String ORDER_ADDRESS = " 配送地址：";

    public static  final String ORDER_DETAIL = " 订单明细：";
    public static  final String ORDER_HEAD =   " 名称               数量  价格  ";
    public static  final String ORDER_TOTAL  = " 总计                    ：{total}元";
    public static  final String DCODE_TITLE =  " 订单号：{order}";
    public static  final String ORDERTIME = " 下单时间 : {time}";
    public static  final String WEIXIN_URL = "^Q+http://weixin.qq.com/r/l3UsNBHEW0wkrVVX9yCF";
                                                     //"http://weixin.qq.com/r/l3UsNBHEW0wkrVVX9yCF"
    public static  final String FOOTER = "^H2 喵喵一下 ，便利到家";
    public static  final long  DEFAULT_SHOP_ID = 1;

    public static final String mch_id = "1233699402";

    public static final String DBNAME = "sg" ;
    public static final String HOST = "www.mbianli.com" ;

    public static  final String UNREAD = "{\"code\":1000,\"msg\":\"当前店铺无法提供服务，换一家试试\"}";
    public static  final String WXSYCERROR = "{\"code\":22,\"msg\":\"微信同步问题，请退出到公众号重新进入\"}";

    public static  final String PARATERERROR = "{\"code\":1,\"msg\":\"paramter error\"}";
    public static  final String ERROR = "{\"code\":1,\"msg\":\"error\"}";
    public static  final String PRERROR = "{\"code\":1,\"msg\":\"{msg}\"}";
    public static  final String LEAKERROR = "{\"code\":100,\"msg\":\"库存不足\"}";
    public static  final String UNLOGINERROR = "{\"code\":101,\"msg\":\"未登录\"}";
    public static  final String TMPPAYERROR = "{\"code\":401,\"msg\":\"暂时无法使用微信支付。\"}";
    public static  final String UKERROR = "{\"code\":500,\"msg\":\"服务器异常\"}";
    public static  final String NOMORE = "{\"code\":10,\"msg\":\"您已经领过代金券了，请进入个人中心查看\"}";
    public static  final String DONE = "{\"code\":0,\"msg\":\"done\"}";
    public static  final String IS_NO_LOGIN = "{\"code\":-1,\"msg\":\"not login\"}";
    public static  final String NEED_LOGIN = "{\"code\":300,\"msg\":\"need login\"}";
    public static  final String VALIDATE_CODE_ERROR = "{\"code\":5,\"msg\":\"验证码无效或者错误\"}";
    public static  final String LOGOUT_FAILED = "{\"code\":6,\"msg\":\"logout failed\"}";
    public static  final String ADDRESS_IS_NULL = "{\"code\":7,\"msg\":\"address is null\"}";
    public static  final String PAYSTATUS_IS_ERROR = "{\"code\":8,\"msg\":\"pay status error\"}";

    public static  final String ALLREADYNEW = "{\"code\":0,\"msg\":\"allready new version\"}";
    public static final long DEFAULT_SHOP = 1 ;
//    public static final String DOMAIN = "miaomiao.com" ;UK
    public static final String DOMAIN = "127.0.0.1" ;
    public static final String DOMAIN2 = "mbianli.com:8088" ;
    public static final String MBIANLI = "http://www.mbianli.com" ;
    public static final String DOMAIN3 = "mbianli.com" ;
    public static final String DOMAIN4 = "127.0.0.1:8080" ;
    public static final String DOMAIN5 = "mbianli.com:8099" ;
    public static final String COOKIE_KEY_USER ="cat_p" ;
    public static final String COOKIE_KEY_REGISTUSER ="cat_reg_p" ;
    public static final String COOKIE_KEY_USER_APP ="cat_user_p" ;
    public static final Object DOMAIN_URL = "";
    public static final long OFFLINEFLAG = 1000 * 60 * 10;
    public static final String WX_WEB_PAY = "wx" ;
    public static final String WX_NATIVE_PAY = "wx_native" ;
    public static final String ALI_NATIVE_PAY = "ali_native" ;
    public static final String CASH_PAY = "cash" ;
    public static final String TICKETPRE = "ticket_";
    public static final String COUPONTRADE = "TRADEING";
    public static final int TRADEPIE = 10;
    public static final String DAYLIMIT = "daylimit_";
    public static final String LUNDER = "_";
    public static final String CANNOTUSETICKET = "{\"code\":12,\"msg\":\"今天已经使用过代金券\"}";;
    public static final String CANNOTUSETHISTICKET = "{\"code\":15,\"msg\":\"该过代金券暂时无法使用，请选择其他代金券\"}";;
    public static final String NO_VALIADATE_COUPON = "{\"code\":13,\"msg\":\"{message}\"}";;
    public static final String ORDER_KEY = "ABC_ORDER_KEY";
    public static final String COUPON_USER_KEY = "COUPON_USER_KEY";
    public static final String ORDERDONE = "下单成功";
    public static final String ORDERCONFRIM = "配送中";
    public static final String REMARK = "{shop_name}即将为您配送，预计30分钟内到达；\n" +
            "如有疑问请联系：{shop_tel}。";
    public static final String REMARKCONFRIM = "{shop_name}正在为您配送，预计30分钟内到达；\n" +
            "如有疑问请联系：{shop_tel}。";;
    public static final String NEI_HOST = "10.173.3.200" ;
    public static String SMSURL = "http://v.juhe.cn/sms/send";
    public static String APPKEY = "99209217f5a5a1ed2416e5e6d2af87fd";
    public static String TID = "777";
    public static String LOCTID = "778";
    public static String USER_TID = "791";
    public static String TMP_TID = "1015";
    public static String SHOP_NO_EXIST = "店铺不存在";
    public static String ORDEE_NO_EXIST = "订单不存在";
    public static int ITEM_ON_SALE = 1;
    public static int SHOP_OPEN_STATUS = 0;
    public static int ITEM_NOT_SALE = 0;

    public static String NOT_PRIVILEGE = "{\"code\":99,\"msg\":\"您没有权限,请联系管理员!\"}";

    public static final String  STAFFKEY= "staff-";

    public static final int ORDER_WAIT_FOR_PRINT = 1;

    public static final int ORDER_PAY_PENDING = 0;

    public static final int ORDER_PAY_FAIL = 5;

    public static final int ORDER_FINISH = 2;

    public static final int  COUPONUNUSED = 0;

    public static final int  COUPONUSED = 4;
    
    public static final int SHOP_ANDITED = 1;
    
	public static final int REFUND_SUC_FLAG=3;
	
	public static final String REFUND_ORDER_SUC = "退单成功";
	
	public static final String REFUND_MSG = "很抱歉商家{shop_name}无法配送您的订单{order_id}，退款{refund_price}将在3-5个工作日返还到您原支付账户，请注意查收，如有问题请联系喵喵客服4008816807。";
	
	public static final String CANCEL_SMS_2_KF_SMS= "用户地址：{address}，联系电话：{phone}，{cancel_time}申请退单，店铺名{shop_name}联系电话：{tel}";
	
	public static final String CANCEL_SMS_2_BOSS_SMS="{cancel_time}订单已取消，用户地址：{address}，电话：{phone}";
	
	public static final String REMIND_ORDER_SMS_2_BOSS = "【加急】地址：{address}，联系电话：{phone}，{create_time}的订单用户加急。";
	
	public static final String REMIND_ORDER_SMS_2_KF = "【加急】用户地址：{address}，联系电话：{phone}，{create_time}的订单用户加急，店铺名{shop_name}联系电话：{tel}";
	
	public static final String REMIND_ORDER = "1";
	
	public static final String CANCEL_ORDER_2_BOSS_SMS_MSG = "#order_id#={order_id}&#address#={address}&#phone#={phone}&#create_time#={create_time}";
	
	public static final String CANCEL_ORDER_2_BOSS_SMS_MSG_TEMP_ID = "2363";
	
	public static final String USER_CANCEL_ORDER_2_KF_SMS_MSG = "#shop_name#={shop_name}&#shop_tel#={shop_tel}&#address#={address}&#phone#={phone}&#create_time#={create_time}&#order_id#={order_id}";
	
	public static final String USER_CANCEL_ORDER_2_KF_SMS_MSG_TEMP_ID = "2362";
	
	public static final String REMIND_ORDER_SMS_MSG = "#shop_name#={shop_name}&#shop_tel#={shop_tel}&#address#={address}&#phone#={phone}&#create_time#={create_time}&#order_id#={order_id}";
	
	public static final String REMIND_ORDER_SMS_MSG_TEMP_ID = "2361";
	
	public static final String KF_CLICK_CANCEL_ORDER_2_USER_MSG = "#shop_name#={shop_name}&#shop_tel#={shop_tel}&#order_id#={order_id}";
	
	public static final String KF_CLICK_CANCEL_ORDER_2_USER_MSG_TEMP_ID = "2364";
	
	public static final String REMIND_ORDER_PUSH_MSG = "【喵喵生活】用户催单:店铺{shop_name},{shop_tel} 配送地址{address},{phone},下单时间{create_time},订单号{order_id}的订单用户要求加急";
	
	public static final String CANCEL_ORDER_2_BOSS_LOC_PUSH_MSG = "【喵喵生活】订单号{order_id}订单已取消，用户地址：{address},联系电话{phone},下单时间{create_time}";
	
	public static final String USER_CANCEL_ORDER_2_PUSH_MSG = "【喵喵生活】用户要求退单:店铺{shop_name},{shop_tel}配送地址{address},{phone},下单时间 {create_time},订单号{order_id},的订单用户要求退单";
	
	public static final String KF_PHONE = "15010229352";
	
	public static final String KF_PHONE1 = "15201527113";
	
	public static final String KF_PHONE2 = "18201440822";

	
	public static final String USER_CONFIRM_MSG_2_BOSS = "#date#={date}&#order_id#={order_id}&#price#={price}";

    public static final String KF_NOTIFICATIONS = "#shop_name#={shop_name}&#tel#={tel}&#order_id#={order_id}&#info#={info}";

    public static final String KF_NOTIFICATIONS_TEMP = "订单{shop_name},{tel} ，{order_id} 订单超时 {info}，请客服处理";

	public static final String USER_CONFIRM_MSG_2_BOSS_TEMP_ID = "2397";

    public static final String KF_NOTIFICATION_TEMP_ID = "2452";
    
    public static final int USER_REMIND_KF_REDIS_EXPIRE_TIME = 24 * 3600;
    
    public static final String SEND_BOSS_WX_PAY_BY_USER_CONFIRM_SMS = "#shop_name#={shop_name}&#date#={date}&#total_count#={totalCount}&#total_price#={total_price}&#confirm_count#={confirm_count}&#confirm_price#={confirm_price}&#final_confirm_price#={final_confirm_price}";
    
    public static final String SEND_BOSS_WX_PAY_BY_USER_CONFIRM_SMS_TID = "2484";
    
    public static final String USER_CONFIRM_BEGIN_TIME = "2015-04-21 00:00:00";
    
    public static final int RECEIVE_CODE_COUNT = 4;
    
    public static final String RECEIVE_CODE_SMS_TID= "2632";
    
    public static final String RECEIVE_CODE_SMS = "#shop_name#={shop_name}&#create_time#={create_time}&#order_id#={order_id}&#receive_code#={receive_code}";
    
    public static final String CONFIR_WX_REMARK = "您{create_time}在{shop_name}下的订单{order_id}已确认配送，收到商品您可以点击“确认收货”，未“确认收货”订单将在12小时后自动完成；\n 如有疑问请联系喵喵客服4008816807。";
    
    public static final String CONFIR_USER_SMS = "#create_time#={create_time}&#shop_name#={shop_name}&#order_id#={order_id}";
	
    public static final String CONFIR_USER_SMS_TID = "2675";
    
    public static final String ORDER_CONFIRM = "确认收货";
    
    public static final int CANNOTUSETICKET_CODE = 12;
    
    public static  final int TMPPAYERROR_CODE = 401;
    
    public static  final int IS_LOGIN = 1;
    
    public static final String WX_PAY_APP = "APP";
    
    public static final  String  WX_PAY_JSAPI = "JSAPI";
    
    
    public static String mch_appid = "wx762f832959951212";
    
    public static int DEFAULT_DISCTOUN = 5;
    
    public static final String NEW_COUPON_REMARK = "感谢您对喵喵的支持，喵喵送您{price}元代金券，请进入喵喵生活公众号-我的代金券查看。查看详情>";
    
    public static final String NEW_COUPON_TITLE = "喵喵代金券";
    
    public static final String WX_JUMP_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx762f832959951212&redirect_uri={url}&response_type=code&scope=snsapi_base&state=128#wechat_redirect";
    
    public static final String SUGGESTION_QUERY_URL = "http://10.170.239.52:8888/suggestion/query?q={q}&shop_id={shop_id}&count=50";

    public static final String GET_SHOP_WALLET_BEGIN_DATE = "2015-06-01 00:00:00";
    
    public static final int CASH_TYPE_INCOME = 1;
    
    public static final int CASH_TYPE_OUT = 0;
    
    public static final int IS_EXIST_SHOP_GETCASH_ITEM = 2;
    
    public static List<String> GET_CASH_PROMPT_MSG_LIST = null;
    
    public static final String GET_CASH_2_BOSS_SMS_MSG = "#date#={date}&#price#={price}";
    
    public static final String GET_CASH_2_BOSS_SMS_TID = "3049";
    
    public static final String VERIFY_CODE_USER_APP = "#code#={code}";
    
    public static final String APPLE_TEST_VERIFY_PHONE = "11223345679";
    
    static{
    	GET_CASH_PROMPT_MSG_LIST = new ArrayList<String>();
    	GET_CASH_PROMPT_MSG_LIST.add("每天可提现一次");
    	GET_CASH_PROMPT_MSG_LIST.add("周一至周六500元起可提现");
    	GET_CASH_PROMPT_MSG_LIST.add("周日不限制金额提现");
    	GET_CASH_PROMPT_MSG_LIST.add("提现预计到账时间：次日中午12点，具体到账时间以银行信息为准");
    }
}