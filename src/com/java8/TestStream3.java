package com.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @package_name: com.lambda
 * @name: TestStream3
 * @author: angenin
 * @dateTime: 2020/8/9 4:30 下午
 **/

//终止操作
public class TestStream3 {

    private static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 58, 5555.55, Employee.Status.BUSY),
            new Employee("王五", 26, 3333.33, Employee.Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Employee.Status.FREE),
            new Employee("田七", 12, 8888.88, Employee.Status.BUSY)
    );

    public static void main(String[] args) {
//        //终止操作
//
//        //allMatch
//        boolean b1 = employees.stream()
//                //检查所有元素是否符合条件，都符合才为true
//                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
//        System.out.println(b1);
//
//        //anyMatch
//        boolean b2 = employees.stream()
//                //检查所有元素是否有符合条件的元素，有一个符合就为true
//                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
//        System.out.println(b2);
//
//        //noneMatch
//        boolean b3 = employees.stream()
//                //检查所有元素是否都不符合条件，都不符合为true
//                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
//        System.out.println(b3);
//
//        //findFirst
//        Optional<Employee> first = employees.stream()
//                //按照工资排序
//                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
//                //获取第一个元素
//                .findFirst();
//        System.out.println(first.get());
//
//        //findAny
//        Optional<Employee> any = employees.parallelStream()
//                //过滤出所有空闲状态的员工
//                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
//                //随机获取一个员工
//                .findAny();
//        System.out.println(any);
//
//        //count
//        long count = employees.stream()
//                //查看总数
//                .count();
//        System.out.println(count);
//
//        //max
//        Optional<Employee> max = employees.stream()
//                //按照工资获取最大值
//                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
//        System.out.println(max.get());
//
//        //min
//        Optional<Double> min = employees.stream()
//                //提取所有的工资数据
//                .map(Employee::getSalary)
//                //获取最小值
//                .min(Double::compare);
//        System.out.println(min.get());


//        //reduce
//        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//        Integer sum = list.stream()
//                //合并，起始索引为0，执行操作相加
//                .reduce(0, (x, y) -> x + y);
//        System.out.println(sum);
//
//
//        Optional<Double> sum2 = employees.stream()
//                //提取所有的工资数据
//                .map(Employee::getSalary)
//                //合并，工资总和
//                .reduce(Double::sum);
//        System.out.println(sum2.get());


//        //collect
//        List<String> list = employees.stream()
//                                //获取所有名字数据
//                                .map(Employee::getName)
//                                //收集数据，并存放到list中
//                                .collect(Collectors.toList());
//        list.forEach(System.out::println);
//
//        System.out.println("-----------------------------");
//
//        //收集数据，并存放到set中
//        Set<String> set = employees.stream()
//                //获取所有名字数据
//                .map(Employee::getName)
//                .collect(Collectors.toSet());
//        set.forEach(System.out::println);
//
//        System.out.println("-----------------------------");
//
//        //收集数据，并存放到HashSet中
//        Set<String> hs = employees.stream()
//                //获取所有名字数据
//                .map(Employee::getName)
//                .collect(Collectors.toCollection(HashSet::new));
//        hs.forEach(System.out::println);
//
//        System.out.println("-----------------------------");
//
//        //总数
//        Long count = employees.stream()
//                .collect(Collectors.counting());
//        System.out.println(count);
//
//        System.out.println("-----------------------------");
//
//        //平均值
//        Double avg = employees.stream()
//                //工资的平均值
//                .collect(Collectors.averagingDouble(Employee::getSalary));
//        System.out.println(avg);
//
//        System.out.println("-----------------------------");
//
//        //总和
//        Double sum = employees.stream()
//                .collect(Collectors.summingDouble(Employee::getSalary));
//        System.out.println(sum);
//
//        //最大值
//        Optional<Employee> max = employees.stream()
//                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
//        System.out.println(max.get());
//
//        //最小值
//        Optional<Double> min = employees.stream()
//                .map(Employee::getSalary)
//                .collect(Collectors.minBy(Double::compare));
//        System.out.println(min.get());
//
//
//        //分组
//        Map<Employee.Status, List<Employee>> map = employees.stream()
//                //按照状态分组
//                .collect(Collectors.groupingBy(Employee::getStatus));
//        System.out.println(map);
//
//        //多级分组
//        Map<Employee.Status, Map<String, List<Employee>>> map2 = employees.stream()
//                //按状态分组后再按照年龄分
//                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
//                    if (e.getAge() <= 35) {
//                        return "青年";
//                    } else if (e.getAge() <= 50) {
//                        return "中年";
//                    } else {
//                        return "老年";
//                    }
//                })));
//        System.out.println(map2);
//
        //分区
        Map<Boolean, List<Employee>> map = employees.stream()
                //满足条件true一个区，不满足条件false一个区
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(map);

        //计算
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getCount());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());

        //连接
        String s = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
//                .collect(Collectors.joining(", "));
//                .collect(Collectors.joining(", ", "====", "===="));
        System.out.println(s);
    }

}
