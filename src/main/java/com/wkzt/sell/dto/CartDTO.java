package com.wkzt.sell.dto;

import lombok.Data;

/**购物车
 * @Author hanchao
 * @Data 2017/10/31 14:49
 */
@Data
public class CartDTO {
    /**商品Id*/
    private String productId;
    /**数量**/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
