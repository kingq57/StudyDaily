package com.lineal.studydaily.twentytwo.september.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 用户实体类
 * @author: lineal
 * @date: 2022/9/14
 * @version: 1.0
 **/
@Data
@TableName("user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE )
    private LocalDateTime updateTime;
    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted; //0 false 未删除  1 true 已删除
}
