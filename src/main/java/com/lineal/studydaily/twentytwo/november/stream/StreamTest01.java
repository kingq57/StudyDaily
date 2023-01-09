package com.lineal.studydaily.twentytwo.november.stream;

import java.util.*;

/**
 * @description: Stream流测试类01
 * @author: lineal
 * @date: 2022/12/7
 * @version: 1.0
 **/
public class StreamTest01 {

    public static void main(String[] args) {
//        test01();

//        testFilter();
        
//        testMap();
        
//        testSorted();

//        testFlatMap01();

//        testFlatMap02();
        
        testMaxAndMin();
    }
    
    
    /** 
     * @description 分别获取这些作家的所出书记的最高分和最低分
     * @author lineal
     * @date 2023/1/9 
     * @param 
     * @return void
     **/
    private static void testMaxAndMin() {
        List<Author> authors = getAuthors();

        final Optional<Book> max = authors.stream()
                .flatMap(a -> a.getBooks().stream())
                .distinct()
                .max(Comparator.comparingInt(Book::getScore));
        System.out.println(max.get().getScore());
    }

    /**
     * @description flatMap测试方法02
     * @author lineal
     * @date 2022/12/12
     * @param
     * @return void
     **/
    private static void testFlatMap02() {
//        打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学、爱情
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * @description flatMap测试方法01
     * @author lineal
     * @date 2022/12/12
     * @param
     * @return void
     **/
    private static void testFlatMap01() {
        // 打印所有书籍的名字。要求对重复的元素进行去重。
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    /**
     * @description 中间操作,排序操作
     * @author lineal
     * @date 2022/12/12
     * @param
     * @return void
     **/
    private static void testSorted() {
        // 对流中的元素按照年龄进行降序排序,并且不能有重复的元素
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge() - o1.getAge()))
                .forEach(author -> System.out.println(author.getAge()));
    }


    /**
     * @description 中间操作,map测试
     * @author lineal
     * @date 2022/12/7
     * @param
     * @return void
     **/
    private static void testMap() {
        // 打印所有作家的姓名
        List<Author> authors = getAuthors();
//        authors.stream()
//                .map(Author::getName)
//                .forEach(System.out::println);
        authors.stream()
                .map(Author::getAge)
                .map(age-> age +10)
                .forEach(System.out::println);
    }

    /** 
     * @description 中间操作filter：可以对流中的元素进行条件过滤,符合过滤条件的才会保留在流当中
     * @author lineal
     * @date 2022/12/7 
     * @param 
     * @return void
     **/
    private static void testFilter() {
        List<Author> authors = getAuthors();

        // 打印所有姓名长度大于1的作家的姓名
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    /** 
     * @description 我们可以调用getAuthors方法获取到作家的集合,现在需要打印所有年龄小于18的作家的名字,并且要注意去重
     * @author lineal
     * @date 2022/12/7 
     * @param 
     * @return void
     **/
    private static void test01() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .filter(author -> {
                    System.out.println("123");
                    return author.getAge() < 18;
                })
                .forEach(author -> System.out.println(author.getName()));
    }


    private static List<Author> getAuthors(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "🔪的两侧是光明与黑", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难被她所在的时代理解"));

        books3.add(new Book(5L,"你的🗡就是我的🗡", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(5L,"风与🗡", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎样的火花"));
        books3.add(new Book(5L,"风与🗡", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎样的火花"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }

}
