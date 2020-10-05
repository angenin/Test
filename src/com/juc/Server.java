package com.juc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @package_name: com.juc
 * @name: Server
 * @author: angenin
 * @dateTime: 2020/8/12 10:04 下午
 **/

//服务端
public class Server {
//    public static void main(String[] args) throws IOException {
//        //1.获取通道
//        ServerSocketChannel ssChannel = ServerSocketChannel.open();
//        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,
//                                                                            StandardOpenOption.CREATE);
//
//        //2.绑定连接
//        ssChannel.bind(new InetSocketAddress(8848));
//
//        //3.获取客户端连接的通道
//        SocketChannel sChannel = ssChannel.accept();
//
//        //4.分配指定大小的缓冲区
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//
//        //5.接收客户端的数据，并保持到本地
//        while(sChannel.read(buf) != -1){
//            buf.flip();
//            outChannel.write(buf);
//            buf.clear();
//        }
//
//        //6.接收成功后，发送反馈给客户端
//        buf.put("服务端成功接收数据！".getBytes());
//        buf.flip();
//        sChannel.write(buf);
//
//        //7.关闭通道
//        sChannel.close();
//        outChannel.close();
//        ssChannel.close();
//    }

//    public static void main(String[] args) throws IOException {
//        //1.获取通道
//        ServerSocketChannel ssChannel = ServerSocketChannel.open();
//
//        //2.切换为非阻塞模式
//        ssChannel.configureBlocking(false);
//
//        //3.绑定连接
//        ssChannel.bind(new InetSocketAddress(8848));
//
//        //4.获取选择器
//        Selector selector = Selector.open();
//
//        //5.将通道注册到选择器上，并指定监听"接收事件"
//        //OP_ACCEPT：接收事件
//        //OP_CONNECT：连接事件
//        //OP_READ：读事件
//        //OP_WRITE：写事件
//        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
//
//        //6.轮询式的获取选择器上已经"准备就绪"的事件，大于0表示选择器上已经有"准备就绪"的事件
//        while (selector.select() > 0){
//
//            //7.获取当前选择器中所有注册的"选择键(已就绪的监听事件)"
//            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
//
//            //迭代
//            while (it.hasNext()){
//                //8.获取准备"就绪"的事件
//                SelectionKey sk = it.next();
//
//                //9.判断具体是什么事件准备就绪
//                //isAcceptable：接收就绪
//                //isConnectable：连接就绪
//                //isReadable：读就绪
//                //isWritable：写就绪
//                if(sk.isAcceptable()){
//
//                    //10.若"接收就绪"，获取客户端连接
//                    SocketChannel sChannel = ssChannel.accept();
//
//                    //11.切换为非阻塞模式
//                    sChannel.configureBlocking(false);
//
//                    //12.将该通道注册到选择器上
//                    sChannel.register(selector, SelectionKey.OP_READ);
//                }else if (sk.isReadable()){
//                    //13.获取当前选择器上"读就绪"状态的通道
//                    SocketChannel sChannel = (SocketChannel) sk.channel();
//
//                    //14.读取数据
//                    ByteBuffer buf = ByteBuffer.allocate(1024);
//
//                    int len = 0;
//                    while ((len = sChannel.read(buf)) != -1){
//                        buf.flip();
//                        System.out.println(new String(buf.array(), 0, len));
//                        buf.clear();
//                    }
//                }
//
//                //15.操作完成后，取消选择键SelectionKey
//                it.remove();
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        dc.bind(new InetSocketAddress(8848));

        Selector selector = Selector.open();

        dc.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()){
                SelectionKey sk = it.next();

                if (sk.isReadable()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    //接收
                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(), 0, buf.limit()));
                    buf.clear();
                }
            }
            it.remove();
        }
    }
}
