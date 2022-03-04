package com.zxx.demo.module.input;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  13:03
 */
@Data
public class UserVo implements Serializable {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;
}
