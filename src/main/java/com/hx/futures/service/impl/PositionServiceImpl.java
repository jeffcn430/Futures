package com.hx.futures.service.impl;

import com.hx.futures.entity.Position;
import com.hx.futures.entity.Variety;
import com.hx.futures.exception.FutrueException;
import com.hx.futures.repository.PositionRepository;
import com.hx.futures.repository.VarietyRepository;
import com.hx.futures.service.IPositionService;
import com.hx.futures.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    /**
     * 钱包逻辑类
     */
    @Autowired
    private IWalletService walletService;

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
    public boolean finishPosition(Position position) throws FutrueException {
        // 获取品种信息
        Variety variety = this.varietyRepository.findByvarietyBaseIdAndPlatformId(position.getVariety().getId(), position.getPlatform().getId());
        if (variety == null) {
            throw new FutrueException("品种不存在");
        }

        position.setVariety(variety);

        // 计算做单盈亏并保存到数据库
        this.positionRepository.save(position.compute());

        // 修改钱包金额
        int moneyType = position.getVariety().getVarietyBase().getMoneyType();
        this.walletService.offset(1, 1, position.getId(), moneyType, position.getLoss(), position.getPoundage(), position.getEndTime());
        return true;
    }
}
