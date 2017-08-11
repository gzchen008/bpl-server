package com.bpl.tucao.dao;

import com.bpl.tucao.vo.HotFeedBackVo;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import java.util.List;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/11 0011.
 */
@MyBatisDao
public interface BplFeedBackWxDao {
    List<HotFeedBackVo> findOne(Integer hotId);
}
