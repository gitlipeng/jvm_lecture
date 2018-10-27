package com.shengsiyuan.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

public class MyTest3 {

    //      stack=3, locals=4, args_size=1
    // stack 操作数栈最大深度3，先进后出，java处理都是堆栈的方式，栈阵，任何时刻所达到的最大深度（最多压入栈3个）
    // 4个局部变量 第一个this，第二个is，第三个serverSocket，第四个在catch中（编译器不知道到哪一个，但是最多只会进入一个）

    /**
     * Java字节码对于异常的处理方式：
     * 1. 统一采用异常表的方式来对异常进行处理
     * 2. 在jdk 1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式
     * 3. 当异常处理存在finally语句块时，现代化的JVM才去的处理方式是将finally语句块的字节码拼接到每一个catch块后面，换句话说
     *    程序中存在多少个catch块，就会在每一个catch块后面重复多少个finally语句块的字节码
     */

    /**
     * 抛出异常位置不一样不在code中
     * @throws IOException
     * @throws FileNotFoundException
     * @throws NullPointerException
     */

    public void test() throws IOException, FileNotFoundException,NullPointerException{
        try {
            /**
             *   0 new #2 <java/io/FileInputStream>
                 3 dup
                 4 ldc #3 <test.txt>
                 6 invokespecial #4 <java/io/FileInputStream.<init>>
                 9 astore_1
             */
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        } catch (FileNotFoundException e) {
//29 astore_1 引用赋值给局部变量，抛出的异常对象赋值给e
        } catch (IOException e) {

        } catch (Exception e) {

        } finally {

        }

    }
}
