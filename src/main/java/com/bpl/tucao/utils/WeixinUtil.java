package com.bpl.tucao.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Created by johnnwang on 2017/8/10.
 */
public class WeixinUtil {

    public static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);

    public static String appid = "wx45eb557c5f16bedd";
    public static String secret = "96b545fa8d0f3b37a752e3a7c80a5bdb";
    public static String grantType = "authorization_code";
    public static String sessionHost = "https://api.weixin.qq.com/sns/jscode2session";

    public static  Map<String,Object> getWxSession(String wxCode) throws IOException {
        StringBuffer sb = new StringBuffer();

        sb.append("appid=").append(appid);
        sb.append("&secret=").append(secret);
        sb.append("&js_code=").append(wxCode);
        sb.append("&grant_type=").append(grantType);
        //logger
        String res = HttpRequest.sendGet(sessionHost, sb.toString());
        if(res == null || res.equals("")){
            logger.error("Failed to get session");
            return null;
        }
        ObjectMapper mapper = new ObjectMapper(); //转换器
        return mapper.readValue(res, Map.class);
    }
    public static void   main(String[] args) throws IOException {
        Map<String,Object>  res = WeixinUtil.getWxSession("003HsrTz1BgIPh0mbLUz1oEGTz1HsrTL");
        Set<Map.Entry<String, Object>> entries = res.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }
}
