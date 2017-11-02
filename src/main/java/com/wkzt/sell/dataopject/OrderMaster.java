package com.wkzt.sell.dataopject;

import com.wkzt.sell.enums.OrderStatusEnum;
import com.wkzt.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/10/30 17:32
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
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
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    //支付状态默认为未支付
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;



}
