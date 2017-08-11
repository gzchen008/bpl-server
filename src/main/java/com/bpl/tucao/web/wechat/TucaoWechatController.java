package com.bpl.tucao.web.wechat;

import com.bpl.tucao.entity.BplComment;
import com.bpl.tucao.entity.BplHot;
import com.bpl.tucao.entity.BplTucao;
import com.bpl.tucao.entity.BplUser;
import com.bpl.tucao.service.BplCommentService;
import com.bpl.tucao.service.BplHotService;
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

    @Autowired
    private BplHotService bplHotService;

    @Autowired
    private BplCommentService bplCommentService;

    @RequestMapping("/listComment")
    public void listComment(Integer hotId, HttpServletResponse response) {
        BplComment bplComment = new BplComment();
        bplComment.setHotid(hotId);
        List<BplComment> comments = bplCommentService.findList(bplComment);
        renderString(response, comments);
    }

    @RequestMapping("/listHot")
    public void listHot(Integer pageNo, HttpServletResponse response) {
        Page<BplHot> page = new Page<BplHot>();
        Page<BplHot> resPage = bplHotService.findPage(page, new BplHot());
        renderString(response, resPage.getList());
    }

    @RequestMapping("/add")
    public void add(String content, HttpServletResponse response, HttpSession httpSession) {
        Map<String, Object> result = Maps.newHashMap();
        // get user
        BplUser user = (BplUser) httpSession.getAttribute(SessionUtils.USER_INFO);
        if (user == null) {
            return;
        }

        BplTucao bplTucao = new BplTucao();
        Date time = new Date();
        bplTucao.setContent(content);
        bplTucao.setCreateTime(time);
        bplTucao.setUpdateTime(time);
        bplTucao.setFlag("0");
        bplTucao.setNickName(user.getNickName());
        bplTucao.setGender(user.getGender());

        bplTucaoService.save(bplTucao);
        result.put("code", 0);
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
