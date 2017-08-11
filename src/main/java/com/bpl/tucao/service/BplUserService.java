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
import com.bpl.tucao.entity.BplUser;
import com.bpl.tucao.dao.BplUserDao;

/**
 * 用户Service
 * @author bplteam
 * @version 2017-08-10
 */
@Service
@Transactional(readOnly = true)
public class BplUserService extends CrudService<BplUserDao, BplUser> {
	@Autowired
	protected BplUserDao bplUserDao;

	public BplUser get(String id) {
		return super.get(id);
	}

	public BplUser saveOrget(BplUser bplUser) {
		BplUser userInfo = bplUserDao.findByOppenid(bplUser.getOpenid());
		if (userInfo == null){
			int id = bplUserDao.insert(bplUser);
			userInfo = bplUserDao.get(""+id);
		}
		return userInfo;
	}

	public List<BplUser> findList(BplUser bplUser) {
		return super.findList(bplUser);
	}
	
	public Page<BplUser> findPage(Page<BplUser> page, BplUser bplUser) {
		return super.findPage(page, bplUser);
	}
	
	@Transactional(readOnly = false)
	public void save(BplUser bplUser) {
		super.save(bplUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(BplUser bplUser) {
		super.delete(bplUser);
	}
	
}