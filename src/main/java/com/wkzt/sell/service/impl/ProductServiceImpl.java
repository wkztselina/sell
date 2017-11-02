package com.wkzt.sell.service.impl;

import com.wkzt.sell.dataopject.ProductInfo;
import com.wkzt.sell.dto.CartDTO;
import com.wkzt.sell.enums.ProductStatusEnum;
import com.wkzt.sell.enums.ResultEnum;
import com.wkzt.sell.exception.SellException;
import com.wkzt.sell.repository.ProductInfoRepository;
import com.wkzt.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/10/30 13:33
 */
@Service
public class ProductServiceImpl  implements ProductService{
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findUpAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOS) {
        for(CartDTO cartDTO:cartDTOS){
            ProductInfo productInfo=repository.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for(CartDTO cartDTO :cartDTOS){
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0) {
                throw  new SellException(ResultEnum.product_stock_error);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
