package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/9/20 14:08
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
