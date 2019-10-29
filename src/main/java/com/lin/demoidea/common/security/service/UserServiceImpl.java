package com.lin.demoidea.common.security.service;

import com.lin.demoidea.common.security.dao.UserDao;
import com.lin.demoidea.common.security.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ljq
 * @create 2019/10/28 0028
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Cacheable(cacheNames = "authority", key = "#username")
    @Override
    public SysUser getUserByName(String username) {
        return userDao.selectByName(username);
    }
}
