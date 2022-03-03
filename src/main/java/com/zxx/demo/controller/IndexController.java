package com.zxx.demo.controller;

import com.zxx.demo.module.bo.UserBo;
import com.zxx.demo.module.common.BaseResult;
import com.zxx.demo.module.input.LoginUserVo;
import com.zxx.demo.util.BaseResultError;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  18:56
 */
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping()
    public BaseResult index(LoginUserVo user) {

        return new BaseResult(BaseResultError.API_OK);
    }

    @SneakyThrows
    @ResponseBody
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public BaseResult exception(String flag) {
        if(flag!=null&&flag!=""){
            Exception exception=  new Exception("测试Controller异常");
            throw exception;
        }
        return new BaseResult(BaseResultError.API_OK);
    }

}
