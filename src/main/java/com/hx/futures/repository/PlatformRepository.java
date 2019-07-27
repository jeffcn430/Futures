package com.hx.futures.repository;

import com.hx.futures.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 平台信息数据库操作类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 21:23
 * @description：平台信息数据库操作类
 * @modified By：
 * @version: $
 */
public interface PlatformRepository extends JpaRepository<Platform, Integer> {
}
