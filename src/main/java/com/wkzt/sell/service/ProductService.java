package com.wkzt.sell.service;

import com.wkzt.sell.dataopject.ProductInfo;
import com.wkzt.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**商品
 * @Author hanchao
 * @Data 2017/10/30 12:00
 */
public interface ProductService {
        ProductInfo findOne(String productId);

    /**
     * 查询所有在架列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findUpAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOS);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOS);
}
