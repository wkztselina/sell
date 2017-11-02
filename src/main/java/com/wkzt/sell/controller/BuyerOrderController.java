package com.wkzt.sell.controller;

import com.wkzt.sell.converter.OrderForm2OrderDTOConverter;
import com.wkzt.sell.dto.OrderDTO;
import com.wkzt.sell.enums.ResultEnum;
import com.wkzt.sell.exception.SellException;
import com.wkzt.sell.form.OrderForm;
import com.wkzt.sell.service.OrderService;
import com.wkzt.sell.utils.ResultVOUtil;
import com.wkzt.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**订单控制器
 * @Author hanchao
 * @Data 2017/11/2 15:21
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {


    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping("")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确,orderForm",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult= orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);

    }
    //订单列表

    //订单详情

    //取消订单

}
