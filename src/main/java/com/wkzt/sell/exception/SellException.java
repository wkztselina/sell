package com.wkzt.sell.exception;

import com.wkzt.sell.enums.ResultEnum;

/**
 * @Author hanchao
 * @Data 2017/10/31 14:23
 */
public class SellException extends  RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
