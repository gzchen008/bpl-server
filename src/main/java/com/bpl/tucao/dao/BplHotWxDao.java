package com.bpl.tucao.dao;

import com.bpl.tucao.vo.HotSummaryVo;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import java.util.List;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/10 0010.
 */

@MyBatisDao
public interface BplHotWxDao {
    List<HotSummaryVo> findAllHotSummary(Integer userId);
}
