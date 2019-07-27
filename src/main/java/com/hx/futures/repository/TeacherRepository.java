package com.hx.futures.repository;

import com.hx.futures.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 带盘老师数据库操作类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 21:42
 * @description：带盘老师数据库操作类
 * @modified By：
 * @version: 1.0.0$
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    /**
     * 获取指定平台下所有带潘老师
     *
     * @param platformId
     * @return
     */
    List<Teacher> findAllByPlatformId(Integer platformId);
}
