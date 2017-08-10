package com.bpl.tucao.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by johnnwang on 2017/8/10.
 */
@Controller
@RequestMapping(value = "/weixin")
public class BplWeixinController {
    private static final Logger LOGGER = Logger.getLogger(BplWeixinController.class);
    @RequestMapping(value = "/login")
    @ResponseBody
     public String login(String id){
         LOGGER.info("login");
         System.out.println("登录");
         return "success";
     }
}
