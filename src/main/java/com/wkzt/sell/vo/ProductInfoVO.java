package com.wkzt.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author hanchao
 * @Data 2017/10/30 15:53
 */
@Data
public class ProductInfoVO {
    @JsonProperty("id")
    private  String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private String productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
