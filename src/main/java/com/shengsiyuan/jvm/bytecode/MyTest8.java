package com.shengsiyuan.jvm.bytecode;

/**
    现代JVM在执行Java代码的时候，通常都会将解释执行与编译执行二者结合起来进行

    所谓解释执行，就是通过解释器来读取字节码，遇到相应的指令就是执行该指令

    所谓编译执行，就是通过即时编译器（Just in Time,JIT)将字节码转换为本地机器码来执行，现代JVM会根据代码热点来生成
 相应的本地机器码


 基于栈的指令集与基于寄存器的指令集之间的关系：
    1. JVM执行指令时基于栈的指令集：内存中操作，有入栈和操作两种
        优点：可移植性好，字节码可以移植
        缺点：速度会慢些，指令数量多，入栈出栈操作可能寄存器一个指令就搞定了

    2. 基于寄存器的指令集：和硬件相关,不可移植， cpu，cpu高速缓冲区执行

    eg: 2-1
    1. iconst_1 将1压到栈顶
    2. iconst_2 将2压到栈顶
    3. isub 将栈顶和栈顶下面的一个元素弹出来，将栈顶-（栈顶-1）的结果在压入栈顶
    4. istroe_0 将栈顶元素放到局部变量表的store中

 */


public class MyTest8 {

    /*
    Code:
      stack=2(最大的栈的深度，最多放两个元素), locals=6（最大的局部变量数量6个）, args_size=1（参数数量为1 this）

     0 iconst_1：Push the int constant <i> (-1, 0, 1, 2, 3, 4 or 5) onto the operand stack.
     1 istore_1：istore_<n>，n必须是当前局部变量表的索引，操作数栈顶的值必须是int，将操作数栈定的这个值从栈中弹出，设置到索引为n的局部变量表中，这里是1的索引位置，0的位置放置了this
     2 iconst_2
     3 istore_2
     4 iconst_3
     5 istore_3
     6 iconst_4
     7 istore 4：这里没有下划线，istore_最大到istroe_3(简写）其实还是 istroe n ,istore:必须是无符号（0-255）
     9 iload_1：从局部变量中加载一个int值，n必须是局部变量的一个索引，位于n处的局部变量中的值会被push到栈中
    10 iload_2：2push到栈中，此时栈：2，1
    11 iadd：从操作数栈中弹出两个int值，相加，再push到栈中，此时栈：3
    12 iload_3：3push到栈中，此时栈：3，3
    13 isub：栈下面的元素-栈上面的元素
    14 iload 4
    16 imul
    17 istore 5
    19 iload 5
    21 ireturn：操作数栈中弹出，压入到调用者的栈帧中，其他值都会被丢弃掉

    */
    public int myCalculate() {
         int a = 1;
         int b = 2;
         int c = 3;
         int d = 4;

         int result = (a + b -c) * 4;

         return result;

    }
}
