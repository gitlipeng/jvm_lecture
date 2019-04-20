package com.shengsiyuan.jvm.memory;

/**
 jcm -l
 jcmd 12027 VM.flags  看到启动参数
 jcmd 12190 help 列出当前运行的Java进行可以执行的操作
 jcmd 12221 help JFR.dump：查看具体命令的选项有哪些
 jcmd 12252 PerfCounter.print:查看JVM性能相关参数
 jcm pid VM.uptime:查看JVM的启动时长
 jcmd 12315 GC.class_histogram:查看系统中类的统计信息
 jcmd pid Thread.print:查看线程堆栈信息
 jcmd 12786 GC.heap_dump /Users/lipeng/Desktop/hello.hprof : 导出Heap dump文件，导出的文件可以通过jvisualvm查看
 jcmd pid VM.system_properties:查看JVM的属性信息

 */
public class MyTest5 {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("hello test5");
        }
    }
}
