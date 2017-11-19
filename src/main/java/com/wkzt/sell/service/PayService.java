package com.wkzt.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.wkzt.sell.dto.OrderDTO;

/**
 * @Author hanchao
 * @Data 2017/11/9 15:26
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundRequest refund(OrderDTO orderDTO);

}
