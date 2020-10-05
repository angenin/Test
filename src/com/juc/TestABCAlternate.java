package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @package_name: com.juc
 * @name: TestABCAlternate
 * @author: angenin
 * @dateTime: 2020/8/10 9:08 下午
 **/
public class TestABCAlternate {

    public static void main(String[] args) {
        ABCAlternate abc = new ABCAlternate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    abc.loopA(i);
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    abc.loopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    abc.loopC(i);
                }
                System.out.println("-----------------");
            }
        }, "C").start();
    }

}

class ABCAlternate{
    private static int number = 1;  //标记，执行A，B，C

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop){
        lock.lock();    //加锁
        try {
            if(number != 1){
                condition1.await();
            }

            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop + "\t" + i);
            }

            number = 2;
            condition2.signal();    //唤醒下一个

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();  //释放锁
        }

    }


    public void loopB(int totalLoop){
        lock.lock();    //加锁
        try {
            if(number != 2){
                condition2.await();
            }

            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop + "\t" + i);
            }

            number = 3;
            condition3.signal();    //唤醒下一个

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();  //释放锁
        }

    }



    public void loopC(int totalLoop){
        lock.lock();    //加锁
        try {
            if(number != 3){
                condition3.await();
            }

            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop + "\t" + i);
            }

            number = 1;
            condition1.signal();    //唤醒下一个

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();  //释放锁
        }

    }

}
