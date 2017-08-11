package com.bpl.tucao.web.wechat;

import com.bpl.tucao.entity.BplTucao;
import com.bpl.tucao.entity.BplUser;
import com.bpl.tucao.service.BplTucaoService;
import com.bpl.tucao.service.BplUserService;
import com.bpl.tucao.utils.SessionUtils;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cgzchen on 2017/8/10.
 * 吐槽微信控制器
 */
@RequestMapping("/wx/tucao")
@Controller
public class TucaoWechatController extends BaseController {

    @Autowired
    private BplTucaoService bplTucaoService;

    @Autowired
    private BplUserService bplUserService;

    @RequestMapping("/add")
    public void add(String sessionId, String content, HttpServletResponse response, HttpSession httpSession) {
        // get user
        String openId = SessionUtils.getOpenId(httpSession, sessionId);
        BplUser user = getUserByOpenId(openId);

        BplTucao bplTucao = new BplTucao();
        Map<String, Object> result = Maps.newHashMap();
        Date time = new Date();
        bplTucao.setContent(content);
        bplTucao.setCreateTime(time);
        bplTucao.setUpdateTime(time);
        bplTucao.setFlag("0");

        bplTucao.setNickName(user.getNickName());
        bplTucao.setGender(user.getGender());

        bplTucaoService.save(bplTucao);
        result.put("msg", "success");
        renderString(response, result);
    }

    private BplUser getUserByOpenId(String openId) {
        BplUser user = new BplUser();
        user.setOpenid(openId);
        List<BplUser> userList = bplUserService.findList(user);
        return userList.size() > 0 ? userList.get(0) : null;
    }

    @RequestMapping("/list")
    public void list(Integer pageNo, HttpServletResponse response) {
        Page<BplTucao> page = new Page<BplTucao>();
        page.setPageNo(pageNo);
        Page<BplTucao> resPage = bplTucaoService.findPage(page, new BplTucao());
        renderString(response, resPage.getList());
    }

}
