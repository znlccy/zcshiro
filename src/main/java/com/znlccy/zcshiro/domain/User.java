package com.znlccy.zcshiro.domain;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-15:00
 * version: 1.0.0
 * comment: 用于实体类
 */
public class User {

    /**
     * 用户主键
     */
    private Integer id;

    /**
     * 用于姓名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户授权
     */
    private String perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
