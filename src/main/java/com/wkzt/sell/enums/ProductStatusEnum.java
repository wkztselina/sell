package com.wkzt.sell.enums;

import lombok.Getter;

/**
 * @Author hanchao
 * @Data 2017/10/30 14:28
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"上架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
