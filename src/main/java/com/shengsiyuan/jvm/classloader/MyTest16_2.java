package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16_2 extends ClassLoader{
    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public MyTest16_2(String classLoaderName){
        /**
         * Creates a new class loader using the <tt>ClassLoader</tt> returned by
         * the method {@link #getSystemClassLoader()
         * <tt>getSystemClassLoader()</tt>} as the parent class loader.
         */
        super();//将系统类加载器当做该加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    private MyTest16_2(ClassLoader parent, String classLoaderName) {
        super(parent);//使用指定的parent作为委托
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
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

        className = className.replace(".", "/");


        try {
            is = new FileInputStream(new File(this.path + className + this.fileExtension));

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
        MyTest16_2 loader1 = new MyTest16_2("loader1");//初始类加载器

//        loader1.setPath("/Users/lipeng/workspace/jvm/jvm_lecture/out/production/classes/");
        loader1.setPath("/Users/lipeng/Desktop/");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());

        Object object = clazz.newInstance();
        System.out.println(object.getClass().getClassLoader());
        System.out.println("object:" + object.hashCode());
        System.out.println("-----------");

        MyTest16_2 loader2 = new MyTest16_2(loader1,"loader2");
        loader2.setPath("/Users/lipeng/Desktop/");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz2.hashCode());

        Object object2 = clazz2.newInstance();
        System.out.println(object2.getClass().getClassLoader());
        System.out.println("object2:" + object2.hashCode());
        System.out.println("object21:" + clazz2.newInstance().hashCode());

        System.out.println("-----------");

        MyTest16_2 loader3 = new MyTest16_2("loader3");
        loader3.setPath("/Users/lipeng/Desktop/");

        Class<?> clazz3 = loader3.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz3.hashCode());

        Object object3 = clazz3.newInstance();
        System.out.println(object3.getClass().getClassLoader());







    }


}


