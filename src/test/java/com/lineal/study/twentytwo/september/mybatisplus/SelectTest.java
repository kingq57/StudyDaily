package com.lineal.study.twentytwo.september.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lineal.study.twentytwo.september.mybatisplus.mapper.UserMapper;
import com.lineal.study.twentytwo.september.mybatisplus.pojo.User;
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
public class SelectTest {
    @Resource
    UserMapper userMapper;

    @Test
    public void selectList(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getId, 1L);
        userMapper.selectList(queryWrapper);
    }
}
