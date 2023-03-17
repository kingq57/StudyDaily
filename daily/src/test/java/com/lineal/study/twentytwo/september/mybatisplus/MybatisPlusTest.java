package com.lineal.study.twentytwo.september.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.lineal.TestDailyApplication;
import com.lineal.studydaily.twentytwo.september.mybatisplus.mapper.UserMapper;
import com.lineal.studydaily.twentytwo.september.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * @description: 数据库连接测试类
 * @author: lineal
 * @date: 2022/9/14
 * @version: 1.0
 **/

@SpringBootTest(classes = TestDailyApplication.class)
// SpringBoot默认包扫描机制： 从启动类所在包开始，扫描当前包及其子级包下的所有文件。
public class MybatisPlusTest {
    @Resource
    UserMapper userMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;


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
            user.setName("lineal" + i);
            user.setAge(i);
            user.setEmail("xxxx" + i + "@lineal.com");
            userMapper.insert(user);
        }
    }

    @Test
    public void updateList(){
        for (int i = 0; i < 5; i++) {
            LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(User::getEmail, "xxxx" + i + "@lineal.com");
            updateWrapper.set(User::getName, "lineal" + i).set(User::getEmail, "xxxx" + i + "@lineal.com");
            // 这里如果想让自动填充生效，update的第一个参数不能传null，需要传对应的实体类自动填充才会生效
            userMapper.update(new User(), updateWrapper);
        }
    }

    @Test
    /**
     * @description 逻辑删除测试
     * @author lineal
     * @date 2022/9/16
     * @param
     * @return void
     */
    public void deletedTest(){
        LambdaQueryWrapper<User> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(User::getEmail, "xxxx" + 0 + "@lineal.com");
        // 这里如果想让自动填充生效，update的第一个参数不能传null，需要传对应的实体类自动填充才会生效
        userMapper.delete(updateWrapper);
    }

    @Test
    public void jdbcTemplateTest(){
        String sql = "select count(*) from user where name = ? \n and id = ? \n";
        Integer integer = jdbcTemplate.queryForObject(sql, new Object[]{"Tom", 3}, Integer.class);
        System.out.println("jdbcTest");
        System.out.println(integer);
    }

}
