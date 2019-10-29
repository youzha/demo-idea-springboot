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
public class SysRole {
    private String roleName;
    private String roleChineseName;
    private List<SysPermission> permissionList;

    public SysRole(String roleName, String roleChineseName) {
        this.roleName = roleName;
        this.roleChineseName = roleChineseName;
    }
}
