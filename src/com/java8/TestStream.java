package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @package_name: com.lambda
 * @name: TestStream
 * @author: angenin
 * @dateTime: 2020/8/9 10:57 上午
 **/

//创建流
public class TestStream {

    public static void main(String[] args) {
        //创建流

        //1. Conllection系列的集合可以通过stream()或parallelStream()获取流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2. 数组通过Arrays的静态方法stream()获取流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3. 通过Stream的静态方法of()获取流
        Stream<String> stream3 = Stream.of("aa", "bb", "ccc");

        //4. 创建无限流
        //4.1. 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4
            //中间操作
            .limit(10)
            //终止操作
            .forEach(System.out::println);

        //4.2. 生成
        Stream.generate(() -> Math.random())
            //中间操作
            .limit(5)
            //终止操作
            .forEach(System.out::println);
    }

}
