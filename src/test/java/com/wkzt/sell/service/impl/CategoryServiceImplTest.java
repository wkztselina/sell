package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.ProductCategory;
import com.wkzt.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/9/22 15:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl service;
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = service.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findeAll() throws Exception {
        List<ProductCategory> productCategoryList=service.findeAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);
        List<ProductCategory> productCategoryList = service.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = service.save(new ProductCategory("月球", 80));


        Assert.assertNotNull(productCategory);
    }

}