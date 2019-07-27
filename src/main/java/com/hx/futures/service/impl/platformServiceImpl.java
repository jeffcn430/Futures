package com.hx.futures.service.impl;

import com.hx.futures.entity.Platform;
import com.hx.futures.repository.PlatformRepository;
import com.hx.futures.service.IPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 平台新逻辑类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 23:02
 * @description：平台新逻辑类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class platformServiceImpl implements IPlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public List<Platform> platformList() {
        return this.platformRepository.findAll();
    }
}
