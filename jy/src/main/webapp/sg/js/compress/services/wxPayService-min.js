angular.module("miaomiao.shop").factory("WeiChatPay",function($http,MMUtils,httpClient,ShopService){var weiChatPayUtils={},wechatConfig={appId:"wx762f832959951212",mch_id:"1233699402"};if(typeof(wx)=="undefined"){console.log("Error微信js-sdk 没有加载");MMUtils.showAlert("微信js-sdk 没有加载");return weiChatPayUtils;}weiChatPayUtils.initConfig=function(wpconfig){var config={appId:wechatConfig.appId,jsApiList:["chooseWXPay"]};config.signature=wpconfig.signature;config.nonceStr=wpconfig.nonceStr;config.timestamp=wpconfig.timestamp;wx.config(config);wx.error(function(res){});wx.ready(function(){});};weiChatPayUtils.checkPayAPI=function(success,fail){wx.checkJsApi({jsApiList:["chooseWXPay"],success:function(res){if(res.checkResult.chooseWXPay){success();}else{fail();}},fail:function(){fail();}});};weiChatPayUtils.chooseWXPay=function(info,success,fail){info.success=function(res){if(res.errMsg=="chooseWXPay:ok"){success(res.errMsg);}else{fail("支付失败:"+res.errMsg);}};info.fail=function(res){fail("支付失败:JS-API失败");httpClient.postCirticallog("支付JS-API失败:"+JSON.stringify(res),null,null);};info.cancel=function(res){fail("支付取消");};wx.chooseWXPay(info);};return weiChatPayUtils;});