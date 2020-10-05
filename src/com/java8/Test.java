package com.java8;

/**
 * @package_name: com.lambda
 * @name: Test
 * @author: angenin
 * @dateTime: 2020/8/9 9:25 下午
 **/
public class Test {
    public static void main(String[] args) {
        //当某个类继承和实现的类中存在相同的方法时，如果父类中提供了具体实现，优先父类
        //如果实现的两个接口都有相同的方法，必须重写其中一个接口的方法
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName()); //class

        MyFun.show();
    }
}

interface MyFun{
    default String getName(){
        return "interface";
    }

    //接口中可以写静态方法
    public static void show(){
        System.out.println("interface static method");
    }
}

class MyClass{
    public String getName(){
        return "class";
    }
}

class SubClass extends MyClass implements MyFun {
}