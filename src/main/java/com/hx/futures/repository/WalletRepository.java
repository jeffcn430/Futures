package com.hx.futures.repository;

import com.hx.futures.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 钱包数据库操作类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:49
 * @description：钱包数据库操作类
 * @modified By：
 * @version: 1.0.0$
 */
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
