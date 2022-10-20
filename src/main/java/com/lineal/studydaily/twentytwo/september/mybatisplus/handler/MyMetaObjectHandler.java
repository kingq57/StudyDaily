package com.lineal.studydaily.twentytwo.september.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description: MybatisPlus自动填充学习
 * @author: lineal
 * @date: 2022/9/14
 * @version: 1.0
 **/

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        final Object createTime = this.getFieldValByName("createTime", metaObject);
        // 判断要填充的字段是否有值
        if (createTime == null){
            // 判断要自动填充的字段是否在当前对象中
            if (metaObject.hasSetter("createTime")){
                this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
            }
        }

        log.info("updateTime在实体类中是否存在" +metaObject.hasSetter("updateTime"));
        if (metaObject.hasSetter("updateTime")){
            this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
        final boolean a = metaObject.hasSetter("a");
        log.info("a在实体类中是否存在" +a);
        if (a){
            log.info("**************************************************");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateTime")){
            this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
    }
}
