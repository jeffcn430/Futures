package com.hx.futures.service;

import com.hx.futures.entity.Platform;

import java.util.List;

/**
 * 平台信息逻辑接口类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 22:59
 * @description：平台信息逻辑接口类
 * @modified By：
 * @version: 1.0.0$
 */
public interface IPlatformService {
    List<Platform> platformList();
}
