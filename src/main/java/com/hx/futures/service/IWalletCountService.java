package com.hx.futures.service;

import com.hx.futures.entity.WalletCount;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 钱包统计逻辑接口类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:51
 * @description：钱包统计逻辑接口类
 * @modified By：
 * @version: 1.0.0$
 */
public interface IWalletCountService {
    /**
     * 获取统计列表
     *
     * @return
     */
    List<WalletCount> getWalletCount();

    /**
     * 修改统计信息
     *
     * @param walletId 钱包id
     * @param date     日期
     * @param cash     钱包当前金额
     * @param oldCash  修改钱金额
     * @return
     */
    boolean changeWalletCount(Integer walletId, LocalDate date, BigDecimal cash, BigDecimal oldCash);
}
