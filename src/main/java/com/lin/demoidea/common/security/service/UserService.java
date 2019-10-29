package com.lin.demoidea.common.security.service;

import com.lin.demoidea.common.security.entity.SysUser;

/**
 * @Author: ljq
 * @Description:
 * @Date: 2019/10/28 0028 下午 03:34
 */
public interface UserService {
    SysUser getUserByName(String username);
}
