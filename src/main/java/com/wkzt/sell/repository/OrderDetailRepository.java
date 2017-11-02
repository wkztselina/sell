package com.wkzt.sell.repository;

import com.wkzt.sell.dataopject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author hanchao
 * @Data 2017/10/31 9:45
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String s);


}
