/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.bpl.tucao.entity.BplFeedback;
import com.bpl.tucao.service.BplFeedbackService;

/**
 * 吐槽反馈Controller
 * @author bpl
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplFeedback")
public class BplFeedbackController extends BaseController {

	@Autowired
	private BplFeedbackService bplFeedbackService;
	
	@ModelAttribute
	public BplFeedback get(@RequestParam(required=false) String id) {
		BplFeedback entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bplFeedbackService.get(id);
		}
		if (entity == null){
			entity = new BplFeedback();
		}
		return entity;
	}
	
	@RequiresPermissions("tucao:bplFeedback:view")
	@RequestMapping(value = {"list", ""})
	public String list(BplFeedback bplFeedback, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BplFeedback> page = bplFeedbackService.findPage(new Page<BplFeedback>(request, response), bplFeedback); 
		model.addAttribute("page", page);
		return "bpl/tucao/bplFeedbackList";
	}

	@RequiresPermissions("tucao:bplFeedback:view")
	@RequestMapping(value = "form")
	public String form(BplFeedback bplFeedback, Model model) {
		model.addAttribute("bplFeedback", bplFeedback);
		return "bpl/tucao/bplFeedbackForm";
	}

	@RequiresPermissions("tucao:bplFeedback:edit")
	@RequestMapping(value = "save")
	public String save(BplFeedback bplFeedback, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bplFeedback)){
			return form(bplFeedback, model);
		}
		bplFeedbackService.save(bplFeedback);
		addMessage(redirectAttributes, "保存吐槽反馈成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplFeedback/?repage";
	}
	
	@RequiresPermissions("tucao:bplFeedback:edit")
	@RequestMapping(value = "delete")
	public String delete(BplFeedback bplFeedback, RedirectAttributes redirectAttributes) {
		bplFeedbackService.delete(bplFeedback);
		addMessage(redirectAttributes, "删除吐槽反馈成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplFeedback/?repage";
	}

}