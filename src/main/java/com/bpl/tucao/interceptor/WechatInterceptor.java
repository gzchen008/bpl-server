package com.bpl.tucao.interceptor;

import com.bpl.tucao.utils.SessionUtils;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by cgzchen on 2017/8/11.
 */
public class WechatInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WechatInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String key = (String) request.getSession().getAttribute(SessionUtils.KEY_3_RD);
        if (StringUtils.isEmpty(key)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put("code", -1);
            result.put("msg", "please login");

            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(JsonMapper.toJsonString(result));
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
