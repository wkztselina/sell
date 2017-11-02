package com.wkzt.sell.service;

import com.wkzt.sell.dataopject.ProductCategory;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/9/20 16:05
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findeAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
