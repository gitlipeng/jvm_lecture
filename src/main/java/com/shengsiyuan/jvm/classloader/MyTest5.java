package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/*
    当一个接口在初始化的时候，并不要求其父接口都完成了初始化
    只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
    增加vmoption看加载情况：-XX:+TraceClassLoading
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyParent5.thread);
    }
}


interface MyGradpa{
    public static int a = new Random().nextInt();
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGradpa invoked");
        }
    };
}

interface MyParent5 extends MyGradpa{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}








