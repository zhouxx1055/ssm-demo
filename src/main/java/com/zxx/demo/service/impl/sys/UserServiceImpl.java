package com.zxx.demo.service.impl.sys;

import com.zxx.demo.dao.sys.user.UserMapper;
import com.zxx.demo.module.bo.UserBo;
import com.zxx.demo.module.common.BaseResult;
import com.zxx.demo.module.dto.UserDto;
import com.zxx.demo.service.UserService;
import com.zxx.demo.util.BaseResultError;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  13:47
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @SneakyThrows
    @Override
    public BaseResult login(UserBo userBo) {

        UserDto userDto =new UserDto();
        userDto.setUserName(userBo.getUserName());
        userDto=userMapper.getUser(userDto);

        if(userDto==null){
            return new BaseResult(BaseResultError.API_LOGIN_Fail_USER_NOT_EXISTED);
        }

        if(userDto.getUserName().equals("root")){
            Exception exception=  new Exception("测试Service异常");
            throw exception;
        }

//        //对密码进行 md5 加密
//        String md5Password = DigestUtils.md5DigestAsHex(userBo.getUserPwd().getBytes());

        if(!userDto.getUserPwd().equals(userBo.getUserPwd())){
            return new BaseResult(BaseResultError.API_LOGIN_Fail);
        }

        return new BaseResult(BaseResultError.API_LOGIN_OK);
    }
}
