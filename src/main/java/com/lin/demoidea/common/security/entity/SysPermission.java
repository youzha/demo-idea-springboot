package com.lin.demoidea.common.security.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ljq
 * @create 2019/10/28 0028
 */
//@Entity
@Data
//@Table(name = "tb_sys_permission")
public class SysPermission {
   // @Id
    private String id;
    private String code;
    private String name;
    private String url;


}
