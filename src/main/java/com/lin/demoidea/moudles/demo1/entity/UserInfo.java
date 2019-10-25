package com.lin.demoidea.moudles.demo1.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author ljq
 * @create 2019/10/25 0025
 */
@Entity
@Data
@Table(name = "tb_user_info")
public class UserInfo {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "sex")
    private String sex;
}
