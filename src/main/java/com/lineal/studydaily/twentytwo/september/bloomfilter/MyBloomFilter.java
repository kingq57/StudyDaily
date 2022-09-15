package com.lineal.studydaily.twentytwo.september.bloomfilter;


import java.util.BitSet;

/**
 * @Description: 布隆过滤器代码实现
 *               https://krisives.github.io/bloom-calculator 布隆过滤器的计算器
 *               五千万数据，0.1%的误判率，要9.96个哈希函数，718879379 bits
 * @author: lineal
 * @date: 2022/09/08
 */

public class MyBloomFilter {

    // 长度为十亿的比特位
    private static final int DEFAULT_SIZE = 256<<22;

    // 选定10个质数用于构建hash函数
    private static final int[] seeds = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    // 存放hash函数的数组
    private static HashFunction[] functions = new HashFunction[seeds.length];

    // 使用bitset来作为布隆过滤器的容器
    private static BitSet bitset = new BitSet(DEFAULT_SIZE);

    // 向布隆过滤器中加入值
    public static void add(String value) {
        if (value != null) {
            for (HashFunction f : functions) {
                //计算 hash 值并修改 bitset 中相应位置为 true
                bitset.set(f.hash(value), true);
            }
        }
    }

    // 布隆过滤器对传入的值判断是否存在
    public static boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (HashFunction f : functions) {
            ret = bitset.get(f.hash(value));
            //一个 hash 函数返回 false 则跳出循环
            if (!ret) {
                break;
            }
        }
        return ret;
    }


    public static void main(String[] args) {

        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }

        // 添加五千万数据
        for (int i = 0; i < 50000000; i++) {
            add(String.valueOf(i));
        }
        System.out.println(contains("500"));
        System.out.println(contains("8000000000000"));
    }
}

