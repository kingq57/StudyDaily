package com.lineal.studydaily.twentytwo.november.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: Author实体类
 * @author: lineal
 * @date: 2022/12/7
 * @version: 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author {

    private Long id;

    private String name;

    private Integer age;

    private String intro;

    private List<Book> books;
}
