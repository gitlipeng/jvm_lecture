package com.shengsiyuan.jvm.classloader;

public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by : " + this.getClass().getClassLoader());

        System.out.println("from MySample22: " + MyCat.class);

        new MyCat();

    }
}
