/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.bpl.tucao.entity.BplComment;

/**
 * 吐槽评论DAO接口
 * @author bpl
 * @version 2017-08-10
 */
@MyBatisDao
public interface BplCommentDao extends CrudDao<BplComment> {
	
}