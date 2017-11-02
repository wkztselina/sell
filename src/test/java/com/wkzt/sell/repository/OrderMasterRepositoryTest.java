package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/10/31 9:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="110110";

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderMaster> orderMasters=repository.findByBuyerOpenid(OPENID,request);
        System.out.println(orderMasters.getTotalElements());
    }

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("17605883257");
        orderMaster.setBuyerAddress("中软国际");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster orderMaster1= repository.save(orderMaster);
        Assert.assertNotNull(orderMaster1);
    }

}