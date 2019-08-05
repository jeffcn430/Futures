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

    public void changeCash(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }
}
