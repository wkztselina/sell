package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.SellerInfo;
import com.wkzt.sell.repository.SellerInfoRepository;
import com.wkzt.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hanchao
 * @Data 2017/11/23 16:24
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
