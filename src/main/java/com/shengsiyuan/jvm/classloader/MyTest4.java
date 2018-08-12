package com.shengsiyuan.jvm.classloader;

/**
 * 对于数组实例来说，其类型是由JVM运行期动态生成的，表示为[[Lcom.shengsiyuan.jvm.classloader.MyParent4;这种形式
 * 动态生成的类型，其父类型是Object
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是讲数组降低一个维度后的类型。
 *
 *
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();

        MyParent4[] myParent4s = new MyParent4[1];

        System.out.println(myParent4s.getClass());//class [Lcom.shengsiyuan.jvm.classloader.MyParent4;
        System.out.println(myParent4s.getClass().getClassLoader());

        System.out.println("========");

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());//class [[Lcom.shengsiyuan.jvm.classloader.MyParent4;
        System.out.println(myParent4s.getClass().getSuperclass());//class java.lang.Object

        System.out.println("========");

        int[] ints = new int[1];
        System.out.println(ints.getClass());//class [I
        System.out.println(ints.getClass().getSuperclass());//class java.lang.Object
    }
}

class MyParent4{
    static {

        System.out.println("Myparent4 static code");
    }

}