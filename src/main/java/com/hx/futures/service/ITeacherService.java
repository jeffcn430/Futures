package com.hx.futures.service;

import com.hx.futures.entity.Teacher;

import java.util.List;

/**
 * 带盘老师信息逻辑接口类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 22:35
 * @description：带盘老师信息逻辑接口类
 * @modified By：
 * @version: 1.0.0$
 */
public interface ITeacherService {
    /**
     * 获取带盘老师列表
     *
     * @param platformId 平台id
     * @return
     */
    List<Teacher> teacherList(Integer platformId);
}
