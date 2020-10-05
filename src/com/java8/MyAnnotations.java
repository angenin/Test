package com.java8;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @package_name: com.java8
 * @name: MyAnnotations
 * @author: angenin
 * @dateTime: 2020/8/10 11:43 上午
 **/

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})  //注解可加的位置
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
public @interface MyAnnotations {

    //MyAnnotation的注解容器
    MyAnnotation[] value();

}
