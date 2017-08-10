/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.bpl.tucao.entity.BplComment;
import com.bpl.tucao.dao.BplCommentDao;

/**
 * 吐槽评论Service
 * @author bpl
 * @version 2017-08-10
 */
@Service
@Transactional(readOnly = true)
public class BplCommentService extends CrudService<BplCommentDao, BplComment> {

	public BplComment get(String id) {
		return super.get(id);
	}
	
	public List<BplComment> findList(BplComment bplComment) {
		return super.findList(bplComment);
	}
	
	public Page<BplComment> findPage(Page<BplComment> page, BplComment bplComment) {
		return super.findPage(page, bplComment);
	}
	
	@Transactional(readOnly = false)
	public void save(BplComment bplComment) {
		super.save(bplComment);
	}
	
	@Transactional(readOnly = false)
	public void delete(BplComment bplComment) {
		super.delete(bplComment);
	}
	
}