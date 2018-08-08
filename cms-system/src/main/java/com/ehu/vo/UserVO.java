package com.ehu.vo;

import com.ehu.bean.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author geyl
 * @Title: UserVO
 * @Package com.ehu.vo
 * @Description: 用户VO类
 * @date 2018-6-1 13:38
 */
@Data
public class UserVO extends PageRequest implements Serializable {
    private Integer userId;
    private String username;
    private String name;
    private String password;
    private String phone;
    private String roles;
    private String departmentId;
}
