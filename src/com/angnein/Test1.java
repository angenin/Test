package com.angnein;

/**
 * @package_name: com.angnein
 * @name: Test1
 * @author: angenin
 * @dateTime: 2020/7/22 5:12 下午
 **/
public class Test1 {

//    private static int number1 = 10;
//
//    static{
//        number1 = 20;
//        number2 = 20;
//    }
//
//    private static int number2 = 10;
//
//    private final static int number3 = 10;
//
//    public static void main(String[] args) {
//        System.out.println(Test1.number1);  //20    按照顺序先后进行赋值
//        System.out.println(Test1.number2);  //10    按照顺序先后进行赋值
//        System.out.println(Test1.number3);
//    }


//    public static void main(String[] args) {
//        System.out.println(Son.B);
//    }

    public static void main(String[] args) {
        System.out.println(A.a);
    }
}


//class Father{
//    public static int A = 1;
//
//    static {
//        A = 2;
//    }
//}
//
//class Son extends Father{
//    public static int B = A;
//}

class A{

    public static int a = 1;

    static {
        a = 2;
    }
}