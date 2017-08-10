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
import com.bpl.tucao.entity.BplComment;
import com.bpl.tucao.service.BplCommentService;

/**
 * 吐槽评论Controller
 * @author bpl
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tucao/bplComment")
public class BplCommentController extends BaseController {

	@Autowired
	private BplCommentService bplCommentService;
	
	@ModelAttribute
	public BplComment get(@RequestParam(required=false) String id) {
		BplComment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bplCommentService.get(id);
		}
		if (entity == null){
			entity = new BplComment();
		}
		return entity;
	}
	
	@RequiresPermissions("tucao:bplComment:view")
	@RequestMapping(value = {"list", ""})
	public String list(BplComment bplComment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BplComment> page = bplCommentService.findPage(new Page<BplComment>(request, response), bplComment); 
		model.addAttribute("page", page);
		return "bpl/tucao/bplCommentList";
	}

	@RequiresPermissions("tucao:bplComment:view")
	@RequestMapping(value = "form")
	public String form(BplComment bplComment, Model model) {
		model.addAttribute("bplComment", bplComment);
		return "bpl/tucao/bplCommentForm";
	}

	@RequiresPermissions("tucao:bplComment:edit")
	@RequestMapping(value = "save")
	public String save(BplComment bplComment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bplComment)){
			return form(bplComment, model);
		}
		bplCommentService.save(bplComment);
		addMessage(redirectAttributes, "保存吐槽评论成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplComment/?repage";
	}
	
	@RequiresPermissions("tucao:bplComment:edit")
	@RequestMapping(value = "delete")
	public String delete(BplComment bplComment, RedirectAttributes redirectAttributes) {
		bplCommentService.delete(bplComment);
		addMessage(redirectAttributes, "删除吐槽评论成功");
		return "redirect:"+Global.getAdminPath()+"/tucao/bplComment/?repage";
	}

}