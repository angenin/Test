package com.angnein;

import java.util.Date;

/**
 * @package_name: com.angnein
 * @name: Test3
 * @author: angenin
 * @dateTime: 2020/7/26 9:01 下午
 **/
public class Test3 {

//    private static int count = 1;
//
//    public static void main(String[] args) {
//        System.out.println(count);
//        count++;
//        main(args);
////        int i = 10;
////        int j = 20;
////        int k = i + j;
////
////        String s = "abc";
////        System.out.println(i);
////        System.out.println(k);
//    }

    public static void main(String[] args) {
        Test3.testStatic(1);
    }

    public static int testStatic(int i){
        Test3 test3 = new Test3();
        Date date = new Date();
        int j = i;
        return j + 1;
    }

    public int getSum(){
        return 1;
    }

    public void testSum(){
        int i = getSum();
    }
}
