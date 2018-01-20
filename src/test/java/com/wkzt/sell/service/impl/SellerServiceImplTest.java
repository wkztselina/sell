package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.SellerInfo;
import com.wkzt.sell.repository.SellerInfoRepository;
import com.wkzt.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/11/23 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private  static  final String openid="abc";

    @Autowired
    private SellerService sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals("abc",sellerInfo.getOpenid());
    }

}