package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/*
    当一个接口在初始化的时候，并不要求其父接口都完成了初始化
    只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
    增加vmoption看加载情况：-XX:+TraceClassLoading
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }

}

interface MyParent5{
//        public static int a  = new Random().nextInt(3);
    public static int b  = 7;
    public static Thread thread = new Thread(){
        //每个C的实例创建时都会执行一次
        {
            System.out.println("MyParent5 invoked");
        }
    };
}


interface MyChild5 extends MyParent5{
    public static int a  = new Random().nextInt(3);
    public static Thread thread = new Thread(){
        //每个C的实例创建时都会执行一次
        {
            System.out.println("MyChild5 invoked");
        }
    };
}


