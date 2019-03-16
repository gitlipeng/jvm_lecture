package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        RealSubject realSubject = new RealSubject();
        InvocationHandler ds = new DynamicSubject(realSubject);
        Class<?> cls = realSubject.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
//        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
        try {
            subject.getName("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
