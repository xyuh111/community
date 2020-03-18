package com.web3n.community.entity;

import java.util.Date;

/**
 * @author: sushi
 * @create 2020-03-18 18:37
 * @description:
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private Integer type;
    private Integer status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
