/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.bpl.tucao.entity.BplHot;

import java.util.List;

/**
 * 吐槽热点DAO接口
 * @author yongdaicui
 * @version 2017-08-11
 */
@MyBatisDao
public interface BplHotDao extends CrudDao<BplHot> {
	List<BplHot> generateWeekly();
    List<BplHot> generateHistory();
    List<BplHot> generateWeeklyDone();
}