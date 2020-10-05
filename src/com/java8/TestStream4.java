package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @package_name: com.lambda
 * @name: TestStream4
 * @author: angenin
 * @dateTime: 2020/8/9 6:06 下午
 **/
public class TestStream4 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .map(x -> x * x)
                .forEach(System.out::println);

        Optional<Integer> count = list.stream()
                .map(x -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }

}
