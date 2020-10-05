package com.java8;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Method;

/**
 * @package_name: com.java8
 * @name: TestAnnotation
 * @author: angenin
 * @dateTime: 2020/8/10 11:42 上午
 **/
public class TestAnnotation {

    //@NotNull（类型注解）：对象不能为空
    private @NotNull Object obj = null;

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str){
    }

    public static void main(String[] args) throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");

        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation ma : mas) {
            System.out.println(ma.value());
        }
    }
}
