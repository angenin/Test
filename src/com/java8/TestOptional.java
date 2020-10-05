package com.java8;

import java.util.Optional;

/**
 * @package_name: com.lambda
 * @name: TestOptional
 * @author: angenin
 * @dateTime: 2020/8/9 8:43 下午
 **/
public class TestOptional {

    public static void main(String[] args) {
        //Optional.of(T t)
//        Optional<Employee> op = Optional.of(new Employee());
//        Employee employee = op.get();
//        System.out.println(employee);
//
//        //传入null后也是会报空指针异常，但能快速锁定空指针异常的位置
//        Optional<Employee> op2 = Optional.of(null);
//        Employee employee2 = op.get();
//        System.out.println(employee);

        //Optional.empty()
        Optional<Object> op = Optional.empty();
        System.out.println(op.get());

    }

}
