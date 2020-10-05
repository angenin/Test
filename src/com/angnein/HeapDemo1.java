package com.angnein;

/**
 * @package_name: com.angnein
 * @name: HeapDemo
 * @author: angenin
 * @dateTime: 2020/7/28 10:45 上午
 **/
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
