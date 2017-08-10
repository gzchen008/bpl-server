/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.bpl.tucao.entity.BplLike;
import com.bpl.tucao.dao.BplLikeDao;

/**
 * 吐槽点赞表Service
 * @author bpl
 * @version 2017-08-10
 */
@Service
@Transactional(readOnly = true)
public class BplLikeService extends CrudService<BplLikeDao, BplLike> {

	public BplLike get(String id) {
		return super.get(id);
	}
	
	public List<BplLike> findList(BplLike bplLike) {
		return super.findList(bplLike);
	}
	
	public Page<BplLike> findPage(Page<BplLike> page, BplLike bplLike) {
		return super.findPage(page, bplLike);
	}
	
	@Transactional(readOnly = false)
	public void save(BplLike bplLike) {
		super.save(bplLike);
	}
	
	@Transactional(readOnly = false)
	public void delete(BplLike bplLike) {
		super.delete(bplLike);
	}
	
}