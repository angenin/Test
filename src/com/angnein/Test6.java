package com.angnein;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @package_name: com.angnein
 * @name: Test6
 * @author: angenin
 * @dateTime: 2020/8/7 10:04 上午
 **/
public class Test6 {

    public static void main(String[] args) {
//        List<User> list = new ArrayList<User>();
//        list.add(new User(1, "aaa"));
//        SoftReference<User> sf = new SoftReference<>(new User(1, "aaa"));
//        WeakReference<User> wf = new WeakReference<>(new User(2, "aaa"));

        WeakHashMap<String, String> whm = new WeakHashMap<String, String>();
        whm.put("1", "a");

        System.out.println(whm.get("1"));
        System.gc();
        System.out.println(whm.get("1"));

        try {
            byte[] b = new byte[1024 * 1024 * 7];
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(whm.get("1"));
        }
    }

}
