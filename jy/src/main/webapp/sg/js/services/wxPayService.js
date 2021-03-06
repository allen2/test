;
angular.module('miaomiao.shop').factory('WeiChatPay', function ($http, MMUtils, httpClient,ShopService) {

    var weiChatPayUtils = {},
        wechatConfig = {
        appId: 'wx762f832959951212',
        mch_id: '1233699402'
    };

    if (typeof(wx) == 'undefined') {
        console.log('Error' + "微信js-sdk 没有加载");
        MMUtils.showAlert('微信js-sdk 没有加载');
        return weiChatPayUtils;
    }

    weiChatPayUtils.initConfig = function(wpconfig){
        // init the api
        var config = {
//            'debug': true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            'appId': wechatConfig.appId, // 必填，公众号的唯一标识
            'jsApiList': ['chooseWXPay']
        };

        config.signature = wpconfig.signature;
        config.nonceStr = wpconfig.nonceStr;
        config.timestamp = wpconfig.timestamp;

        wx.config(config);

        wx.error(function (res) {
            // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
        });

        wx.ready(function () {
        });
    };

    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。

    weiChatPayUtils.checkPayAPI = function (success, fail) {
        wx.checkJsApi({
            jsApiList: ['chooseWXPay'],
            success: function (res) {
                if (res.checkResult.chooseWXPay) {
                    success();
                } else {
                    fail();
                }
            },
            fail: function () {
                fail();
            }
        });
    };

    weiChatPayUtils.chooseWXPay = function (info, success, fail) {

        info.success = function (res) {

            if (res.errMsg == "chooseWXPay:ok") {
                success(res.errMsg);
            } else {
                fail('支付失败:' + res.errMsg);
            }    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
        };

        info.fail = function(res){
            fail('支付失败:JS-API失败');
            httpClient.postCirticallog('支付JS-API失败:'+ JSON.stringify(res),null,null);
        };

        info.cancel = function(res){
            fail('支付取消');
        };

        wx.chooseWXPay(info);

    };

    return weiChatPayUtils;

});
