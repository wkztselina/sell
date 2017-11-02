package com.wkzt.sell.utils;

import java.util.Random;

/**
 * @Author hanchao
 * @Data 2017/10/31 14:37
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random =new Random();

        Integer a = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(a);
    }

}
