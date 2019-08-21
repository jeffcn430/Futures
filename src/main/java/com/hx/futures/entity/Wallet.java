package com.hx.futures.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 钱包
 */

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 钱包id
     */
    private Integer id;
    /**
     * 当前持有现金
     */
    private BigDecimal amount;
    /**
     * 初始资金
     */
    private BigDecimal initialAmount;
    /**
     * 提现
     */
    private BigDecimal withdraw;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "platformId", referencedColumnName = "id")
    private Platform platform;

    /**
     * 修改资金
     *
     * @param amount 金额
     * @param isAdd  是否增加
     */
    public void changeCash(BigDecimal amount, boolean isAdd) {
        if (isAdd) {
            this.amount = this.amount.add(amount);
        } else {
            this.amount = this.amount.subtract(amount);
        }
    }

    /**
     * 平仓后修改金额
     *
     * @param amount
     * @param poundage
     */
    public Wallet changeCash4Offset(BigDecimal amount, BigDecimal poundage) {
        this.changeCash(amount, true);
        this.changeCash(poundage, false);
        return this;
    }
}
