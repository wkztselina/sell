package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.ProductCategory;
import com.wkzt.sell.repository.ProductCategoryRepository;
import com.wkzt.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/9/22 14:58
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findeAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
