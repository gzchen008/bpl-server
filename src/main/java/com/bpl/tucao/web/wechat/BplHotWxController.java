package com.bpl.tucao.web.wechat;

import com.bpl.tucao.dao.BplFeedBackWxDao;
import com.bpl.tucao.dao.BplHotCommentWxDao;
import com.bpl.tucao.dao.BplHotLikeWxDao;
import com.bpl.tucao.dao.BplHotWxDao;
import com.bpl.tucao.dto.HotCommentDto;
import com.bpl.tucao.dto.HotLikeDto;
import com.bpl.tucao.entity.BplComment;
import com.bpl.tucao.entity.BplLike;
import com.bpl.tucao.entity.BplUser;
import com.bpl.tucao.vo.HotFeedBackVo;
import com.bpl.tucao.vo.HotSummaryVo;
import com.bpl.tucao.vo.ResponseVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/10 0010.
 */

@Controller
@RequestMapping(value = "/wx")
public class BplHotWxController {

    @Autowired
    private BplHotWxDao hotWxDao;

    @Autowired
    private BplFeedBackWxDao feedBackWxDao;

    @Autowired
    private BplHotCommentWxDao hotCommentWxDao;

    @Autowired
    private BplHotLikeWxDao hotLikeWxDao;

    @RequestMapping(value = "/hotSummaries/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseVo list(@PathVariable("id") Integer userId, HttpSession session) {
        userId = getUserIdBySession(session);
        ResponseVo responseVo = new ResponseVo();
        List<HotSummaryVo> hotSummaryList = hotWxDao.findAllHotSummary(userId);
        if (CollectionUtils.isNotEmpty(hotSummaryList)) {
            responseVo.setData(hotSummaryList);
        } else {
            responseVo.result(ResponseVo.FAIL);
        }
        return responseVo;
    }

    private Integer getUserIdBySession(HttpSession session) {
        BplUser bplUser = (BplUser) session.getAttribute("userInfo");
        Integer userId = Integer.parseInt(bplUser.getId());
        return userId;
    }

    @RequestMapping(value = "/hotDetail/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseVo get(@PathVariable("id") Integer hotId) {
        ResponseVo responseVo = new ResponseVo();
        List<HotFeedBackVo> feedBackVoList = feedBackWxDao.findOne(hotId);
        if (CollectionUtils.isNotEmpty(feedBackVoList)) {
            responseVo.setData(feedBackVoList);
        } else {
            responseVo.result(ResponseVo.FAIL);
        }
        return responseVo;
    }

    @RequestMapping(value = "/hotComment", method = RequestMethod.POST)
    public @ResponseBody ResponseVo comment(@RequestBody HotCommentDto dto, HttpSession session) {
        dto.setUserId(getUserIdBySession(session));
        ResponseVo responseVo = new ResponseVo();
        int result = hotCommentWxDao.insert(new BplComment(dto));
        if (result != 1) {
            responseVo.result(ResponseVo.FAIL);
        }
        return responseVo;
    }

    @RequestMapping(value = "/hotLike", method = RequestMethod.POST)
    public @ResponseBody ResponseVo likeUp(@RequestBody HotLikeDto dto, HttpSession session) {
        dto.setUserId(getUserIdBySession(session));
        ResponseVo responseVo = new ResponseVo();
        int result = hotLikeWxDao.insert(new BplLike(dto));
        if (result != 1) {
            responseVo.result(ResponseVo.FAIL);
        }
        return responseVo;
    }
}
