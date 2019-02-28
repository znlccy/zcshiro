package com.znlccy.zcshiro.service.impl;

import com.znlccy.zcshiro.domain.User;
import com.znlccy.zcshiro.mapper.UserMapper;
import com.znlccy.zcshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-15:10
 * version: 1.0.0
 * comment: 用户服务实体类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过姓名查找用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 通过主键查找用户
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
