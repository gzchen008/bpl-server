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
import com.bpl.tucao.entity.BplUser;
import com.bpl.tucao.service.BplUserService;

/**
 * 用户Controller
 * @author bplteam
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplUser")
public class BplUserController extends BaseController {

	@Autowired
	private BplUserService bplUserService;
	
	@ModelAttribute
	public BplUser get(@RequestParam(required=false) String id) {
		BplUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bplUserService.get(id);
		}
		if (entity == null){
			entity = new BplUser();
		}
		return entity;
	}
	
	@RequiresPermissions("tucao:bplUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(BplUser bplUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BplUser> page = bplUserService.findPage(new Page<BplUser>(request, response), bplUser); 
		model.addAttribute("page", page);
		return "bpl/tucao/bplUserList";
	}

	@RequiresPermissions("tucao:bplUser:view")
	@RequestMapping(value = "form")
	public String form(BplUser bplUser, Model model) {
		model.addAttribute("bplUser", bplUser);
		return "bpl/tucao/bplUserForm";
	}

	@RequiresPermissions("tucao:bplUser:edit")
	@RequestMapping(value = "save")
	public String save(BplUser bplUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bplUser)){
			return form(bplUser, model);
		}
		bplUserService.save(bplUser);
		addMessage(redirectAttributes, "保存用户成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplUser/?repage";
	}
	
	@RequiresPermissions("tucao:bplUser:edit")
	@RequestMapping(value = "delete")
	public String delete(BplUser bplUser, RedirectAttributes redirectAttributes) {
		bplUserService.delete(bplUser);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplUser/?repage";
	}

}