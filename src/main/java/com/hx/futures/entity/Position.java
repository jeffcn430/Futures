package com.hx.futures.entity;

import com.hx.futures.entity.Teacher;
import com.hx.futures.entity.Variety;
import lombok.Data;

import javax.persistence.CascadeType;
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
     * 开仓均价
     */
    private BigDecimal startPoint;
    /**
     * 平仓均价
     */
    private BigDecimal endPoint;
    /**
     * 止盈点位
     */
    private BigDecimal limited = BigDecimal.ZERO;
    /**
     * 止损点位
     */
    private BigDecimal stop = BigDecimal.ZERO;
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
     * 带单老师
     */
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    private Teacher teacher;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 计算收益
     *
     * @return
     */
    public Position compute() {
        // 设置
        this.status = 1;
        this.poundage = this.variety.getPoundage();

        if (this.loss == null) {
            System.out.println("空");
        }else{
            System.out.println("不空");
        }
        return this;
    }



}
