package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        loader1.setPath("/Users/lipeng/Desktop/");

        MyTest16_3 loader2 = new MyTest16_3("loader2");
        loader2.setPath("/Users/lipeng/Desktop/");

        //系统中没有，所以是loader1去加载，loader1就是MyPerson的定义类加载器（真正的加载字节码文件的加载器）
        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        //loader2在JVM中开辟新的内存空间，加载MyPerson的字节码文件，loader2是MyPerson的定义类加载器
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");

        //双亲委托关系来看 loader1和loader2没有任何关系，在JVM中是两个命名空间
        System.out.println(clazz1 == clazz2);//false

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);


    }
}
