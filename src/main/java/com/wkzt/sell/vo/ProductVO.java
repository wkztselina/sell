package com.wkzt.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*商品包含类目
 * @Author hanchao
 * @Data 2017/10/30 15:44
 */
@Data
public class ProductVO {

    /**类目名**/
    @JsonProperty("name")
    private  String categoryName;
    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
