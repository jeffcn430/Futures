package com.hx.futures.repository;

import com.hx.futures.entity.Platform;
import com.hx.futures.entity.WalletCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

/**
 * 平台信息数据库操作类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 21:23
 * @description：平台信息数据库操作类
 * @modified By：
 * @version: $
 */
public interface WalletCountRepository extends JpaRepository<WalletCount, Integer> {
    WalletCount getAllByWalletIdAndDate(Integer walletId, LocalDate date);
}
