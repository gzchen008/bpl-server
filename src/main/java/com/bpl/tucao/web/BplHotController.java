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
import com.bpl.tucao.entity.BplHot;
import com.bpl.tucao.service.BplHotService;

/**
 * 吐槽热点Controller
 * @author yongdaicui
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplHot")
public class BplHotController extends BaseController {

	@Autowired
	private BplHotService bplHotService;
	
	@ModelAttribute
	public BplHot get(@RequestParam(required=false) String id) {
		BplHot entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bplHotService.get(id);
		}
		if (entity == null){
			entity = new BplHot();
		}
		return entity;
	}
	
	@RequiresPermissions("tucao:bplHot:view")
	@RequestMapping(value = {"list", ""})
	public String list(BplHot bplHot, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BplHot> page = bplHotService.findPage(new Page<BplHot>(request, response), bplHot); 
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
		if (!beanValidator(model, bplHot)){
			return form(bplHot, model);
		}
		bplHotService.save(bplHot);
		addMessage(redirectAttributes, "保存吐槽热点模块成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplHot/?repage";
	}
	
	@RequiresPermissions("tucao:bplHot:edit")
	@RequestMapping(value = "delete")
	public String delete(BplHot bplHot, RedirectAttributes redirectAttributes) {
		bplHotService.delete(bplHot);
		addMessage(redirectAttributes, "删除吐槽热点模块成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplHot/?repage";
	}

}