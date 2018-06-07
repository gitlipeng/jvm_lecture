package com.shengsiyuan.jvm.classloader;

public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());//null  //如果是启动类加载器（不一定是Java实现的）返回null

        Class<?> clazz2 = Class.forName("com.shengsiyuan.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}

class C{

}
