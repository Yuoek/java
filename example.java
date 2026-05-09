
// 包定义
package javasyntax;

// 导入核心类库
import java.util.*;
import java.io.*;

// ===================== 1. 自定义注解 =====================
@interface MyAnnotation {
    String value() default "默认注解";
}

// ===================== 2. 枚举类 =====================
enum Color {
    RED, GREEN, BLUE
}

// ===================== 3. 接口、函数式接口 =====================
@FunctionalInterface
interface MyFunc {
    void say();
}

interface Animal {
    // 常量
    String TYPE = "动物";
    // 抽象方法
    void cry();
    // 默认方法
    default void sleep() {
        System.out.println("动物睡觉");
    }
    // 静态方法
    static void showType() {
        System.out.println("这是动物接口");
    }
}

// ===================== 4. 抽象类 =====================
abstract class Person {
    // 成员变量、权限修饰符
    public String name;
    protected int age;
    private double height;
    // 常量
    public static final String NATION = "中国";

    // 构造方法
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 抽象方法
    public abstract void work();

    // 普通方法
    public void setHeight(double h) {
        height = h;
    }
    public double getHeight() {
        return height;
    }

    // 静态方法
    public static void hello() {
        System.out.println("静态方法 Hello");
    }
}

// ===================== 5. 子类继承、实现接口、多态、重写 =====================
@MyAnnotation("学生类")
class Student extends Person implements Animal {
    // 静态变量
    public static int count = 0;

    // 构造重载
    public Student() {
        count++;
    }
    public Student(String name, int age) {
        super(name, age);
        count++;
    }

    // 重写抽象方法
    @Override
    public void work() {
        System.out.println(name + " 在读书学习");
    }

    // 实现接口方法
    @Override
    public void cry() {
        System.out.println("学生小声哭泣");
    }

    // 方法重载
    public void study() {
        System.out.println("普通学习");
    }
    public void study(String subject) {
        System.out.println("学习科目：" + subject);
    }
}

// ===================== 6. 内部类、静态内部类 =====================
class Outer {
    private int a = 10;
    // 成员内部类
    class Inner {
        public void show() {
            System.out.println("内部类访问外部变量：" + a);
        }
    }
    // 静态内部类
    static class StaticInner {
        public void msg() {
            System.out.println("静态内部类");
        }
    }
}

// ===================== 7. 泛型类 =====================
class GenericDemo<T> {
    private T data;
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
}

// 主类
public class AllJavaSyntax {
    // 全局静态变量
    static int globalNum = 100;

    // ===================== 可变参数 =====================
    public static void varParam(int... nums) {
        System.out.print("可变参数：");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // ===================== 递归函数 =====================
    public static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // ===================== 异常测试 =====================
    public static void exceptionTest() throws Exception {
        throw new Exception("手动抛出异常");
    }

    // ===================== 线程测试 =====================
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("子线程执行");
        }
    }

    // ===================== 主方法入口 =====================
    public static void main(String[] args) {
        // -------- 1. 基础数据类型、变量、自动装箱拆箱 --------
        byte b = 1;
        short s = 2;
        int i = 10;
        long l = 100L;
        float f = 3.14f;
        double d = 6.28;
        char ch = 'A';
        boolean flag = true;
        // 包装类
        Integer num = 20;   // 自动装箱
        int unBox = num;    // 自动拆箱
        System.out.println("基础类型：" + b + " " + s + " " + i + " " + ch);

        // -------- 2. 运算符 --------
        System.out.println(10 + 3 * 2);
        System.out.println(10 > 5 && 3 < 8);
        System.out.println(5 ^ 3);
        // 三元运算符
        String res = i > 5 ? "大于5" : "小于等于5";
        System.out.println("三元运算：" + res);

        // -------- 3. 分支 if else / switch --------
        int score = 80;
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        Color c = Color.GREEN;
        switch (c) {
            case RED: System.out.println("红色"); break;
            case GREEN: System.out.println("绿色"); break;
            default: System.out.println("其他");
        }

        // -------- 4. 循环 for / while / do-while / break / continue --------
        for (int k = 0; k < 3; k++) {
            if (k == 1) continue;
            System.out.println("for循环：" + k);
        }

        int m = 0;
        while (m < 2) {
            System.out.println("while循环：" + m);
            m++;
        }

        int n = 0;
        do {
            System.out.println("do-while循环：" + n);
            n++;
        } while (n < 2);

        // -------- 5. 数组、二维数组 --------
        int[] arr = {1, 2, 3};
        int[][] arr2 = {{11, 22}, {33, 44}};
        System.out.println("二维数组：" + arr2[0][1]);

        // -------- 6. 面向对象、继承、多态、方法重载重写 --------
        Student stu = new Student("小明", 18);
        stu.work();
        stu.study();
        stu.study("Java");
        System.out.println("常量：" + Person.NATION);

        // 多态
        Animal animal = new Student();
        animal.cry();
        animal.sleep();
        Animal.showType();

        // -------- 7. 内部类 --------
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.msg();

        // -------- 8. 泛型 --------
        GenericDemo<String> g1 = new GenericDemo<>();
        g1.setData("泛型测试");
        System.out.println("泛型值：" + g1.getData());

        // -------- 9. 集合 List Set Map --------
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        System.out.println("List：" + list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println("Set：" + set);

        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 90);
        System.out.println("Map：" + map.get("语文"));

        // -------- 10. 可变参数、递归 --------
        varParam(10, 20, 30);
        System.out.println("递归斐波那契：" + fib(6));

        // -------- 11. Lambda 表达式、函数式接口 --------
        MyFunc mf = () -> System.out.println("Lambda 执行");
        mf.say();

        // -------- 12. 异常处理 try-catch-finally --------
        try {
            exceptionTest();
        } catch (Exception e) {
            System.out.println("捕获异常：" + e.getMessage());
        } finally {
            System.out.println("finally 必定执行");
        }

        // -------- 13. 线程 --------
        MyThread t = new MyThread();
        t.start();

        // -------- 14. try-with-resources 自动关闭流 --------
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("IO 流 try-with-resources 语法演示");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -------- 15. 枚举遍历 --------
        for (Color color : Color.values()) {
            System.out.println("枚举：" + color);
        }
    }
}
