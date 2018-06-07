package com.shengsiyuan.jvm.classloader;

//Parent3 static block
//3
//do something

public class MyTest11 {
    static {
        System.out.println("MyTest11 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSomething();
    }
}

class Parent3{
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething(){
        System.out.println("do something");
    }
}

class Child3 extends Parent3{
    static int b = 4;

    static {
        System.out.println("Child3 static block");
    }
}