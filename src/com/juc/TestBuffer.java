package com.juc;

import java.nio.ByteBuffer;

/**
 * @package_name: com.juc
 * @name: TestBuffer
 * @author: angenin
 * @dateTime: 2020/8/11 11:09 上午
 **/
public class TestBuffer {
    public static void main(String[] args) {
        String str = "abcde";

        //1. ByteBuffer.allocate(int)：分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(10);

        System.out.println("----------allocate()----------");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //2.put()：存数据
        buf.put(str.getBytes());

        System.out.println("----------put()----------");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //3.flip()：切换成读数据模式
        buf.flip();

        System.out.println("----------flip()----------");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //4.get()：读数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);

        System.out.println("----------get()----------");
        System.out.println(new String(dst));
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //5.rewind()：把position变为0，从头开始再读数据
        buf.rewind();

        System.out.println("----------rewind()----------");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());



        //6.clear()：清空缓冲区，limit和position初始化，但缓冲区的数据还在，只是处于"被遗忘"状态，可以被读取到
        buf.clear();

        System.out.println("----------clear()----------");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //因为clear()会影响mark标记，所以放到另一个方法
        show();
    }

    public static void show(){
        String str = "abcde";

        ByteBuffer buf = ByteBuffer.allocate(10);

        buf.put(str.getBytes());

        buf.flip();

        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //从0开始，读两位
        byte[] bs = new byte[2];
        buf.get(bs);

        System.out.println("第一次读取：");
        System.out.println(new String(bs));
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //7.mark：标记，记录position当前的位置
        buf.mark();
        System.out.println("----------mark()标记----------");

        //从2开始，读两位
        buf.get(bs);
        System.out.println(new String(bs));

        System.out.println("第二次读取：");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //buf.clear();  //标记会被clear()清除，清除后如果reset()会有 InvalidMarkException 异常

        //8.reset()：恢复position到标记的位置
        buf.reset();

        System.out.println("----------reset()----------");
        System.out.println("缓冲区总大小capacity：" + buf.capacity());
        System.out.println("limit的位置：" + buf.limit());
        System.out.println("position目前的位置：" + buf.position());

        //9.hasRemaining()：position到limit之间是否还有位置，即是否有剩余的数据，有为true
        if(buf.hasRemaining()){

            //10.remaining()：position到limit之间的位置差，即获取缓冲区中剩余可操作的数据的数量
            System.out.println("剩余三个type数据没读取：" + buf.remaining());
        }
    }
}
