package com.hx.futures.service;

import com.hx.futures.entity.Wallet;

/**
 * 钱包逻辑接口类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:50
 * @description：钱包逻辑接口类
 * @modified By：
 * @version: 1.0.0$
 */
public interface IWalletService {
    /**
     * 通过用户id获取钱包
     *
     * @param userId
     * @return
     */
    Wallet getWalletByUserId(Integer userId);
}