package com.shengsiyuan.jvm.classloader;

class CL{
    static {
        System.out.println("Class CL");
    }
}
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("com.shengsiyuan.jvm.classloader.CL");

        System.out.println(clazz);

        System.out.println("--------------");

        clazz = Class.forName("com.shengsiyuan.jvm.classloader.CL");

        System.out.println(clazz);
    }
}

//class com.shengsiyuan.jvm.classloader.CL
//--------------
//Class CL
//class com.shengsiyuan.jvm.classloader.CL
