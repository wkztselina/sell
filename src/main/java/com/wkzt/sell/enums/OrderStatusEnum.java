package com.wkzt.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author hanchao
 * @Data 2017/10/30 17:37
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
