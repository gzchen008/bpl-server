package com.bpl.tucao.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by johnnwang on 2017/8/10.
 */
public class WeixinUtil {

    public static String appid = "wx61e6d99d24b1a8a3";
    public static String secret = "76c15d0fd330d80f9fd815b77854a71d";
    public static String grantType = "authorization_code";
    public static String sessionHost = "https://api.weixin.qq.com/sns/jscode2session";

    public static  Map<String,Object> getWxSession(String wxCode) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("appid=").append(appid);
        sb.append("&secret=").append(secret);
        sb.append("&js_code=").append(wxCode);
        sb.append("&grant_type=").append(grantType);
        String res = HttpRequest.sendGet(sessionHost, sb.toString());
        if(res == null || res.equals("")){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper(); //转换器
        return mapper.readValue(res, Map.class);
    }
}
