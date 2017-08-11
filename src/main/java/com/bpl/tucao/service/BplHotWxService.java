package com.bpl.tucao.service;

import com.bpl.tucao.dao.BplHotLikeWxDao;
import com.bpl.tucao.dao.BplHotWxDao;
import com.bpl.tucao.entity.BplLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/11 0011.
 */
@Service
public class BplHotWxService {

    @Autowired
    private BplHotWxDao hotWxDao;

    @Autowired
    private BplHotLikeWxDao hotLikeWxDao;

    @Transactional(readOnly = false)
    public int likeHot(BplLike like) {
        hotLikeWxDao.insert(like);
        return hotWxDao.updateLikeCount(like.getHotid());
    }
}
