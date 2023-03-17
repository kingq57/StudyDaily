package com.lineal.spring_study.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description: 获取SpringBean工具类
 * @author: lineal
 * @date: 2023/3/17
 * @version: 1.0
 **/
@Component
public class SpringStudyUtils implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return ac;
    }
}
