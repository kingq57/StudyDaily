package com.lineal.study.twentytwo.september.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lineal.TestDailyApplication;
import com.lineal.studydaily.twentytwo.september.mybatisplus.mapper.UserMapper;
import com.lineal.studydaily.twentytwo.september.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: KingQqq57
 * @description: Interceptor测试
 * @date: 2022/9/25 22:35
 * @version: 1.0
 */
@SpringBootTest(classes = TestDailyApplication.class)
public class InterceptorTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectPage(){
        Page<User> userPage = new Page<>(12, 5);
        userMapper.selectPage(userPage, null);
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
        System.out.println(userPage.getTotal());
        System.out.println(userPage.hasNext());
        System.out.println(userPage.hasPrevious());
    }
}
