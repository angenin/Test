package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @package_name: com.lambda
 * @name: TestLambda
 * @author: angenin
 * @dateTime: 2020/8/8 9:31 下午
 **/
public class TestLambda {

//    public static void main(String[] args) {
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello Java!");
//            }
//        };
//        r1.run();
//
//        System.out.println("-----------");
//
//        Runnable r2 = () -> System.out.println("Hello Lambda!");
//        r2.run();
//    }


//    public static void main(String[] args) {
//        Consumer<String> con1 = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        con1.accept("hello");
//
//        Consumer<String> con2 = (s) -> System.out.println(s);
//        con2.accept("lambda");
//    }

//    public static void main(String[] args) {
//        Comparator<Integer> com1 = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                System.out.println("hello");
//                return Integer.compare(o1, o2);
//            }
//        };
//        System.out.println(com1.compare(2, 3));
//
//
//        Comparator<Integer> com2 = (o1, o2) -> {
//                System.out.println("lambda");
//                return Integer.compare(o1, o2);
//            };
//        System.out.println(com1.compare(2, 3));
//    }

//    public static void main(String[] args) {
//        Comparator<Integer> com1 = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        };
//        System.out.println(com1.compare(2, 3));
//
//
//        Comparator<Integer> com2 = (x, y) -> Integer.compare(x, y);
//        System.out.println(com2.compare(2, 3));
//    }

    public static void main(String[] args) {
//        //Consumer<T> 消费型接口：有参数，无返回值
//        happy(1000, (m) -> System.out.println("消费" + m + "元"));
//
//        //Supplier<T> 供给型接口：有返回值
//        List<Integer> lists = getNumList(10, () -> (int)(Math.random() * 100));
//        lists.forEach(System.out::println);
//
//        //Function<T, R> 函数型接口：对传参进行处理后返回结果
//        String s = strHandler("\t\t\t aaa  ", (str) -> str.trim());
//        System.out.println(s);
//        System.out.println(strHandler("ABCD", (str) -> str.toLowerCase()));
//
//        //Predicate<T> 断言型接口：对传参进行判断/过滤
//        List<String> list = Arrays.asList("hello lambda aa bbb cccccc www ok".split(" "));
//        List<String> strings = filterStr(list, (s) -> s.length() > 3);
//        strings.forEach(System.out::println);

//        //对象::实例方法名
//        Consumer<String> con = (x) -> System.out.println(x);
//        Consumer<String> con2 = System.out::println;
//
//        //类::静态方法名
//        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
//        Comparator<Integer> com2 = Integer::compare;
//
//        //类::实例方法名
//        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
//        BiPredicate<String, String> bp2 = String::equals;

//        //无参构造器
//        Supplier<Employee> emp = () -> new Employee();
//        Supplier<Employee> emp2 = Employee::new;
//
//        //一个参数的构造器
//        Function<Integer, Employee> emp3 = (x) -> new Employee(x);
//        Function<Integer, Employee> emp4 = Employee::new;

        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(5);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(4);
        System.out.println(strs2.length);

    }

    public static void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    public static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> lists = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            lists.add(sup.get());
        }
        return lists;
    }

    public static String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    public static List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String s : list) {
            if(pre.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }
}
