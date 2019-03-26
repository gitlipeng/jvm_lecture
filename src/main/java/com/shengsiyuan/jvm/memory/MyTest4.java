package com.shengsiyuan.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
   方法区产生内存溢出错误

   -XX:MaxMetaspaceSize=10m

   Java 永久代去哪儿了: https://infoq.cn/article/Java-permgen-Removed
 */
public class MyTest4 {
    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);

            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj,method,args1,proxy) -> proxy.invokeSuper(obj,args1));

            System.out.println("Hello world");

            enhancer.create();
        }
    }
}
