package com.wkzt.sell.service;

import com.wkzt.sell.dto.OrderDTO;

/**买家
 * @Author hanchao
 * @Data 2017/11/3 14:51
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
