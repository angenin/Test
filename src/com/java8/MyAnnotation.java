package com.java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @package_name: com.java8
 * @name: MyAnnotation
 * @author: angenin
 * @dateTime: 2020/8/10 11:39 上午
 **/
@Repeatable(MyAnnotations.class)    //重复注解需要加上@Repeatable注解修饰，并指定注解的容器
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})  //注解可加的位置（TYPE_PARAMETER：类型注解）
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
public @interface MyAnnotation {

    String value() default "angenin";

}
