package com.hx.futures.service.impl;

import com.hx.futures.entity.Teacher;
import com.hx.futures.repository.TeacherRepository;
import com.hx.futures.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 带盘老师信息逻辑类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 22:37
 * @description：带盘老师信息逻辑类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> teacherList(Integer platformId) {
        return this.teacherRepository.findAllByPlatformId(platformId);
    }
}
