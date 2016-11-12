/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package com.renren.ntc.sg.util.wxpay.https;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;

import com.renren.ntc.sg.service.LoggerUtils;
import com.renren.ntc.sg.util.Constants;
import com.renren.ntc.sg.util.SUtils;
import com.renren.ntc.sg.util.wx.Sha1Util;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * This example demonstrates how to create secure connections with a custom SSL
 * context.
 */
public class ClientCustomSSL {

    private static final String TXT = "<xml>\n" +
            "   <mch_appid>{mch_appid}</mch_appid>\n" +
            "   <mchid>{mchid}</mchid>\n" +
            "   <openid>{openid}</openid>\n" +
            "   <mch_id>{mch_id}</mch_id>\n" +
            "   <nonce_str>{nonce_str}</nonce_str>\n" +
            "   <partner_trade_no>{partner_trade_no}</partner_trade_no>\n" +
            "   <check_name>{check_name}</check_name>\n" +
            "   <re_user_name>{re_user_name}</re_user_name>\n" +
            "   <amount>{amount}</amount>\n" +
            "   <desc>{desc}</desc>\n" +
            "   <spbill_create_ip>{spbill_create_ip}</spbill_create_ip>\n" +
            "   <sign>{sign}</sign>\n" +
            "</xml>"  ;

    public final static void main(String[] args) throws Exception {
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File("/Users/allenz/Downloads/wx_cert/apiclient_cert.p12"));
        try {
            keyStore.load(instream, Constants.mch_id.toCharArray());
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, Constants.mch_id.toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        try {

            HttpPost post = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers");
            System.out.println("executing request" + post.getRequestLine());


            String openid = "oQfDLjmZD7Lgynv6vuoBlWXUY_ic";
            String nonce_str = Sha1Util.getNonceStr();
            String orderId = SUtils.getOrderId();
            String re_user_name = "朱允铭";
            String amount = "1";
            String desc = "付费测试";
            String spbill_create_ip = "123.56.102.224";

            String txt = TXT.replace("{mch_appid}",Constants.mch_appid);
            txt = txt.replace("{mchid}",Constants.mch_id);
            txt = txt.replace("{openid}",openid);
            txt = txt.replace("{nonce_str}",nonce_str);
            txt = txt.replace("{partner_trade_no}",orderId);
            txt = txt.replace("{check_name}","FORCE_CHECK");
            txt = txt.replace("{re_user_name}",re_user_name);
            txt = txt.replace("{amount}",amount);
            txt = txt.replace("{desc}",desc);
            txt = txt.replace("{spbill_create_ip}",spbill_create_ip);


            SortedMap<String,String> map =  new TreeMap<String,String>() ;
            map.put("mch_appid", Constants.mch_appid);
            map.put("mchid", Constants.mch_id);
            map.put("openid", openid);
            map.put("nonce_str", nonce_str);
            map.put("partner_trade_no", orderId);
            //FORCE_CHECK| OPTION_CHECK | NO_CHECK
            map.put("check_name", "OPTION_CHECK");
            map.put("re_user_name",re_user_name);
            map.put("amount", amount);
            map.put("desc", desc);
            map.put("spbill_create_ip", spbill_create_ip);

            String sign =  SUtils.createSign(map).toUpperCase() ;
            txt = txt.replace("{sign}",sign);

            post.setEntity(new StringEntity(txt,"utf-8"));

            CloseableHttpResponse response = httpclient.execute(post);
            try {
                HttpEntity entity = response.getEntity();

                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String text;
                    StringBuffer  sb  = new StringBuffer();
                    while ((text = bufferedReader.readLine()) != null) {
                        sb.append(text);
                    }
                    String resp = sb.toString();
                    LoggerUtils.getInstance().log(String.format("req %s rec %s", txt, resp));
                    if(isOk(resp)){

                        String payment_no = getValue(resp, "payment_no");
                        LoggerUtils.getInstance().log(String.format("order %s pay OK   payment_no %s",orderId , payment_no));
                    }

                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

    private static boolean isOk(String resp) {
        if ("SUCCESS".equals(getValue(resp, "return_code"))){
            return true;
        }
        return false;
    }

    private static String getValue(String str, String key) {
            String s = "<" + key + "><![CDATA[";
            String e = "]]></" + key + ">";
            int start = str.indexOf(s);
            int end = str.indexOf(e);
            if (-1 == start ||  -1 == end){
                return "" ;
            }
            return str.substring( s.length() + start ,end);
        }

}
