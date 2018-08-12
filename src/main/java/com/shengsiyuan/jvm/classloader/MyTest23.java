package com.shengsiyuan.jvm.classloader;

import sun.misc.Launcher;

/**
 * 在运行期，一个Java类是由该类的完全限定名（binary name，二进制名）和用于加载该类的定义类加载器（defining loader）所共同决定的。
 * 如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件的字节码完全一样，并且从相同的位置加载亦如此
 *
 * java -Dsun.boot.class.path=./ com.shengsiyuan.jvm.classloader.MyTest23
 *
 * 在Oracle的HotSpot实现中，系统属性sun.boot.class.path如果修改错了，则运行会出错，提示如下信息：
 * java/lang/NoClassDefFoundError: java/lang/Object
 */
public class MyTest23 {
    public static void main(String[] args) {
        //根类加载器从哪加载
        // /Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/sunrsasign.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/classes
        System.out.println(System.getProperty("sun.boot.class.path"));

        //扩展类加载器
        // /Users/lipeng/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java
        System.out.println(System.getProperty("java.ext.dirs"));

        //系统类加载器 我们自己的out文件位置
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(Launcher.class.getClassLoader());

        System.out.println("-----------");

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16_3.class.getClassLoader());

        //java -Djava.system.class.loader=com.shengsiyuan.jvm.classloader.MyTest16_3 com.shengsiyuan.jvm.classloader.MyTest23
        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
