package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        MyTest16_3 loader2 = new MyTest16_3("loader2");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");//系统类加载器加载，会缓存起来
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");//这时发现系统类加载器已经加载过了MyTest19，所以直接使用之前加载过的

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);


    }
}
