package com.lineal.study.twentytwo.september.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lineal.studydaily.twentytwo.september.mybatisplus.mapper.UserMapper;
import com.lineal.studydaily.twentytwo.september.mybatisplus.pojo.User;
import com.lineal.studydaily.StudyDailyApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 数据库连接测试类
 * @author: lineal
 * @date: 2022/9/14
 * @version: 1.0
 **/

@SpringBootTest(classes = StudyDailyApplication.class)
// SpringBoot默认包扫描机制： 从启动类所在包开始，扫描当前包及其子级包下的所有文件。
public class MybatisPlusTest {
    @Resource
    UserMapper userMapper;

    @Test
    public void selectList(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getId, 1L);

        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void addList(){
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("MangOs" + i);
            user.setAge(i);
            user.setEmail("xxxx" + i + "@mangos.com");
            userMapper.insert(user);
        }
    }
}
