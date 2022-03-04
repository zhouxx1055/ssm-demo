package com.zxx.demo.module.input;

import lombok.Data;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  13:02
 */
@Data
@ToString
public class LoginUserVo implements Serializable {

    /**
     * 用户名
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * 密码
     */
    @JsonProperty("userPwd")
    private String userPwd;
}
