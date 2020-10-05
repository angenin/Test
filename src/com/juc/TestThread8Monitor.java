package com.juc;

/**
 * @package_name: com.juc
 * @name: TestThread8Monitor
 * @author: angenin
 * @dateTime: 2020/8/10 10:10 下午
 **/
public class TestThread8Monitor {
    /*
        one two
        one two
        three one two
        two one
        two one
        one two
        two one
        one two
     */

    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Number.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number.getThree();
//            }
//        }).start();
    }
}


class Number{
    public static synchronized void getOne(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo(){
        System.out.println("two");
    }

    public void getThree(){
        System.out.println("three");
    }
}