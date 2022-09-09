package com.lineal.study.twentytwo.september.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @description: Guava布隆过滤器应用
 * @author: lineal
 * @create: 2022-09-09
 * @version: 1.0
 **/
public class GuavaBloomFilter {
    
    /**
     * @description Guava布隆过滤器应用测试
     * @author lineal
     * @date 2022/9/9
     * @param args
     * @return void
     **/
    public static void main(String[] args) {
        BloomFilter<Integer> integerBloomFilter = BloomFilter.create(Funnels.integerFunnel(), 50000000, 0.001);
        for (int i = 0; i < 40000000; i++) {
            integerBloomFilter.put(i);
        }
        System.out.println(integerBloomFilter.mightContain(5));
        System.out.println(integerBloomFilter.mightContain(50000000));
        System.out.println(integerBloomFilter.mightContain(30000000));
    }
}
