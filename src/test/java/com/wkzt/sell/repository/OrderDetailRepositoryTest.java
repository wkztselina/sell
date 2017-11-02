package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/10/31 10:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() throws Exception {

    }

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("11111111");
         orderDetail.setProductIcon("http://xxxx.jpg");
         orderDetail.setProductId("11111112");
         orderDetail.setProductName("皮蛋粥");
         orderDetail.setProductPrice(new BigDecimal(2.3));
         orderDetail.setProductQuantity(2);

         OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

}