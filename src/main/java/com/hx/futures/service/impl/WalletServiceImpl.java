package com.hx.futures.service.impl;

import com.hx.futures.common.Constants;
import com.hx.futures.entity.Wallet;
import com.hx.futures.entity.WalletDetail;
import com.hx.futures.exception.FutrueException;
import com.hx.futures.repository.WalletDetailRepository;
import com.hx.futures.repository.WalletRepository;
import com.hx.futures.service.IWalletService;
import com.hx.futures.utils.MoneyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    /**
     * 资金流水数据库操作类
     */
    @Autowired
    private WalletDetailRepository walletDetailRepository;

    @Override
    public Wallet getWalletByUserId(Integer userId) {
        return this.walletRepository.getOne(userId);
    }

    @Override
    public boolean offset(Integer userId, Integer platformId, int projectId, int moneyType, BigDecimal loss, BigDecimal poundage, LocalDateTime time) throws FutrueException {
        Wallet wallet = this.walletRepository.getOne(userId);
        if (wallet == null) {
            throw new FutrueException("钱包信息不存在");
        }

        // 货币转换
        if (moneyType != Constants.MONEY_TYPE_RMB) {
            loss = MoneyTools.exchangeToCNY(moneyType, loss);
            poundage = MoneyTools.exchangeToCNY(moneyType, poundage);
        }

        // 保存资金流水
        wallet.changeCash(loss, true);
        this.walletDetailRepository.save(new WalletDetail(Constants.CASH_TYPE_OFFSET, loss, projectId, time, wallet.getAmount()));
        wallet.changeCash(poundage, false);
        this.walletDetailRepository.save(new WalletDetail(Constants.CASH_TYPE_OFFSET_POUNDAGE, poundage, projectId, time, wallet.getAmount()));

        // 修改并保存钱包
        walletRepository.save(wallet);
        return true;
    }
}
