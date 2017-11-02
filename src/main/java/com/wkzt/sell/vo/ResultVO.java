package com.wkzt.sell.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/10/30 15:18
 */
@Data
public class ResultVO<T> {

    /** 错误码**/
    private Integer code;
    /** 信息**/
    private String msg;
    /**具体内容**/
    private T data;

}
