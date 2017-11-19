package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.OrderDetail;
import com.wkzt.sell.dto.CartDTO;
import com.wkzt.sell.dto.OrderDTO;
import com.wkzt.sell.enums.OrderStatusEnum;
import com.wkzt.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/10/31 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String OPEN_ID="110110";

    private final String ORDER_ID="1509500869872780616";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO =new OrderDTO();
        orderDTO.setBuyerName("韩师兄");
        orderDTO.setBuyerAddress("上海");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(OPEN_ID);

        //购物车
        List<OrderDetail> orderDetails=new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1234561");
        orderDetail.setProductQuantity(10);
        orderDetails.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetails);

        OrderDTO dto=orderService.create(orderDTO);
        log.info("[创建订单] result={}",dto);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO =orderService.findOne(ORDER_ID);
        log.info("查询单个订单 result={}",orderDTO);
        Assert.assertEquals(ORDER_ID,orderDTO.getOrderId());
    }

    @Test
    public void findeList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOList= orderService.findeList(OPEN_ID,request);
        Assert.assertNotEquals(0,orderDTOList.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO =orderService.findOne(ORDER_ID);
        OrderDTO result= orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO =orderService.findOne(ORDER_ID);
        OrderDTO result= orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),orderDTO.getOrderStatus());

    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO =orderService.findOne(ORDER_ID);
        OrderDTO result= orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void findeall(){
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOList= orderService.findeList(request);
//        Assert.assertNotEquals(0,orderDTOList.getTotalElements());
        Assert.assertTrue("查询所有的订单列表",orderDTOList.getTotalElements() > 0);
    }


}