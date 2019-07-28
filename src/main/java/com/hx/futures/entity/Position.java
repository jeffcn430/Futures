package com.hx.futures.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 持仓信息
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/11 18:16
 * @description：持仓信息
 * @modified By：
 * @version: 1.0.0$
 */
@Data
@Entity
@Table
public class Position {
    /**
     * 订单编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 品种
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "varietyId", referencedColumnName = "id")
    private Variety variety;
    /**
     * 买卖方向
     */
    @Column(nullable = false)
    private Integer bbi;
    /**
     * 数量
     */
    @Column(nullable = false)
    private int number;
    /**
     * 建仓时间
     */
    @Column(nullable = false)
    private LocalDateTime startTime;
    /**
     * 平仓时间
     */
    private LocalDateTime endTime;
    /**
     * 开仓均价
     */
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal startPoint;
    /**
     * 平仓均价
     */
    @Column(precision = 19, scale = 4)
    private BigDecimal endPoint;
    /**
     * 止盈点位
     */
    @Column(precision = 19, scale = 4)
    private BigDecimal limited = BigDecimal.ZERO;
    /**
     * 止损点位
     */
    @Column(precision = 19, scale = 4)
    private BigDecimal stop = BigDecimal.ZERO;
    /**
     * 手续费
     */
    @Column(nullable = false)
    private BigDecimal poundage = BigDecimal.ZERO;
    /**
     * 盈亏
     */
    private BigDecimal loss;
    /**
     * 平仓状态
     */
    @Column(nullable = false)
    private Integer status = 0;

    /**
     * 带单老师
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "platformId", referencedColumnName = "id")
    private Platform platform;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 计算平仓收益收益
     *
     * @return
     */
    public Position compute() {
        this.status = 1;
        this.poundage = variety.getPoundage();

        // 若没有填写平仓盈亏则计算
        if (this.loss == null) {
            BigDecimal point;
            if (bbi == 1) {
                point = endPoint.subtract(startPoint);
            } else {
                point = startPoint.subtract(endPoint);
            }

            // 平仓盈亏计算公式
            // (平仓点差/最小波动)*最小波动价值*开仓数量
            this.loss = point.divide(variety.getVarietyBase().getMinPoint()).multiply(variety.getPrice()).multiply(new BigDecimal(this.number));
        }
        return this;
    }


}
