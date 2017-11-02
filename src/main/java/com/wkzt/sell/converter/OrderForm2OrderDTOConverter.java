package com.wkzt.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wkzt.sell.dataopject.OrderDetail;
import com.wkzt.sell.dto.OrderDTO;
import com.wkzt.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/11/2 15:43
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public  static OrderDTO converter(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAdress());
        List<OrderDetail> orderDetailList= new ArrayList<>();
        try {
            gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}
