package com.lopo.mapper;


import com.lopo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(String userId);
}
