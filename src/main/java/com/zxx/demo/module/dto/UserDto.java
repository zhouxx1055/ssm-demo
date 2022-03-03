package com.zxx.demo.module.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhouxx
 * @date 2022/3/3  13:42
 */
@Data
public class UserDto extends BaseDto {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机
     */
    private String userPhone;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 性别
     */
    private Short userSex;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Short deleteFlag;

}
