package com.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @package_name: com.juc
 * @name: TestReadWriteLock
 * @author: angenin
 * @dateTime: 2020/8/10 9:38 下午
 **/
public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int) (Math.random() * 101));
            }
        }, "Write:").start();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }
    }
}

class ReadWriteLockDemo{
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void get(){
        lock.readLock().lock();

        try {

            System.out.println(Thread.currentThread().getName() + ":" + number);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }


    public void set(int number){
        lock.writeLock().lock();

        try {

            System.out.println(Thread.currentThread().getName());
            this.number = number;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
