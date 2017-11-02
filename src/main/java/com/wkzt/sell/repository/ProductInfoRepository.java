package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/9/22 15:42
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStaus);
}
