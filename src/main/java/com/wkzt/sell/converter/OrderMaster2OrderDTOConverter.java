package com.wkzt.sell.converter;

import com.wkzt.sell.dataopject.OrderMaster;
import com.wkzt.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author hanchao
 * @Data 2017/11/1 14:16
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return  orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map( e ->
            convert(e)
        ).collect(Collectors.toList());
    }


}
