package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author hanchao
 * @Data 2017/10/30 18:07
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);






}
