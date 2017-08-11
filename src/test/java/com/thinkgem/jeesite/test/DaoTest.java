package com.thinkgem.jeesite.test;

import com.bpl.tucao.dao.BplHotCommentWxDao;
import com.bpl.tucao.dao.BplHotLikeWxDao;
import com.bpl.tucao.dao.BplHotWxDao;
import com.bpl.tucao.entity.BplComment;
import com.bpl.tucao.entity.BplHot;
import com.bpl.tucao.entity.BplLike;
import com.bpl.tucao.vo.HotSummaryVo;
import org.junit.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/11 0011.
 */
public class DaoTest extends BaseTest {

    @Resource
    private BplHotWxDao hotWxDao;

    @Resource
    private BplHotCommentWxDao commentWxDao;

    @Resource
    private BplHotLikeWxDao hotLikeWxDao;

    @Test
    public void test() {
//        List<HotSummaryVo> hotSummaryVoList = hotWxDao.findAllHotSummary(1);
        /*BplComment comment = new BplComment();
        comment.setContent("1");
        comment.setHotid(1);
        comment.setUserid(1);
        comment.setNickName("1");
        commentWxDao.insert(comment);*/
        BplLike like = new BplLike();
        like.setHotid(1);
        like.setUserid(1);
        like.setNickName("1");
        hotLikeWxDao.insert(like);
        System.out.println("");
    }
}
