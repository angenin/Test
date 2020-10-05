package com.angnein;

import java.net.URL;

/**
 * @package_name: com.angnein
 * @name: Test2
 * @author: angenin
 * @dateTime: 2020/7/26 11:41 上午
 **/
public class Test2 {

    public static void main(String[] args) {
        //系统(应用)类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取系统类加载器的上层，扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);     //sun.misc.Launcher$ExtClassLoader@61bbe9ba

        //获取扩展类加载器的上层（其上层为引导类加载器，但是获取不到）
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);   //null

        //对于用户自定义类而言，默认使用系统类加载器加载
        ClassLoader classLoader = Test2.class.getClassLoader();
        System.out.println(classLoader);        //sun.misc.Launcher$AppClassLoader@18b4aac2

        //String类的类加载器是引导类加载器，同样获取不到
        //Java的核心类库都是使用引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);       //null

        System.out.println("------");

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }

}
