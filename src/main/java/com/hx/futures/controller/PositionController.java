package com.hx.futures.controller;

import com.hx.futures.entity.Position;
import com.hx.futures.entity.vo.PositionVo;
import com.hx.futures.exception.FutrueException;
import com.hx.futures.service.IPositionService;
import com.hx.futures.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仓位信息
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 6:32
 * @description：仓位信息
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
public class PositionController {
    @Autowired
    private IPositionService positionService;

    /**
     * 获取仓位列表
     *
     * @param page  页码
     * @param limit 每页显示数量
     * @return
     */
    @GetMapping("position")
    public ResultData positionList(Integer page, Integer limit) throws FutrueException {
        Page<Position> positionPage = this.positionService.positionList(page, limit);
        return new ResultData(positionPage.getContent(), (int) positionPage.getTotalElements());
    }

    /**
     * 开仓
     *
     * @param positionVo 开仓参数集
     * @return
     */
    @PostMapping("position")
    public ResultData openPosition(PositionVo.OpenPositionVo positionVo) {
        this.positionService.openPosition(positionVo.build());
        return new ResultData();
    }

    /**
     * 平仓
     *
     * @param offsetPositionVo 平仓参数集
     * @return
     */
    @PutMapping("position")
    public ResultData offsetPosition(PositionVo.OffsetPositionVo offsetPositionVo) {
        return new ResultData();
    }

    @PostMapping("finishPosition")
    public ResultData finishPosition(Position position) throws FutrueException {
        this.positionService.finishPosition(position);
        return new ResultData();
    }
}
