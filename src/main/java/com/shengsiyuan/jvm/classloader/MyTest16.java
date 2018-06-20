package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader{
    private String classLoaderName;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName){
        /**
         * Creates a new class loader using the <tt>ClassLoader</tt> returned by
         * the method {@link #getSystemClassLoader()
         * <tt>getSystemClassLoader()</tt>} as the parent class loader.
         */
        super();//将系统类加载器当做该加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    private MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//使用指定的parent作为委托
        this.classLoaderName = classLoaderName;
    }


    public Class<?> findClass(String className) {
        System.out.println("findClass invoked: " + className);
        System.out.println("classLoaderName: " + this.classLoaderName);

        byte[] b = loadClassData(className);
        return defineClass(className, b, 0, b.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            is = new FileInputStream(new File(className + this.fileExtension));

            baos = new ByteArrayOutputStream();

            int ch;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;

    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");//初始类加载器
        test(loader1);

    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2 定义类加载器
    }

}


