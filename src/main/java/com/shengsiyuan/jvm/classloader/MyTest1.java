package com.shengsiyuan.jvm.classloader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 *
 * -XX:开头
 * -XX:+<option>表示开启option选项
 * -XX:-<option>表示关闭option选项
 *
 * -XX:<option>=<value>表示将option选项的值设置为value
 */
public class MyTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyParent1 myParent2 = new MyChild1();
        System.out.println(myParent2.str);
    }
}
class MyParent1 {
    public    String str = "hello world";

    static {
        System.out.println("MyParent static block");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class MyChild1 extends MyParent1 {
    public String str = "mychild";
    static {
        System.out.println("MyChild1 static block");
    }

    @Override
    public String getStr() {
        return str;
    }

    @Override
    public void setStr(String str) {
        this.str = str;
    }
}
