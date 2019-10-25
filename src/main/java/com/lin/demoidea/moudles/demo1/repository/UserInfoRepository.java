package com.lin.demoidea.moudles.demo1.repository;

import com.lin.demoidea.moudles.demo1.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ljq
 * @Description:
 * @Date: 2019/10/25 0025 下午 02:29
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
