package com.lopo.mapper;


import com.lopo.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order selectById(Integer orderId);
}
