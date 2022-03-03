package com.zxx.demo.service;

import com.zxx.demo.module.bo.UserBo;
import com.zxx.demo.module.common.BaseResult;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  13:39
 */
public interface UserService {

    public BaseResult login(UserBo userBo);
}
