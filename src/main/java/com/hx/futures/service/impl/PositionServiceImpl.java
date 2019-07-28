package com.hx.futures.service.impl;

import com.hx.futures.entity.Position;
import com.hx.futures.entity.Variety;
import com.hx.futures.exception.FutrueException;
import com.hx.futures.repository.PositionRepository;
import com.hx.futures.repository.VarietyRepository;
import com.hx.futures.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 仓位逻辑实现类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/12 4:51
 * @description：仓位逻辑实现类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class PositionServiceImpl implements IPositionService {
    /**
     * 仓位数据库操作类
     */
    @Autowired
    private PositionRepository positionRepository;

    /**
     * 品种信息数据操作类
     */
    @Autowired
    private VarietyRepository varietyRepository;

    @Override
    public Page<Position> positionList(Integer page, Integer size) throws FutrueException {


        return this.positionRepository.findAll(PageRequest.of(page - 1, size, new Sort(Sort.Direction.DESC, "id")));
    }

    @Override
    public boolean openPosition(Position position) {
        this.positionRepository.save(position);
        return true;
    }

    @Override
    public boolean offsetPosition(Position position) {
        return false;
    }

    @Override
    public boolean buyIn(Position position) {
        return false;
    }

    @Override
    public boolean reduce(Position position) {
        return false;
    }

    @Override
    public boolean integrity(Position position) {
        return false;
    }

    @Override
    @Transactional
    public boolean finishPosition(Position position) throws FutrueException {
        // 获取品种信息
        Variety variety = this.varietyRepository.findByvarietyBaseIdAndPlatformId(position.getVariety().getId(), position.getPlatform().getId());
        if (variety == null) {
            throw new FutrueException("品种不存在");
        }

        position.setVariety(variety);

        this.positionRepository.save(position.compute());
        return true;
    }
}
