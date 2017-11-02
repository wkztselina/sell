package com.wkzt.sell.dataopject;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author hanchao
 * @Data 2017/9/22 15:26
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;

    //产品名称
    private String productName;
    //单价
    private BigDecimal productPrice;

    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;

    //商品状态 0正常 1下架
    private int productStatus;

    //类目编号
    private Integer categoryType;


}
