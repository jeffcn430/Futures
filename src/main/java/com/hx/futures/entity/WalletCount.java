package com.hx.futures.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 钱包统计
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/11 18:16
 * @description：持仓信息
 * @modified By：
 * @version: 1.0.0$
 */
@Data
@Entity
public class WalletCount implements Serializable {
    /**
     * 流水id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 日期
     */
    private LocalDate date;
    /**
     * 钱包id
     */
    private int walletId;
    /**
     * 开始现金
     */
    BigDecimal openCash;
    /**
     * 结束现金
     */
    BigDecimal closeCash;
    /**
     * 最大现金
     */
    BigDecimal maxCash;
    /**
     * 最小现金
     */
    BigDecimal minCash;

    public WalletCount(int walletId, LocalDate date, BigDecimal cash) {
        this.date = date;
        this.walletId = walletId;
        this.openCash = cash;
        this.closeCash = cash;
        this.maxCash = cash;
        this.minCash = cash;
    }

    public WalletCount count(BigDecimal cash) {
        // 如果当前金额大于最大金额将只赋予最大金额
        if (this.maxCash.compareTo(cash) == 1) {
            this.maxCash = cash;
        }

        // 如果当前金额小于最小金额将值赋予最小金额
        if (this.minCash.compareTo(cash) == -1) {
            this.minCash = cash;
        }
        return this;
    }
}
