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
import java.time.LocalDateTime;

/**
 * 平仓信息
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 23:42
 * @description：平仓信息
 * @modified By：
 * @version: 1.0.0$
 */
@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offset implements Serializable {
    /**
     * 订单编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 交易平台
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "platformId", referencedColumnName = "id")
    private Platform platform;
    /**
     * 品种
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "varietyId", referencedColumnName = "id")
    private Variety variety;
    /**
     * 买卖方向
     */
    private Integer bbi;
    /**
     * 数量
     */
    private int number;
    /**
     * 建仓时间
     */
    private LocalDateTime startTime;
    /**
     * 平仓时间
     */
    private LocalDateTime endTime;
    /**
     * 开仓点位
     */
    private BigDecimal startPoint;
    /**
     * 平仓点位
     */
    private BigDecimal endPoint;
    /**
     * 手续费
     */
    private BigDecimal poundage;
    /**
     * 盈亏
     */
    private BigDecimal loss;

    /**
     * 平仓状态
     */
    private Integer status = 0;

    /**
     * 止盈点位
     */
    private BigDecimal limited = BigDecimal.ZERO;
    /**
     * 止盈盈亏
     */
    private BigDecimal limitedLoss = BigDecimal.ZERO;

    /**
     * 止损点位
     */
    private BigDecimal stop = BigDecimal.ZERO;
    /**
     * 止损盈亏
     */
    private BigDecimal stopLoss = BigDecimal.ZERO;

    /**
     * 带单老师
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    private Teacher teacher;

    /**
     * 备注
     */
    private String remarks;
}
