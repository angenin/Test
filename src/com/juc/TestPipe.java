package com.juc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @package_name: com.juc
 * @name: com.juc.TestBlockingNIO
 * @author: angenin
 * @dateTime: 2020/8/12 9:54 下午
 **/
public class TestPipe {

    public static void main(String[] args) throws IOException {
        //1.获取管道
        Pipe pipe = Pipe.open();

        //2.将缓冲区中的数据写入管道
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通道单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        //3.读取缓冲区中的数据（节省时间，发送和接收写在一起，可以参照前面的代码拆分成两个）
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, buf.limit()));

        //4.关闭
        sourceChannel.close();
        sinkChannel.close();
    }

}
