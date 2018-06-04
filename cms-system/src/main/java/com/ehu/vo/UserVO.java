package com.ehu.vo;

import lombok.Data;

/**
 * @author geyl
 * @Title: UserVO
 * @Package com.ehu.vo
 * @Description: 用户VO类
 * @date 2018-6-1 13:38
 */
@Data
public class UserVO {
    private Integer userId;
    private String username;
    private String name;
    private String password;
    private String phone;
    private String roles;
}
