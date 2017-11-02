package com.wkzt.sell.dto;

import com.wkzt.sell.dataopject.OrderDetail;
import com.wkzt.sell.enums.OrderStatusEnum;
import com.wkzt.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/10/31 13:48
 */
@Data
public class OrderDTO {
    /**订单**/
    @Id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家电话
    private String buyerPhone;
    //买家的地址
    private String buyerAddress;
    /**微信的openid**/
    private String buyerOpenid;
    /***订单金额**/
    private BigDecimal orderAmount;
    //订单状态，默认为新下单
    private Integer orderStatus;

    //支付状态默认为未支付
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
