package com.wkzt.sell.dataopject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author hanchao
 * @Data 2017/10/30 17:44
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private  String detailId;

    /**订单id**/
    private String orderId;

    /**商品id**/
    private String productId;

    /**商品名称**/
    private String productName;

    /**商品单价*/
    private BigDecimal productPrice;

    /**商品数量**/
    private Integer productQuantity;

    /**商品小图*/
    private String productIcon;
}
