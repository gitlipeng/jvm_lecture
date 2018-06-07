package com.shengsiyuan.jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass());//class [Ljava.lang.String;
        System.out.println(strings.getClass().getClassLoader());//null

        System.out.println("----------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("------------");

        int[] arrars = new int[23];
        System.out.println(arrars.getClass().getClassLoader());//null 但是代表没有类加载器
    }
}
