package com.shengsiyuan.jvm.memory;

/**
 线程栈溢出监控与分析详解
 设置栈的大小
 -Xss160k
 jconcole


 */
public class MyTest2 {
    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;
        try {
            System.out.println(this.length);
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Throwable ex) {
            System.out.println(myTest2.getLength());
            ex.printStackTrace();
        }

    }
}
