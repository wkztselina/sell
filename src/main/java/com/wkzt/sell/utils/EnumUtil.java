package com.wkzt.sell.utils;

import com.wkzt.sell.enums.CodeEnum;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author hanchao
 * @Data 2017/11/14 9:56
 */
public class EnumUtil {
    public static <T extends CodeEnum<Integer>> T getByCode(Integer code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
