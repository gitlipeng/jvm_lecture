package com.shengsiyuan.jvm.classloader;

/*
    当前类加载器（Current Classloader)
    每个类都会使用自己的类加载器（即加载自身的类加载器）来去加载其他类（指的是所依赖的类）
    如果ClassX引用了ClassY，那么ClassX的类加载器就会去加载ClassY，前提是ClassY尚未被加载

    线程上下文类加载器（Context Classloader）
    线程上下文类加载器是从JDK 1.2开始引入的，类Thread中的getContextClassLoader()与setContextLoader(ClassLoader cl)
    分别用来获取和设置上下文类加载器。

    如果没有通过setContextLoader(ClassLoader cl)进行设置的话，线程将继承其父线程的上下文类加载器。
    Java应用运行时的初始线程的上下文类加载器是系统类加载器（Launcher$AppClassLoader）。在线程中运行的代码可以通过该类加载器来加载类和资源

    线程上下文加载器的重要性：



    数据库厂商根据自己的标准实现自己的实现，接口或类存在原生的JDK中



 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());

        System.out.println(MyPersons.class.getClassLoader());
    }
}

class MyPersons implements Runnable{

    @Override
    public void run() {

    }
}
