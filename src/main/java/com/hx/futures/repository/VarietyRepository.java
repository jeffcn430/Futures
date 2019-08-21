package com.hx.futures.repository;

import com.hx.futures.entity.Variety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 品种信息数据库操作类
 *
 * @author ：Jeff
 * @date ：Created in 2019/7/13 21:44
 * @description：品种信息数据库操作类
 * @modified By：
 * @version: 1.0.0$
 */
public interface VarietyRepository extends JpaRepository<Variety, Integer> {
    /**
     * 获取指定平台下所有品种
     *
     * @param platformId 平台id
     * @return
     */
    List<Variety> findAllByPlatformId(Integer platformId);

    /**
     * 通过品种基础id和平台获取品种信息
     * @param varietyBaseId 品种基础id
     * @param platformId 平台id
     * @return
     */
    Variety findByvarietyBaseIdAndPlatformId(Integer varietyBaseId, Integer platformId);
}
