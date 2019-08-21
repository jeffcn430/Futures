package com.hx.futures.controller;

import com.hx.futures.service.IWalletCountService;
import com.hx.futures.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletCountController {
    @Autowired
    private IWalletCountService walletCountService;

    /**
     * 获取资金统计
     *
     * @return
     */
    @GetMapping("walletCount")
    public ResultData getWalletCount() {
        return new ResultData(this.walletCountService.getWalletCount());
    }
}
