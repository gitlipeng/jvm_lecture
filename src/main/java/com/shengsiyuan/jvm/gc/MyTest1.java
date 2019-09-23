package com.shengsiyuan.jvm.gc;

/**
 -verbose:gc  输出详细垃圾回收日志
 -Xms20M
 -Xmx20M
 -Xmn10M 堆中新生代大小
 -XX:+PrintGCDetails  输出GC详细信息
 -XX:SurvivorRatio=8 代表8：1：1



 GC (Allocation Failure)：分配空间失败

 PSYoungGen: 6633K->608K(9216K)：Parallel Sc收集器
                                执行GC之前新生代对象占用的空间->执行完GC之后新生代对象占用的空间
                                    （新生代总的空间容量 8:1:1 有1M始终为空，为了复制，所以总的是8+1=9M）

 6633K->4712K(19456K):执行GC之前总的对象占用的空间->执行完GC之后总的存活对象占用的空间（总的堆的可用容量19M）

 0.0036608 secs:本次GC总耗时GC (Allocation Failure)：分配空间失败

 PSYoungGen: 6633K->608K(9216K)：Parallel Scavenge(新生代垃圾收集器)，执行GC之前新生代对象占用的空间->执行完GC之后新生代对象占用的空间（新生代总的空间容量 8:1:1 有1M始终为空，为了复制，所以总的是8+1=9M）

 6633K->4712K(19456K):执行GC之前总的对象占用的空间->执行完GC之后总的存活对象占用的空间（总的堆的可用容量19M）

 0.0036608 secs:本次GC总耗时
 [Times: user=0.00 sys=0.00, real=0.01 secs] ：user:用户空间 sys：内核空间 real：实际用的空间



 6633-608=6025 ：执行完GC后，新生代释放的空间容量

 6633-4712=1921：执行完GC后总的堆空间释放的容量

 6025-1921=4104：正好是老年代使用的空间大小
 [Times: user=0.00 sys=0.00, real=0.01 secs] ：user:用户空间 sys：内核空间 real：实际用的空间



 6633-608=6025 ：执行完GC后，新生代释放的空间容量

 6633-4712=1921：执行完GC后总的堆空间释放的容量

 6025-1921=4104：正好是老年代使用的空间大小


 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];

        System.out.println("hello world");
    }
}
