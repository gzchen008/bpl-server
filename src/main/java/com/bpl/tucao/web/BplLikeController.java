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
import com.bpl.tucao.entity.BplLike;
import com.bpl.tucao.service.BplLikeService;

/**
 * 吐槽点赞表Controller
 * @author bpl
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplLike")
public class BplLikeController extends BaseController {

	@Autowired
	private BplLikeService bplLikeService;
	
	@ModelAttribute
	public BplLike get(@RequestParam(required=false) String id) {
		BplLike entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bplLikeService.get(id);
		}
		if (entity == null){
			entity = new BplLike();
		}
		return entity;
	}
	
	@RequiresPermissions("tucao:bplLike:view")
	@RequestMapping(value = {"list", ""})
	public String list(BplLike bplLike, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BplLike> page = bplLikeService.findPage(new Page<BplLike>(request, response), bplLike); 
		model.addAttribute("page", page);
		return "bpl/tucao/bplLikeList";
	}

	@RequiresPermissions("tucao:bplLike:view")
	@RequestMapping(value = "form")
	public String form(BplLike bplLike, Model model) {
		model.addAttribute("bplLike", bplLike);
		return "bpl/tucao/bplLikeForm";
	}

	@RequiresPermissions("tucao:bplLike:edit")
	@RequestMapping(value = "save")
	public String save(BplLike bplLike, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bplLike)){
			return form(bplLike, model);
		}
		bplLikeService.save(bplLike);
		addMessage(redirectAttributes, "保存吐槽点赞成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplLike/?repage";
	}
	
	@RequiresPermissions("tucao:bplLike:edit")
	@RequestMapping(value = "delete")
	public String delete(BplLike bplLike, RedirectAttributes redirectAttributes) {
		bplLikeService.delete(bplLike);
		addMessage(redirectAttributes, "删除吐槽点赞成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplLike/?repage";
	}

}