package com.bpl.tucao.utils;

import com.bpl.tucao.entity.BplUser;
import com.thinkgem.jeesite.common.utils.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cgzchen on 2017/8/11.
 */
public class SessionUtils {

    public static final String KEY_3_RD = "key3rd";

    public static Map<String,Object> session = new ConcurrentHashMap();

    public static String getOpenId(HttpSession httpSession, String key3rd) {
        String sessionValue = (String) httpSession.getAttribute(key3rd);
        if (!StringUtils.isEmpty(sessionValue)) {
            String openId = sessionValue.split("#")[1];
            return openId;
        }
        return null;
    }
}
