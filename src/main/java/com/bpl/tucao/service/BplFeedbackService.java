/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.bpl.tucao.entity.BplFeedback;
import com.bpl.tucao.dao.BplFeedbackDao;

/**
 * 吐槽反馈Service
 * @author bpl
 * @version 2017-08-10
 */
@Service
@Transactional(readOnly = true)
public class BplFeedbackService extends CrudService<BplFeedbackDao, BplFeedback> {

	public BplFeedback get(String id) {
		return super.get(id);
	}
	
	public List<BplFeedback> findList(BplFeedback bplFeedback) {
		return super.findList(bplFeedback);
	}
	
	public Page<BplFeedback> findPage(Page<BplFeedback> page, BplFeedback bplFeedback) {
		return super.findPage(page, bplFeedback);
	}
	
	@Transactional(readOnly = false)
	public void save(BplFeedback bplFeedback) {
		super.save(bplFeedback);
	}
	
	@Transactional(readOnly = false)
	public void delete(BplFeedback bplFeedback) {
		super.delete(bplFeedback);
	}
	
}