/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.bpl.tucao.entity.BplTucao;
import com.bpl.tucao.dao.BplTucaoDao;

/**
 * 吐槽流水记录Service
 * @author bpl
 * @version 2017-08-10
 */
@Service
@Transactional(readOnly = true)
public class BplTucaoService extends CrudService<BplTucaoDao, BplTucao> {

	public BplTucao get(String id) {
		return super.get(id);
	}
	
	public List<BplTucao> findList(BplTucao bplTucao) {
		return super.findList(bplTucao);
	}
	
	public Page<BplTucao> findPage(Page<BplTucao> page, BplTucao bplTucao) {
		return super.findPage(page, bplTucao);
	}
	
	@Transactional(readOnly = false)
	public void save(BplTucao bplTucao) {
		super.save(bplTucao);
	}
	
	@Transactional(readOnly = false)
	public void delete(BplTucao bplTucao) {
		super.delete(bplTucao);
	}
	
}