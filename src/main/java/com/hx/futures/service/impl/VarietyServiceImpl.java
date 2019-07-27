package com.hx.futures.service.impl;


import com.hx.futures.entity.Variety;
import com.hx.futures.repository.VarietyRepository;
import com.hx.futures.service.IVarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Jeff
 * @date ：Created in 2019/7/13 22:46
 * @description：品种逻辑类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class VarietyServiceImpl implements IVarietyService {
    /**
     * 品种信息数据库操作类
     */
    @Autowired
    private VarietyRepository varietyRepository;

    @Override
    public List<Variety> varietyList(Integer platformId) {
        return this.varietyRepository.findAllByPlatformId(platformId);
    }
}
