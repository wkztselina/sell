package com.wkzt.sell.dataopject.mapper;

import com.wkzt.sell.dataopject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Author hanchao
 * @Data 2017/11/29 15:07
 */
public interface ProductCategoryMapper {

    @Insert({"insert into product_category(category_name,category_type) values (#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})"})
    int insertByMap(Map<String,Object> map);

    @Insert({"insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})"})
    int insertByObject(ProductCategory productCategory);

    @Select("select * from  product_category where category_type=#{categoryType}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName")
    })
    ProductCategory findByCategoryType(Integer categoryType);


    @Select("select * from  product_category where category_name=#{categoryName}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType} ")
    int updateByCategoryType(@Param("categoryName") String categoryName,@Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType} ")
    int updateByObject(ProductCategory productCategory);


}
