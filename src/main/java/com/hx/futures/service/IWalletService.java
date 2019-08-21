package com.hx.futures.service;

import com.hx.futures.entity.Wallet;
import com.hx.futures.exception.FutrueException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    /**
     * 平仓后修改钱包信息
     *
     * @param userId     用户id
     * @param platformId 平台id
     * @param moneyType
     * @param loss       平仓盈亏
     * @param poundage   手续费
     * @return
     * @throws FutrueException
     */
    @Transactional
    boolean offset(Integer userId, Integer platformId, int projectId, int moneyType, BigDecimal loss, BigDecimal poundage, LocalDateTime time) throws FutrueException;
}