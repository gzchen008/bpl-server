/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bpl.tucao.entity.BplComment;
import com.bpl.tucao.entity.BplFeedback;
import com.bpl.tucao.service.BplCommentService;
import com.bpl.tucao.service.BplFeedbackService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.bpl.tucao.entity.BplHot;
import com.bpl.tucao.service.BplHotService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 吐槽热点Controller
 *
 * @author yongdaicui
 * @version 2017-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplHot")
public class BplHotController extends BaseController {

    @Autowired
    private BplHotService bplHotService;

    @Autowired
    private BplCommentService bplCommentService;

    @Autowired
    private BplFeedbackService bplFeedbackService;

    @ModelAttribute
    public BplHot get(@RequestParam(required = false) String id) {
        BplHot entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = bplHotService.get(id);
        }
        if (entity == null) {
            entity = new BplHot();
        }
        return entity;
    }

    @RequiresPermissions("tucao:bplHot:view")
    @RequestMapping(value = {"list", ""})
    public String list(BplHot bplHot, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<BplHot> page = bplHotService.findPage(new Page<BplHot>(request, response), bplHot);
        model.addAttribute("page", page);

        List<BplHot> hotList = page.getList();
        //TODO
        List<BplComment> commentList = bplCommentService.findList(new BplComment());
        List<BplFeedback> feedbackList = bplFeedbackService.findList(new BplFeedback());

        for (BplHot hot : hotList) {
            Map<String, String> objMap = new HashMap<String, String>();
            hot.setSqlMap(objMap);
            for (BplComment comment : commentList) {
                if (comment.getHotid().toString().equals(hot.getId())) {
                    String newComment = hot.getSqlMap().get("comments") + "," + comment.getContent();
                    hot.getSqlMap().put("comments", newComment);
                }
            }
            for (BplFeedback feedback : feedbackList) {
                if (feedback.getHotid().toString().equals(hot.getId())) {
                    String newFeedback = hot.getSqlMap().get("feedbacks") == null ? "" : hot.getSqlMap().get("feedbacks") + "," + feedback.getContent();
                    hot.getSqlMap().put("feedbacks", newFeedback);
                }
            }
            logger.debug("hot:{}", hot);
        }


        model.addAttribute("page", page);
        return "bpl/tucao/bplHotList";
    }

    @RequiresPermissions("tucao:bplHot:view")
    @RequestMapping(value = "form")
    public String form(BplHot bplHot, Model model) {
        model.addAttribute("bplHot", bplHot);
        return "bpl/tucao/bplHotForm";
    }

    @RequiresPermissions("tucao:bplHot:edit")
    @RequestMapping(value = "save")
    public String save(BplHot bplHot, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, bplHot)) {
            return form(bplHot, model);
        }
        bplHotService.save(bplHot);
        if (bplHot.getRemarks() != null) {
            Date time = new Date();
            BplFeedback feedback = new BplFeedback();
            feedback.setHotid(Integer.valueOf(bplHot.getId()));
            feedback.setContent(bplHot.getRemarks());
            feedback.setStatus(bplHot.getStatus());
            feedback.setCreateTime(time);
            feedback.setUpdateTime(time);
            bplFeedbackService.save(feedback);
        }
        addMessage(redirectAttributes, "保存吐槽热点成功");
        return "redirect:" + Global.getAdminPath() + "/tucao/bplHot/?repage";
    }

    @RequiresPermissions("tucao:bplHot:edit")
    @RequestMapping(value = "delete")
    public String delete(BplHot bplHot, RedirectAttributes redirectAttributes) {
        bplHotService.delete(bplHot);
        addMessage(redirectAttributes, "删除吐槽热点成功");
        return "redirect:" + Global.getAdminPath() + "/tucao/bplHot/?repage";
    }

}