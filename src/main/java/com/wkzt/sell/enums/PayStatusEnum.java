package com.wkzt.sell.enums;

import lombok.Getter;

/**
 * @Author hanchao
 * @Data 2017/10/30 17:40
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}