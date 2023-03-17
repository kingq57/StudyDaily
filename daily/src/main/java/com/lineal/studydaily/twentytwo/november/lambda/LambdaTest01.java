package com.lineal.studydaily.twentytwo.november.lambda;

import java.util.function.IntBinaryOperator;

/**
 * @description: Lambda表达式学习01--IntBinaryOperator函数式接口学习
 * @author: lineal
 * @date: 2022/11/29
 * @version: 1.0
 **/
public class LambdaTest01 {

    public static void main(String[] args) {
        System.out.println(calculateNumber((left, right) -> left * right));
    }

    public static int calculateNumber(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
