package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author hanchao
 * @Data 2017/11/23 15:09
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);



}
