package com.znlccy.zcshiro.service;

import com.znlccy.zcshiro.domain.User;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-15:09
 * version: 1.0.0
 * comment: 用户服务接口
 */
public interface UserService {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过主键查找用户
     * @param id
     * @return
     */
    User findById(Integer id);
}
