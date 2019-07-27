package com.hx.futures.controller;

import com.hx.futures.service.IVarietyService;
import com.hx.futures.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Jeff
 * @date ：Created in 2019/7/21 1:25
 * @description：品种信息控制类
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
public class VarietyController {
    /**
     * 品种信息逻辑接口
     */
    @Autowired
    private IVarietyService varietyService;

    @GetMapping("suggest")
    public ResultData suggest(Integer platformId) {
        return new ResultData(this.varietyService.varietyList(1));
    }
}
