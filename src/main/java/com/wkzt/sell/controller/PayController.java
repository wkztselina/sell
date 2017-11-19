package com.wkzt.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.wkzt.sell.dto.OrderDTO;
import com.wkzt.sell.enums.ResultEnum;
import com.wkzt.sell.exception.SellException;
import com.wkzt.sell.service.OrderService;
import com.wkzt.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**支付
 * @Author hanchao
 * @Data 2017/11/9 15:19
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        //1、查询订单
         OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2、发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("orderId","1111111");
        return  new  ModelAndView("pay/create",map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    public void notify(@RequestBody String notifyData){
        payService.notify(notifyData);
    }

}
