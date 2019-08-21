package com.hx.futures.service.impl;

import com.hx.futures.entity.WalletCount;
import com.hx.futures.repository.WalletCountRepository;
import com.hx.futures.service.IWalletCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 钱包统计逻辑实现类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:51
 * @description：钱包逻辑实现类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class WalletCountServiceImpl implements IWalletCountService {
    @Autowired
    private WalletCountRepository walletCountRepository;

    @Override
    public List<WalletCount> getWalletCount() {
        return this.walletCountRepository.findAll();
    }

    @Override
    public boolean changeWalletCount(Integer walletId, LocalDate date, BigDecimal cash, BigDecimal oldCash) {
        // 如果资金相同则不进行计算直接返回成功
        if (cash.compareTo(oldCash) == 0) {
            return true;
        }

        WalletCount walletCount = this.walletCountRepository.getAllByWalletIdAndDate(walletId, date);
        if (walletCount == null) {
            walletCount = new WalletCount(walletId, date, oldCash);
        }

        this.walletCountRepository.save(walletCount.count(cash));
        return false;
    }
}
