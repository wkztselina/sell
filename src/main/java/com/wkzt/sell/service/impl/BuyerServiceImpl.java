package com.wkzt.sell.service.impl;

import com.wkzt.sell.dto.OrderDTO;
import com.wkzt.sell.enums.ResultEnum;
import com.wkzt.sell.exception.SellException;
import com.wkzt.sell.service.BuyerService;
import com.wkzt.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hanchao
 * @Data 2017/11/3 14:54
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;


    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderId);
        if(orderDTO == null){
            log.error("【取消订单】查询不到该订单,orderId={}",orderId);
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return null;
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            return null;
        }
        //判断是否是自己得订单
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】 订单的openid不一致，openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

}
