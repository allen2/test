package com.renren.ntc.sg.util.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public  class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088911412285120";

	//seller id
	public static String seller_id = "luziyu@lizi-inc.com";

	public static String char_set = "utf-8";

	// 商户的私钥
	//public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMFkeafXW2i09LjXKiwKT76QaDwQk1LXBTce8Sm7YoHqQ1C2ZXVoJzvJMrIMU9MYMTewbZHtRtvXH7HUimX0wP4FhYkVdfk3gUHsm3AW7bBDDwdMNm0lkgxeKREBOp2ODfkagjklDxWftqsQfaO25Bu40YYEBJSzhg1ILOM7tPXXAgMBAAECgYALVxv3Jp66lhnfmOZlLLmeYBNsqkApVGh";
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMFkeafXW2i09LjXKiwKT76QaDwQk1LXBTce8Sm7YoHqQ1C2ZXVoJzvJMrIMU9MYMTewbZHtRtvXH7HUimX0wP4FhYkVdfk3gUHsm3AW7bBDDwdMNm0lkgxeKREBOp2ODfkagjklDxWftqsQfaO25Bu40YYEBJSzhg1ILOM7tPXXAgMBAAECgYALVxv3Jp66lhnfmOZlLLmeYBNsqkApVGh+4facTtuo6JbH7donN1NNoy+w1x43O6zvKg5Sx0onbAb0w5TWA7MpV9r/OsnAG+45iBfmXnCYwY2aBTz0hOCGxxdx27ewpgjRJts+F34BgDY0/mONc4+z0lUlp6VjMdDFoNNanXiMmQJBAPrh3SBYh/Jr6uih22jfXhQoJxcxV88ylHZnrFZih+ILHBMuHE9Sm+8ymp5+ijV/lrnIEsT8IJwg++giNk9mvLsCQQDFVmSgpiR8BKfMQaCDwgjDj9bCLYjbu3x15W9hqimstoK4kFXw+aDHHiFTYkyoayfMz8NDoGl8c49v1J8lQAeVAkEArvWkyFH1PNKV1/ZIlTJw4Y2+9SWsHwsfDhPu06+TI8iro5ScmZT6ui2INs/4gqaf7p/gtw89jqRSCOkTBvyW0QJAHgeQlpXR1YGL21xdRc+gL8pSvwfY3L9CKFq6wVz4rIy1hcqJGXuTSNm/7oV17ucnjlZLe54Mj2Cygi0T7sI4pQJAcGi/L8d2RFG0EOGf35OpnrvWxreD3WmoRaXJwyT0LtuDYIkd5dv2/RS5ZEIBuqNZThH6DkIhejZssW9u6Klm1Q==";
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "/";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
