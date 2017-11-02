package com.wkzt.sell.controller;

import com.wkzt.sell.dataopject.ProductCategory;
import com.wkzt.sell.dataopject.ProductInfo;
import com.wkzt.sell.service.CategoryService;
import com.wkzt.sell.service.ProductService;
import com.wkzt.sell.vo.ProductInfoVO;
import com.wkzt.sell.vo.ProductVO;
import com.wkzt.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author hanchao
 * @Data 2017/10/30 15:12
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList =productService.findUpAll();
        //2.查询类目
        //传统方法
//        for (ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8,lambda)
        List<Integer> categoryTypeList=productInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());
        categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory :productCategoryList )
        {
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productinfoVOList =new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productCategory.getCategoryType() == productInfo.getCategoryType()){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productinfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productinfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO =new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
