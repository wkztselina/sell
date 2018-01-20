package com.wkzt.sell.dataopject.dao;

import com.wkzt.sell.dataopject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author hanchao
 * @Data 2017/11/29 17:41
 */
public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByMap(Map<String,Object> map){
        return mapper.insertByMap(map);
    }

}
