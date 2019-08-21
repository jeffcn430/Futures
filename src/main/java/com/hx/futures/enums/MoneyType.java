package com.hx.futures.enums;

public enum MoneyType {
    RMB(0, "人民币"),
    USD(1, "美元"),
    EUR(2, "欧元"),
    HKD(3, "港币");

    Integer id;
    String str;

    MoneyType(Integer id, String str) {
        this.id = id;
        this.str = str;
    }
}
