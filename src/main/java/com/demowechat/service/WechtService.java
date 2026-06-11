package com.demowechat.service;

import com.alibaba.fastjson.JSONObject;
import com.demowechat.util.HttpClientUtil;
import com.demowechat.vo.WechatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WechtService {

    @Autowired
    private HttpClientUtil httpClientUtil;

    public WechatVO signature(String url)  throws  Exception{

        Map<String, String> getAtParams=new HashMap<>();
        String appId="wx47f4f4af96ae80db";
        String secret="ee6961ba7e7dbc9d96f4c38a5e2659e2";
        getAtParams.put("appid", appId);
        getAtParams.put("secret", secret);
        getAtParams.put("grant_type", "client_credential");
        String getAtUrl="https://api.weixin.qq.com/cgi-bin/token";
        String accessToken= JSONObject.parseObject(httpClientUtil.get(getAtUrl, getAtParams)).getString("access_token");

        Map<String, String> getTicketParams=new HashMap<>();
        getTicketParams.put("access_token", accessToken);
        getTicketParams.put("type", "jsapi");
        String getTicketUrl="https://api.weixin.qq.com/cgi-bin/ticket/getticket";
        String jsapiTicket=JSONObject.parseObject(httpClientUtil.get(getTicketUrl, getTicketParams)).getString("ticket");
        System.out.println(jsapiTicket);
        String nonceStr = UUID.randomUUID()
                .toString()
                .replace("-", "");

        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        String str="jsapi_ticket="+jsapiTicket+"&"+"noncestr="+nonceStr+"&"+"timestamp="+timestamp+"&"+"url="+url;
        System.out.println(str);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            WechatVO wechatVO=new WechatVO();
            wechatVO.setSignature(sb.toString());
            wechatVO.setNonceStr(nonceStr);
            wechatVO.setTimestamp(timestamp);
            wechatVO.setAppId(appId);
            return wechatVO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
