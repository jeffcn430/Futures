package com.hx.futures.entity.vo;

import com.hx.futures.entity.Position;
import lombok.Data;

/**
 * @author ：Jeff
 * @date ：Created in 2019/7/14 19:44
 * @description：仓位相关的请求参数封装
 * @modified By：
 * @version: 1.0.0$
 */
@Data
public class PositionVo {
    /**
     * 开仓请求参数
     */
    public static class OpenPositionVo {
        public Position build() {
            return new Position();
        }
    }

    /**
     * 平仓请求参数
     */
    @Data
    public static class OffsetPositionVo {
    }
}
