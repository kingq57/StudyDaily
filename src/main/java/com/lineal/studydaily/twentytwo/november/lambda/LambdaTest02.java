package com.lineal.studydaily.twentytwo.november.lambda;

import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/**
 * @description: Lambda表达式学习测试二
 * @author: lineal
 * @date: 2022/11/30
 * @version: 1.0
 **/
public class LambdaTest02 {

    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();
//        new Runnable() {
//            @Override
//            public void run() {
//                strings.add("1");
//            }
//        };

//        System.out.println( typeConvert((Function<String, Integer>) Integer::valueOf));
        foreachArr(System.out::println, new int[]{1, 2, 5, 8, 88});
    }


    public static void printNum(IntPredicate intPredicate){
        int[] arr = {5, 6, 7, 8, 9, 4};
        for (int i : arr) {
            if (intPredicate.test(i)){
                System.out.println(i);
            }
        }
    }


    public static <R> R typeConvert(Function<String, R> function){
        String str = "123456";
        return function.apply(str);
    }

    public static void foreachArr(IntConsumer consumer, int[] arr){
        for (int i : arr) {
            consumer.accept(i);
        }
    }
}
