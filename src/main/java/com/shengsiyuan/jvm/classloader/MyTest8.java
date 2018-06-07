package com.shengsiyuan.jvm.classloader;

import java.util.Random;

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest{
    public static final int x = new Random().nextInt();
    static {
        System.out.println("static");
    }
}