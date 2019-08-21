package com.hx.futures.service;

import com.hx.futures.entity.Position;
import com.hx.futures.exception.FutrueException;
import org.springframework.data.domain.Page;

/**
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:50
 * @description：仓位信息逻辑接口类
 * @modified By：
 * @version: 1.0.0$
 */
public interface IPositionService {
    Page<Position> positionList(Integer page, Integer size) throws FutrueException;

    /**
     * 建仓
     *
     * @param position
     * @return
     */
    boolean openPosition(Position position);

    /**
     * 平仓
     *
     * @param position
     * @return
     */
    boolean offsetPosition(Position position);

    /**
     * 加仓
     *
     * @param position
     * @return
     */
    boolean buyIn(Position position);

    /**
     * 减仓
     *
     * @param position
     * @return
     */
    boolean reduce(Position position);

    /**
     * 开平仓
     *
     * @param position
     * @return
     */
    boolean integrity(Position position);

    /**
     *
     * @param position
     * @return
     * @throws FutrueException
     */
    boolean finishPosition(Position position) throws FutrueException;
}
