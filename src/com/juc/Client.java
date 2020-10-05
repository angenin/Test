package com.juc;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @package_name: com.juc
 * @name: Client
 * @author: angenin
 * @dateTime: 2020/8/12 10:04 下午
 **/

//客户端
public class Client {
//    public static void main(String[] args) throws IOException {
//        //1.获取通道
//        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8848));
//        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
//
//        //2.分配指定大小的缓冲区
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//
//        //3.读取本地文件，并发送到服务端
//        while (inChannel.read(buf) != -1){
//            buf.flip();
//            sChannel.write(buf);
//            buf.clear();
//        }
//
//        //4.告诉服务端发送完成（不然服务端不知道客户端是否已经发送完成，服务端会一直处于等待状态）
//        sChannel.shutdownOutput();
//
//        //5.接收服务端的反馈
//        int len = 0;
//        while ((len = sChannel.read(buf)) != -1){
//            buf.flip();
//            System.out.println(new String(buf.array(), 0, len));
//            buf.clear();
//        }
//
//        //6.关闭通道
//        inChannel.close();
//        sChannel.close();
//    }

//    public static void main(String[] args) throws IOException {
//        //1.获取通道
//        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8848));
//
//        //2.切换为非阻塞模式
//        sChannel.configureBlocking(false);
//
//        //3.分配指定大小的缓冲区
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//
//        //4.发送数据(当前时间)给服务端
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()){
//            String str = sc.next();
//            buf.put((str + "【" + LocalDateTime.now().toString() + "").getBytes());
//            buf.flip();
//            sChannel.write(buf);
//            buf.clear();
//        }
//
//        //5.关闭通道
//        sChannel.close();
//    }

    public static void main(String[] args) throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(LocalDateTime.now().toString().getBytes());
        buf.flip();
        //发送
        dc.send(buf, new InetSocketAddress("127.0.0.1", 8848));
        buf.clear();

        dc.close();
    }
}
