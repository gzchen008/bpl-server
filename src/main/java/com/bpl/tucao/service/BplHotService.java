/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.bpl.tucao.entity.BplHot;
import com.bpl.tucao.dao.BplHotDao;

/**
 * 吐槽热点Service
 * @author yongdaicui
 * @version 2017-08-11
 */
@Service
@Transactional(readOnly = true)
public class BplHotService extends CrudService<BplHotDao, BplHot> {
    @Autowired
	private BplHotDao bplHotDao;
	public BplHot get(String id) {
		return super.get(id);
	}
	
	public List<BplHot> findList(BplHot bplHot) {
		return super.findList(bplHot);
	}
	
	public Page<BplHot> findPage(Page<BplHot> page, BplHot bplHot) {
		return super.findPage(page, bplHot);
	}
	
	@Transactional(readOnly = false)
	public void save(BplHot bplHot) {
		super.save(bplHot);
	}
	
	@Transactional(readOnly = false)
	public void delete(BplHot bplHot) {
		super.delete(bplHot);
	}

	public List<BplHot> generateWeekly(){ return  bplHotDao.generateWeekly(); }
	public List<BplHot> generateHistory(){ return  bplHotDao.generateHistory(); }
	public List<BplHot> generateWeeklyDone(){ return  bplHotDao.generateWeeklyDone(); }
}