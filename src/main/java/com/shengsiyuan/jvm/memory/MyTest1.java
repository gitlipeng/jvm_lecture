package com.shengsiyuan.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 虚拟机栈：Stack Frame 栈帧（存储线程相关的，如局部变量表8个原生类型和引用类型） 线程独有的
 * 程序计数器（Program Counter)：标识当前的执行线程的行号  也是线程私有的
 * 本地方法栈：主要用于处理本地方法native，
 * 堆（Heap）：JVM管理的最大一块内存空间，与堆相关的一个重要的概念是垃圾收集器。现代几乎所有的垃圾收集器都是采用的分代收集算法，
 *    所以堆空间也基于这一点进行了相应的划分：新生代与老年代。Eden空间，From Sruvivor空间与To Survivor空间。堆空间在物理内存上不一定是连续的。
 * 方法区（Method Area）：存储元信息（关于class的、常量的）。永久代（Permanent Generation）从JDK1。8开始，已经彻底废弃了永久代。使用元空间（meata space)
 * 运行时常量池：方法区的一部分内容。与Java NIO密切相关，JVM通过堆上的DirectByteBuffer来操作直接内存。
 * 直接内存：Direct Memory


 关于Java对象创建的过程：

 new关键字创建对象的3个步骤：

 1. 在堆内存中创建出对象的实例
 2. 为对象的成员变量赋初始值
 3. 将对象的引用返回

 指针碰撞（前提是堆中的空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间）
 空闲列表（前提是堆内存空间中已被使用与未被使用的空间是交织在一起的，这时虚拟机就需要通过一个列表来记录哪些空间是可以使用的，哪些空间是
    已被使用的，接下来找出可以容纳下新创建对象且未被使用的空间，在此空间存放对象，同时还需要修改列表上的记录）

 对象在内存中的布局：

 1. 对象头
 2. 实例数据（即我们在一个类中所声明的各项信息）
 3. 对齐填充（可选）

 引用访问对象的方式：

 1. 使用句柄的方式
 2. 使用直接指针的方式

 设置堆的大小
 -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 转储
 工具 jvisualvm

 改一下：

 -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError

 */
public class MyTest1 {
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();

        for (; ; ) {
            list.add(new MyTest1());

            System.gc();
        }
    }

}
























