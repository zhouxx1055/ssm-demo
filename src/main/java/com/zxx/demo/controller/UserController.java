package com.zxx.demo.controller;

import com.zxx.demo.module.bo.UserBo;
import com.zxx.demo.module.common.BaseResult;
import com.zxx.demo.module.input.LoginUserVo;
import com.zxx.demo.service.UserService;
import com.zxx.demo.util.BaseResultError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhouxx
 * @Description: 用户鉴权相关接口
 * @date 2022/3/3  12:55
 */
@Controller
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(LoginUserVo user) {

        BaseResult baseResult= check(user);
        if(baseResult!=null && baseResult.getStatus()!=BaseResultError.API_OK.getStatus()){
            return baseResult;
        }
        UserBo userBo=new UserBo();
        userBo.setUserName(user.getUserName());
        userBo.setUserPwd(user.getUserPwd());
        return userService.login(userBo);
    }

    private BaseResult check(LoginUserVo user) {
        if (user == null || user.getUserName() == null || "".equals(user.getUserName().trim())
                || user.getUserPwd() == null || "".equals(user.getUserPwd().trim())) {
            return new BaseResult(BaseResultError.API_INVALID_PARAMETER);
        }
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public BaseResult login(String userName,String userPwd) {
        LoginUserVo user=new LoginUserVo();
        user.setUserName(userName);
        user.setUserPwd(userPwd);

        BaseResult baseResult= check(user);
        if(baseResult!=null && baseResult.getStatus()!=BaseResultError.API_OK.getStatus()){
            return baseResult;
        }
        UserBo userBo=new UserBo();
        userBo.setUserName(user.getUserName());
        userBo.setUserPwd(user.getUserPwd());
        return userService.login(userBo);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public BaseResult login4Get(String userName,String userPwd) {
        LoginUserVo user=new LoginUserVo();
        user.setUserName(userName);
        user.setUserPwd(userPwd);

        BaseResult baseResult= check(user);
        if(baseResult!=null && baseResult.getStatus()!=BaseResultError.API_OK.getStatus()){
            return baseResult;
        }
        UserBo userBo=new UserBo();
        userBo.setUserName(user.getUserName());
        userBo.setUserPwd(user.getUserPwd());
        return userService.login(userBo);
    }
}
