package com.lineal.studydaily.twentytwo.november.anonymoussubclass;

/**
 * @description: 匿名内部类测试
 * @author: lineal
 * @date: 2022/11/30
 * @version: 1.0
 **/
public class Test01 {

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.bird.name);
    }
    public String ANIMAL = "动物";

    public void accessTest(){
        System.out.println("匿名内部类访问其外部方法");
    }

    public void print(){
        bird.printAnimalName();
    }


    class Animal{
        private String name;

        public Animal(String name){
            this.name = name;
        }

        public void printAnimalName(){
            System.out.println(bird.name);
        }
    }


    Animal bird = new Animal("鸟"){
        public int age = 12;

        @Override
        public void printAnimalName(){
            accessTest();
            System.out.println(ANIMAL);
            super.printAnimalName();
        }
    };



}
