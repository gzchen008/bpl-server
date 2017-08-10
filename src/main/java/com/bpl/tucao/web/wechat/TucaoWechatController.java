package com.bpl.tucao.web.wechat;

import com.bpl.tucao.entity.BplTucao;
import com.bpl.tucao.service.BplTucaoService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by cgzchen on 2017/8/10.
 * 吐槽微信控制器
 */
@RequestMapping("/wx/tucao")
@Controller
public class TucaoWechatController extends BaseController {

    @Autowired
    private BplTucaoService bplTucaoService;

    @RequestMapping("/add")
    public void add(@RequestBody BplTucao bplTucao) {
        bplTucaoService.save(bplTucao);
    }

    @RequestMapping("/list")
    public void list(Integer pageNo, HttpServletResponse response) {
        Page<BplTucao> page = new Page<BplTucao>();
        page.setPageNo(pageNo);
        Page<BplTucao> resPage = bplTucaoService.findPage(page, new BplTucao());
        renderString(response, resPage.getList());
    }

}
