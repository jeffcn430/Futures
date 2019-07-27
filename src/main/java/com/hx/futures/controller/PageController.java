package com.hx.futures.controller;


import com.hx.futures.service.IPlatformService;
import com.hx.futures.service.ITeacherService;
import com.hx.futures.service.IVarietyService;
import com.hx.futures.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    /**
     * 钱包逻辑类
     */
    @Autowired
    private IWalletService walletService;
    /**
     * 平台逻辑类
     */
    @Autowired
    private IPlatformService platformService;
    /**
     * 品种逻辑类
     */
    @Autowired
    private IVarietyService varietyService;
    /**
     * 带盘老师信息逻辑
     */
    @Autowired
    private ITeacherService teacherService;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        return model;
    }

    /**
     * 主控页面
     *
     * @param model
     * @return
     */
    @GetMapping("welcome")
    public ModelAndView welcome(ModelAndView model) {
        model.setViewName("welcome");
        model.addObject("wallet", this.walletService.getWalletByUserId(1));
        model.addObject("variety", this.varietyService.varietyList(1));
        return model;
    }

    /**
     * 平仓列表
     *
     * @param model
     * @return
     */
    @GetMapping("offset-list")
    public ModelAndView offsetList(ModelAndView model) {
        model.setViewName("offset-list");
        return model;
    }

    /**
     * 完整单
     *
     * @param model
     * @return
     */
    @GetMapping("position-finish")
    public ModelAndView positionFinish(ModelAndView model) {
        model.setViewName("position-finish");
        model.addObject("platforms", this.platformService.platformList());
        model.addObject("teachers", this.teacherService.teacherList(1));
        model.addObject("varietys", this.varietyService.varietyList(1));
        return model;
    }

    /**
     * 交易策略
     *
     * @param model
     * @return
     */
    @GetMapping("strategy")
    public ModelAndView strategy(ModelAndView model) {
        model.addObject("wallet", this.walletService.getWalletByUserId(1));
        return model;
    }
}
