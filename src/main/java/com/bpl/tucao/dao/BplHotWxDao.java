package com.bpl.tucao.dao;

import com.bpl.tucao.vo.HotSummaryVo;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/10 0010.
 */

@MyBatisDao
public interface BplHotWxDao {
    List<HotSummaryVo> findAllHotSummary(@Param("userId") Integer userId, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
    int updateLikeCount(@Param("hotId") Integer hotId);
}
