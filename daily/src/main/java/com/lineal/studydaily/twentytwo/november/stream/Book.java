package com.lineal.studydaily.twentytwo.november.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: Book实体类
 * @author: lineal
 * @date: 2022/12/7
 * @version: 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {

    //id
    private Long id;

    //书名
    private String name;

    //分类
    private String category;

    //评分
    private Integer score;

    //简介
    private String intro;
}
