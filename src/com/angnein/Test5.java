package com.angnein;

import sun.applet.Main;

/**
 * @package_name: com.angnein
 * @name: Test5
 * @author: angenin
 * @dateTime: 2020/8/1 9:45 下午
 **/
public class Test5 {

//    public static void main(String[] args) {
//        final String s1 = new String("a");
//        //final String s1 = "a";
//        //String s2 = "b";
//        String s3 = "ab";
//        String s4 = s1 + "b";
//        System.out.println(s3 == s4);
//    }

    public static void main(String[] args) {
        //例1
        String s1 = new String("1");     //此时会去字符串常量池中创建"1"
        s1.intern();     //调用此方法前，字符串常量池中已经存在"1"，所以调用此方法没有什么意义
        String s2 = "1";
        //s1是堆空间的String对象，而s2是堆空间字符串常量池中的"1"
        System.out.println(s1 == s2);    //jdk6: false   jdk7/8: false

        //----------------------------------

        //例2
        String s3 = new String("1") + new String("1");  //s3变量记录的地址为：new String("11")
        //执行完上一行代码后，此时字符串常量池中是不存在"11"的
        s3.intern();    //在字符串常量池中生成"11"
        /* s3.intern()的理解：
            jdk6：在字符串常量池中创建了一个新的对象"11"，也就有了新地址（字符串常量池在方法区(永久代)中）
            jdk7/8：此时并不会在字符串常量池中创建"11"，而是创建一个指向堆空间new String("11")的地址，
                    即字符串常量池中"11"其实只是一个引用，指向堆空间s3的地址，节省空间（字符串常量池在堆中）
         */

        String s4 = "11";   //s4变量记录的地址：为上一行代码执行后生成的"11"的地址
        System.out.println(s3 == s4);   //jdk6: false   jdk7/8: true
    }
}
