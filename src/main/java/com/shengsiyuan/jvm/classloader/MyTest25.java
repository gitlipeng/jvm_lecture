package com.shengsiyuan.jvm.classloader;

public class MyTest25 implements Runnable{
    private Thread thread;

    public MyTest25() {
        this.thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        MyTest25 myTest25 = new MyTest25();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class : " + classLoader.getClass());
        System.out.println("Parent : " + classLoader.getParent());
    }
}
