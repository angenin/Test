package com.juc;

import sun.applet.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @package_name: com.juc
 * @name: TestChannel
 * @author: angenin
 * @dateTime: 2020/8/11 8:31 下午
 **/
public class TestChannel {

//    //利用通道完成文件复制（非直接缓冲区）
//    public static void main(String[] args)  {
//        long start = System.currentTimeMillis();
//
//        //try-with-resource语法糖，在try()里new的对象会调用close()自动关闭
//        try (FileInputStream fis = new FileInputStream("/Users/pro/Downloads/1.mp4");
//             FileOutputStream fos = new FileOutputStream("/Users/pro/Downloads/2.mp4");
//             //获取通道
//             FileChannel inChannel = fis.getChannel();
//             FileChannel outChannel = fos.getChannel()) {
//
//            ByteBuffer buf = ByteBuffer.allocate(1024);
//
//            //将inChannel通道中的数据写到buf缓冲区中，如果返回-1表示写入失败，inChannel通道中已没有数据
//            while (inChannel.read(buf) != -1){
//                //切换为读模式
//                buf.flip();
//                //将buf缓冲区数据写入outChannel通道中
//                outChannel.write(buf);
//                //清空（初始化）缓冲区
//                buf.clear();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            long end = System.currentTimeMillis();
//            System.out.println(end - start);
//        }
//    }

//    //使用直接缓冲区完成文件的复制（内存映射文件）
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        try (
//            //StandardOpenOption.READ：读
//            FileChannel inChannel = FileChannel.open(Paths.get("/Users/pro/Downloads/1.mp4"), StandardOpenOption.READ);
//            //StandardOpenOption.WRITE：写
//            FileChannel outChannel = FileChannel.open(Paths.get("/Users/pro/Downloads/2.mp4"), StandardOpenOption.WRITE,
//                                            //因为下面outMappedBuf只有读写模式，没有读模式，所以需要加上READ
//                                            StandardOpenOption.READ,
//                                            //StandardOpenOption.CREATE：不存在就创建，存在就覆盖
//                                            //StandardOpenOption.CREATE_NEW：不存在就创建，存在就报错FileAlreadyExistsException
//                                            StandardOpenOption.CREATE)) {
//
//            //内存映射文件
//            //FileChannel.MapMode.READ_ONLY：只读模式
//            //FileChannel.MapMode.READ_WRITE：读写模式
//            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
//            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
//
//            //直接对缓冲区进行数据的读写操作
//            byte[] dst = new byte[inMappedBuf.limit()];
//            //数据放到dst数组中
//            inMappedBuf.get(dst);
//            //数据放到outMappedBuf中
//            outMappedBuf.put(dst);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            long end = System.currentTimeMillis();
//            System.out.println(end - start);
//        }
//    }

//    //通道间的数据传输（直接缓冲区）
//    public static void main(String[] args) {
//        try (
//            //StandardOpenOption.READ：读
//            FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
//            //StandardOpenOption.WRITE：写
//            FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,
//                                            //StandardOpenOption.CREATE：不存在就创建，存在就覆盖
//                                            //StandardOpenOption.CREATE_NEW：不存在就创建，存在就报错FileAlreadyExistsException
//                                            StandardOpenOption.CREATE)) {
//
//            //inChannel到outChannel
//            //下面两个写法，作用一样
////            inChannel.transferTo(0, inChannel.size(), outChannel);      //主动给
//            outChannel.transferFrom(inChannel, 0 ,inChannel.size());    //主动拿
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


//    public static void main(String[] args) throws Exception {
//        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
//
//        //1.获取通道
//        FileChannel channel1 = raf1.getChannel();
//
//        //2.分配指定大小的缓冲区
//        ByteBuffer buf1 = ByteBuffer.allocate(100);
//        ByteBuffer buf2 = ByteBuffer.allocate(1024);
//        ByteBuffer[] bufs = {buf1, buf2};
//
//        //3.分散读取
//        channel1.read(bufs);
//
//        for (ByteBuffer buf : bufs) {
//            //把bufs中的缓冲区都变为写模式
//            buf.flip();
//        }
//
//        //前100个type
//        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
//        System.out.println("-------------------------");
//        //后1024个type
//        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
//
//
//        //4.聚集写入
//        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
//        FileChannel channel2 = raf2.getChannel();
//
//        channel2.write(bufs);
//    }


    public static void main(String[] args) throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("你好世界！");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cBuf);

        System.out.println(" v v v GBK编码后的数据 v v v");
        for (int i = 0; i < 10; i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(" v v v GBK解码后的数据 v v v");
        System.out.println(cBuf2.toString());

        System.out.println("-------------------------------");

        Charset cs2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(" v v v UTF-8解码后的数据 v v v");
        System.out.println(cBuf3.toString());
    }
}
