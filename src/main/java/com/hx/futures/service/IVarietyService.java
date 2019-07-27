package com.hx.futures.service;

import com.hx.futures.entity.Variety;

import java.util.List;

/**
 * 品种信息逻辑接口类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 22:31
 * @description：品种信息逻辑接口类
 * @modified By：
 * @version: 1.0.0$
 */
public interface IVarietyService {
    /**
     * 获取品种列表
     *
     * @param platformId 平台id
     * @return
     */
    List<Variety> varietyList(Integer platformId);
}
