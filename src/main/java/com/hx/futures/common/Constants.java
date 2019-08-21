package com.hx.futures.common;

public class Constants {
    /** 默认日期时间格式 */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 默认日期格式 */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    /** 默认时间格式 */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    // 资金流水类型
    /** 入金 */
    public static final int CASH_TYPE_IN = 1;
    /** 出金 */
    public static final int CASH_TYPE_OUT = 2;
    /** 平仓 */
    public static final int CASH_TYPE_OFFSET = 3;
    /** 平仓手续费 */
    public static final int CASH_TYPE_OFFSET_POUNDAGE = 4;
    /** 删除订单冲销 */
    public static final int CASH_TYPE_WRITE_OFF = 5;

    //货币类型
    /** 人民币 */
    public static final int MONEY_TYPE_RMB = 0;
    /** 美元 */
    public static final int MONEY_TYPE_USD = 1;
    /** 欧元 */
    public static final int MONEY_TYPE_EUR = 2;
    /** 港币 */
    public static final int MONEY_TYPE_HKD = 3;
}
