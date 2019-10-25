package com.lin.demoidea.moudles.demo1.service;

import com.lin.demoidea.moudles.demo1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ljq
 * @create 2019/10/25 0025
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public Object test() {
        return  userInfoRepository.findAll();
    }

}
