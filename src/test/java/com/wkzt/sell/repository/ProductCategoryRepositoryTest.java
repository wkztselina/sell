package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author hanchao
 * @Data 2017/9/20 14:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne(){
        ProductCategory productCategory=productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional //不会在数据库中留下数据自动回退
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory("女神最爱",9);
        ProductCategory result=productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list= Arrays.asList(2,3,4,1);
        List<ProductCategory> productCategoryList =productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategoryList);
    }



}