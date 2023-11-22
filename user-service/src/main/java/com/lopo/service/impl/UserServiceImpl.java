package com.lopo.service.impl;

import com.lopo.domain.User;
import com.lopo.mapper.UserMapper;
import com.lopo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getById(String id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
