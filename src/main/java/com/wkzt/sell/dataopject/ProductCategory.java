package com.wkzt.sell.dataopject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * @Author hanchao
 * @Data 2017/9/20 14:03
 */
@Entity
@DynamicUpdate //动态更新时间
@Data//不用写get set
public class ProductCategory {
    /** id*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**类目名字*/
    private  String categoryName;
    /**类目编号*/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    //    private Date updateTime;
//
//    private Date createTime;


}
