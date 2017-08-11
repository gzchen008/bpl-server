package com.bpl.tucao.dao;

import com.bpl.tucao.entity.BplComment;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/11 0011.
 */

@MyBatisDao
public interface BplHotCommentWxDao {

    int insert(BplComment comment);
}
