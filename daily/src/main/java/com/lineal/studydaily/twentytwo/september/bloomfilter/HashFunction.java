package com.lineal.studydaily.twentytwo.september.bloomfilter;

import lombok.Data;
import org.jetbrains.annotations.NotNull;


/**
 * @Description: 布隆过滤器所用的hash函数
 * @author: lineal
 * @date: 2022/09/08
 */
@Data
public class HashFunction {
    private int size;
    private int seed;

    public HashFunction(int size, int seed){
        this.size = size;
        this.seed = seed;
    }

    public int hash(@NotNull String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
        return (size - 1) & result;
    }
}
