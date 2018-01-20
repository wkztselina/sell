package com.wkzt.sell.service;

import com.wkzt.sell.dataopject.SellerInfo;

/**
 * 买家端
 * @Author hanchao
 * @Data 2017/11/23 16:21
 */
public interface SellerService {
    /**
     * 根据openid来查询
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
