package com.hx.futures.utils;

import com.hx.futures.common.Constants;

import java.math.BigDecimal;

public class MoneyTools {
    public static BigDecimal exchangeToUSD(int type, BigDecimal money) {
        switch (type) {
            case Constants.MONEY_TYPE_EUR:
                return money.multiply(new BigDecimal(1.2388));
            case Constants.MONEY_TYPE_HKD:
                return money.multiply(new BigDecimal(0.13548));
            default:
                return money;
        }
    }

    public static BigDecimal exchangeToCNY(int type, BigDecimal money) {
        switch (type) {
            case Constants.MONEY_TYPE_USD:
                return money.multiply(new BigDecimal(7.75));
            case Constants.MONEY_TYPE_EUR:
                return money.multiply(new BigDecimal(9.6034696)).setScale(2, BigDecimal.ROUND_HALF_UP);
            case Constants.MONEY_TYPE_HKD:
                return money.multiply(new BigDecimal(1.0501355)).setScale(2, BigDecimal.ROUND_HALF_UP);
            default:
                return money;
        }
    }
}
