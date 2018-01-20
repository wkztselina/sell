package com.wkzt.sell.service;

import com.wkzt.sell.dto.OrderDTO;

/**
 * 推送消息
 * @Author hanchao
 * @Data 2017/11/28 10:12
 */

public interface PushMessage {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
