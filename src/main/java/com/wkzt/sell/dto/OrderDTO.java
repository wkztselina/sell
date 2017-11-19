package com.wkzt.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wkzt.sell.dataopject.OrderDetail;
import com.wkzt.sell.enums.OrderStatusEnum;
import com.wkzt.sell.enums.PayStatusEnum;
import com.wkzt.sell.utils.EnumUtil;
import com.wkzt.sell.utils.serialize.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/10/31 13:48
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
