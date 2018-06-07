package com.shengsiyuan.jvm.classloader;

public class MyTest13 {
    public static void main(String[] args) {
        //系统类加载器是自定义加载器的双亲，也是启动应用的加载器

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while (null != classLoader) {
            classLoader = classLoader.getParent();

            System.out.println(classLoader);

        }
//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        sun.misc.Launcher$ExtClassLoader@7440e464
//        null
    }
}
