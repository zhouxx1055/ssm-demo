package com.zxx.demo.dao.sys.user;

import com.zxx.demo.module.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  14:56
 */
public interface UserMapper {


    long insertUser(UserDto userDto);

    int insertBatchUser(@Param("list") List<UserDto> users);

    int deleteUserById(UserDto userDto);

    int deleteUser(UserDto userDto);

    int updateUser(UserDto userDto);

    UserDto getUser(UserDto userDto);

    List<UserDto> getUserList(UserDto userDto);

    int getExistsUser(UserDto userDto);

    UserDto getUserById(UserDto userDto);

    List<UserDto> getUserListByLike(UserDto userDto);

    List<UserDto> getUserListByIn(UserDto userDto);


}
