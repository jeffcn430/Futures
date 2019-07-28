package com.hx.futures.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table
public class Variety implements Serializable {
    /**
     * 品种id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 平台id
     */
    private Integer platformId;
    /**
     * 手续费
     */
    private BigDecimal poundage;
    /**
     * 保证金
     */
    private BigDecimal margin;
    /**
     * 基点价值
     */
    @Column(precision = 19, scale = 4)
    private BigDecimal price;
    /**
     * 标准止损点数
     */
    private BigDecimal limit;
    /**
     * 品种
     */
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "varietyBaseId", referencedColumnName = "id")
    private VarietyBase varietyBase;
}
