package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @package_name: com.lambda
 * @name: TestStream2
 * @author: angenin
 * @dateTime: 2020/8/9 11:26 上午
 **/

//中间操作
public class TestStream2 {

    private static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 58, 5555.55),
            new Employee("王五", 26, 3333.33),
            new Employee("赵六", 36, 6666.66),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88)
    );

    public static void main(String[] args) {
//        //中间操作：不会执行任何操作
//        //filter
//        Stream<Employee> stream1 = employees.stream()
//                                    //过滤
//                                    .filter((e) -> {
//                                        //没有终止操作时，中间操作不会执行（惰性求值/延迟加载）
//                                        System.out.println("中间操作：过滤");
//                                        return e.getAge() > 35;
//                                    });
//        //终止操作：一次性执行全部内容，即"惰性求值"
//        stream1.forEach(System.out::println);
//
//        //limit
//        employees.stream()
//                //过滤，money大于5000
//                .filter(e -> {
//                    System.out.println("---money > 5000---");
//                    return e.getMoney() > 5000;
//                })
//                //截断，截取2个（截取指定数量后，剩下的不会进行，提高效率）
//                .limit(2)
//                //终止操作
//                .forEach(System.out::println);
//
//        //skip
//        employees.stream()
//                .filter(e -> e.getMoney() > 5000)
//                //跳过，跳过前2个元素
//                .skip(2)
//                .forEach(System.out::println);
//
//        //distinct
//        employees.stream()
//            .filter(e -> e.getMoney() > 5000)
//            .skip(2)
//            //去重，去除重复元素（按照hashCode()和equals()去除重复元素，所以需要重写hashCode()和equals()）
//            .distinct()
//            .forEach(System.out::println);


//        //map
////        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
////
////        list.stream()
////            .map((str -> str.toUpperCase()))
////            .forEach(System.out::println);
////
////        System.out.println("------------------------------");
////
////        employees.stream()
////                .map(emp -> emp.getName())
////                .forEach(System.out::println);
////
////        //flatMap
////        Stream<Stream<Character>> stream = list.stream()
////                //list的每个元素都放入filterCharacter方法拆成char数组放到一个新的list的流中
////                .map(TestStream2::filterCharacter);
////        //遍历流，Stream<Stream<Character>> {[a,a,a],[b,b,b],[c,c,c],[d,d,d]}
////        stream.forEach((sm) -> {
////            //遍历流中的流，即Stream<Character> [a,a,a]
////            sm.forEach(System.out::println);
////        });
////
////        System.out.println("------------------------------");
////
////        Stream<Character> stream2 = list.stream()
////                //整合成一个流     {a,a,a,b,b,b,c,c,c,d,d,d}
////                .flatMap(TestStream2::filterCharacter);
////        stream2.forEach(System.out::println);


        //sorted()：按照默认规则进行排序
        List<String> list = Arrays.asList("bbb", "ddd", "aaa", "ccc");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------");

        employees.stream()
                //自定义排序规则
                .sorted((e1, e2) -> {
                    //年龄相同按姓名排
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        //按照年龄排序
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }



    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
}
