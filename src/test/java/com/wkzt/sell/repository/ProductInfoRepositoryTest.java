package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/9/22 15:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    ProductInfoRepository productInfoRepository;
    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList=productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1234561");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(BigDecimal.valueOf(11.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃");
        productInfo.setProductIcon(".jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result=productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

}