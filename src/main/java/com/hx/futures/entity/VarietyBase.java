package com.hx.futures.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VarietyBase implements Serializable {
    /**
     * 品种id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 品种名称
     */
    private String name;
    /**
     * 最小波动点位
     */
    private BigDecimal minPoint;
    /**
     * 单位价格
     */
    private BigDecimal price;
    /**
     * 货币类型
     */
    private Integer moneyType;
}
