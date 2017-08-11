package com.bpl.tucao.utils;

import com.bpl.tucao.entity.BplUser;
import com.thinkgem.jeesite.common.utils.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Created by cgzchen on 2017/8/11.
 */
public class SessionUtils {


    public static String getOpenId(HttpSession httpSession, String sessionId) {
        String sessionValue = (String) httpSession.getAttribute(sessionId);
        if (!StringUtils.isEmpty(sessionValue)) {
            String openId = sessionValue.split("#")[1];
            return openId;
        }
        return null;
    }
}
