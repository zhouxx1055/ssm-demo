package com.zxx.demo.service;

import com.zxx.demo.module.bo.UserBo;
import com.zxx.demo.module.common.BaseResult;
import com.zxx.demo.util.BaseResultError;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/4  13:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-base.xml"})
public class UserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    UserService userService;

    @Test
    public void testLogin() {
        UserBo userBo=new UserBo();
        userBo.setUserName("zhouxx");
        userBo.setUserPwd("123456123");
        BaseResult baseResult= userService.login(userBo);
        logger.info(baseResult.toString());
        Assert.assertTrue(baseResult.getStatus()== BaseResultError.API_LOGIN_OK.getStatus());

        userBo.setUserName("zhouxx");
        userBo.setUserPwd("aaaaaaaaaaaaaaa");
        baseResult= userService.login(userBo);
        logger.info(baseResult.toString());
        Assert.assertTrue(baseResult.getStatus()== BaseResultError.API_LOGIN_Fail.getStatus());

        userBo.setUserName("zhouxx123");
        userBo.setUserPwd("aaaaaaaaaaaaaaa");
        baseResult= userService.login(userBo);
        logger.info(baseResult.toString());
        Assert.assertTrue(baseResult.getStatus()== BaseResultError.API_LOGIN_Fail_USER_NOT_EXISTED.getStatus());

    }
}
