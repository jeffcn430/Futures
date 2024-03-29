package com.hx.futures.service.impl;

import com.hx.futures.entity.Wallet;
import com.hx.futures.exception.FutrueException;
import com.hx.futures.repository.WalletRepository;
import com.hx.futures.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 钱包逻辑实现类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:51
 * @description：钱包逻辑实现类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class WalletServiceImpl implements IWalletService {
    /**
     * 钱包数据库操作类
     */
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getWalletByUserId(Integer userId) {
        return this.walletRepository.getOne(userId);
    }

    @Override
    public boolean offset(Integer userId, Integer platformId, BigDecimal loss, BigDecimal poundage) throws FutrueException {
        Wallet wallet = this.walletRepository.getOne(1);
        if (wallet == null) {
            throw new FutrueException("钱包信息不存在");
        }
        return true;
    }
}
