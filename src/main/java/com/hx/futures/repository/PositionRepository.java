package com.hx.futures.repository;

import com.hx.futures.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 仓位数据库操作类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:49
 * @description：仓位数据库操作类
 * @modified By：
 * @version: 1.0.0$
 */
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
