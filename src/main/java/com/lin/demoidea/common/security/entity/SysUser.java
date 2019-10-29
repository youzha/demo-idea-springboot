package com.lin.demoidea.common.security.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ljq
 * @create 2019/10/28 0028
 */
@Data
@NoArgsConstructor
public class SysUser {
    private String userName;
    private String password;
    private List<SysRole> roleList;

    public SysUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
