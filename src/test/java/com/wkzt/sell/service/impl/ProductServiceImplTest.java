package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.ProductInfo;
import com.wkzt.sell.enums.ProductStatusEnum;
import com.wkzt.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/10/30 14:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = service.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = service.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findUpAll1() throws Exception {
        PageRequest request =new PageRequest(0,2);
        Page<ProductInfo> infos = service.findUpAll(request);
        System.out.println(infos.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(BigDecimal.valueOf(11.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃");
        productInfo.setProductIcon(".jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo productInfo1 = service.save(productInfo);
        Assert.assertNotEquals(null,productInfo1);
    }

}