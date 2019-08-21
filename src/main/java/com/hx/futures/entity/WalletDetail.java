package com.hx.futures.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 现金流水
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletDetail implements Serializable {
    /**
     * 流水id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 资金变动类型
     */
    private Integer type;
    /**
     * 变动金额
     */
    private BigDecimal cash;
    /**
     * 劣后资金
     */
    private BigDecimal poorCapital;
    /**
     * 平仓信息id
     */
    private Integer projectId;
    /**
     *
     */
    private LocalDateTime createTime;

    public WalletDetail(Integer type, BigDecimal cash, Integer projectId, LocalDateTime time, BigDecimal poorCapital) {
        this.type = type;
        this.cash = cash;
        this.projectId = projectId;
        this.createTime = time;
        this.poorCapital = poorCapital;
    }
}
