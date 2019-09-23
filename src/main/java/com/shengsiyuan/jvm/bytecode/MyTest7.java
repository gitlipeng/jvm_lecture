package com.shengsiyuan.jvm.bytecode;

import java.util.Date;

/*
    针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table,vtable)
    针对于invokeinterface指令来说，虚拟机会建立一个叫接口方法表的数据结构（interface method table,itable)


    子类没有重写父类的那些方法，直接指向父类方法的入口地址，而不是再写一遍，提升效率，节省内存空间
    相同描述符的方法 索引是一样的，方便查询父类

 */
public class MyTest7 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal {
    public void test(String string) {
        System.out.println("animal str");
    }

    public void test(Date date) {
        System.out.println("animal data");
    }

}

class Dog extends Animal {
    public void test(String string) {
        System.out.println("Dog str");
    }

    public void test(Date date) {
        System.out.println("Dog data");
    }
}
