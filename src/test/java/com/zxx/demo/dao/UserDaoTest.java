package com.zxx.demo.dao;

import com.zxx.demo.dao.sys.user.UserMapper;
import com.zxx.demo.module.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/4  10:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-base.xml"})
public class UserDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        UserDto userDto=new UserDto();
        userDto.setUserSex((short) 0);
        List<UserDto> listUser = userMapper.getUserList(userDto);
        logger.info("{}", listUser);
        Assert.assertTrue(listUser.size() > 0);
    }

    @Test
    public void testInsert() {

        UserDto userDto=new UserDto();
        userDto.setUserSex((short) 0);
        userDto.setUserName("Tom");
        userDto.setUserPwd("123123123");
        userDto.setUserPhone("1321234122");
        long cnt = userMapper.insertUser(userDto);
        logger.info("id:{}", userDto.getId());
        logger.info("cnt:{}", cnt);
        logger.info("id:{}", userDto.getId());
        Assert.assertTrue(cnt > 0);

        List<UserDto> list=new ArrayList<UserDto>();
        for(int i=0;i<100;i++){
            userDto=new UserDto();
            userDto.setUserSex((short) 0);
            userDto.setUserName("Tom"+i);
            userDto.setUserPwd("123123123");
            userDto.setUserPhone("1321234122");
            list.add(userDto);
        }
        logger.info("id:{}", list.get(0).getId());
        cnt= userMapper.insertBatchUser(list);
        logger.info("id:{}", list.get(0).getId());
        logger.info("cnt:{}", cnt);
        Assert.assertTrue(cnt == list.size());


        userDto=new UserDto();
        userDto.setUserName("Tom");
        List<UserDto> listUser = userMapper.getUserListByLike(userDto);
        logger.info("{}", listUser);
        Assert.assertTrue(listUser.size() > 0);
        for (UserDto user:listUser) {
            userMapper.deleteUserById(user);
        }
        listUser = userMapper.getUserListByLike(userDto);
        Assert.assertTrue(0 == listUser.size());
    }

}
