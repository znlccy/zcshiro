package com.znlccy.zcshiro.mapper;

import com.znlccy.zcshiro.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-15:01
 * version: 1.0.0
 * comment: 用户Mapper类
 */

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    User findById(Integer id);
}
