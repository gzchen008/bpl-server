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
import com.bpl.tucao.entity.BplTucao;
import com.bpl.tucao.service.BplTucaoService;

/**
 * 吐槽流水记录Controller
 * @author bpl
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplTucao")
public class BplTucaoController extends BaseController {

	@Autowired
	private BplTucaoService bplTucaoService;
	
	@ModelAttribute
	public BplTucao get(@RequestParam(required=false) String id) {
		BplTucao entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bplTucaoService.get(id);
		}
		if (entity == null){
			entity = new BplTucao();
		}
		return entity;
	}
	
	//@RequiresPermissions("tucao:bplTucao:view")
	@RequestMapping(value = {"list", ""})
	public String list(BplTucao bplTucao, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BplTucao> page = bplTucaoService.findPage(new Page<BplTucao>(request, response), bplTucao); 
		model.addAttribute("page", page);
		return "bpl/tucao/bplTucaoList";
	}

	@RequiresPermissions("tucao:bplTucao:view")
	@RequestMapping(value = "form")
	public String form(BplTucao bplTucao, Model model) {
		model.addAttribute("bplTucao", bplTucao);
		return "bpl/tucao/bplTucaoForm";
	}

	@RequiresPermissions("tucao:bplTucao:edit")
	@RequestMapping(value = "save")
	public String save(BplTucao bplTucao, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bplTucao)){
			return form(bplTucao, model);
		}
		bplTucaoService.save(bplTucao);
		addMessage(redirectAttributes, "保存吐槽流水记录成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplTucao/?repage";
	}
	
	@RequiresPermissions("tucao:bplTucao:edit")
	@RequestMapping(value = "delete")
	public String delete(BplTucao bplTucao, RedirectAttributes redirectAttributes) {
		bplTucaoService.delete(bplTucao);
		addMessage(redirectAttributes, "删除吐槽流水记录成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplTucao/?repage";
	}

}